package publisher;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class SubscriptionImpl implements Subscription {

    private static final int MAX_ITEMS = 10;
    private static Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private final Faker faker;
    private int count = 0;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.faker = Faker.instance();
        this.subscriber = subscriber;
    }

    @Override
    public void request(long requested) {
        if(isCancelled){
            return;
        }
        log.info("subscriber has requested {} items", requested);
        for (int i = 0 ; i < requested && count < MAX_ITEMS; i++){
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if(count == MAX_ITEMS){
            log.info("no more data to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("subscriber has cancelled");
        this.isCancelled=true;
    }
}
