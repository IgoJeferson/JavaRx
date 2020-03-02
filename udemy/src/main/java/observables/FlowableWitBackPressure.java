package observables;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import observer.DemoObserver;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtility;

import java.util.concurrent.atomic.AtomicInteger;

public class FlowableWitBackPressure {
    private static final Logger logger = LoggerFactory.getLogger(FlowableWitBackPressure.class);

    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> flowable = Flowable.fromIterable(RxUtility.postiveNumbers(1000000))
                .repeat()
                .observeOn(Schedulers.newThread(), false, 5)
                .subscribeOn(Schedulers.newThread())
                .doOnNext(integer -> logger.info("emitting integer -> {} ", integer));

        flowable.subscribe(new Subscriber<Integer>() {

            private Subscription subscription;
            private AtomicInteger counter = new AtomicInteger(0);

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                logger.info("onSubscribe");
                subscription.request(5);
            }

            @Override
            public void onNext(Integer integer) {
                logger.info("onNext -> {} ", integer);
                if (counter.incrementAndGet() % 5 == 0) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    subscription.request(5);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                logger.info("onError -> {} ", throwable.getMessage());
            }

            @Override
            public void onComplete() {
                logger.info("onComplete");
            }
        });

        Thread.sleep(10000);
    }
}
