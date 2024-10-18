import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import publisher.PublisherImpl;
import reactor.core.publisher.Mono;
import subscriber.SubscriberImpl;

public class Demo {

    /// first subscribe is called and subscriber is passed
    /// second subsribe will make a new subscription object and pass subscriber to it in compostion relation (when subscription created, it myst be a subscriper)
    /// third subscribe will call subscribe.onSubscribe(subscription object) on aggeregation relation so when subscriper created it is not a necessary to create subscription but if subscriper need to subscripe, subscription object is a must (onSubscripe)
    /// fourh data will never be flown unless subscription request so we need access subscription from inside subscriper itself as my outside code, do not know any thing about subscription which made by publisher
    /// so we need add subscription to subscriber
    /// and vise verse as subscription handle subscriper function inside it(onComplete())

    public static void main(String[] args){
        Publisher publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
    }
}
