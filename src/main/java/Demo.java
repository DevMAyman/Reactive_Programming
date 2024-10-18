import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

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
        Mono<Integer> mono2 = Mono.just(1);

        Mono<String> mono3 = Mono.just(1)
                                    .map(i -> i+"a");




//        public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> errorConsumer, @Nullable Runnable completeConsumer) {
//            return this.subscribe(consumer, errorConsumer, completeConsumer, (Context)null);
//        }

        // here by default .request will be called in onSubscribe
        mono.subscribe(
                // First functional interface for onNext by default
                i -> log.info("recieved: {}", i),
                // Second for functional interface for onError
                err -> log.error("error", err),
                // Second for functional interface for onCompleted
                () -> log.info("completed")
        );


        // If you need your subscription object and make request mannualy
        mono2.subscribe(
                // First functional interface for onNext by default
                i -> log.info("recieved: {}", i),
                // Second for functional interface for onError
                err -> log.error("error", err),
                // Second for functional interface for onCompleted
                () -> log.info("completed"),
                // You can also cancel
                subscription -> subscription.request(1)
        );
    }
}
