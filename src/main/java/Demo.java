import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Slf4j
public class Demo {

    public static void main(String[] args){
//        Mono<String> mono = Mono.just("Mohamed");
//
//        // Mono is one of implementation for publisher
//        Publisher<String> mono2 = Mono.just("Mohamed");
//
//        /// It will print MonoJust (The type of variable go to section 1.1 in your red note)
//        /// remeber that reactor like stream is lazy, as stream need to terminate method to work, reactor (publisher) need to be subscribed
//        System.out.println(mono);
//
//        SubscriberImpl subscriber = new SubscriberImpl();
//        mono.subscribe(subscriber);
//
//        /// Also it will not work we need request
//        subscriber.getSubscription().request(5);


        /// Here you can not sever make at Publisher<Integer> as its subscribe method need full implementation for Subsriber interface which is not functional interface
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(i -> log.info("recieved: {}", i));
    }
}
