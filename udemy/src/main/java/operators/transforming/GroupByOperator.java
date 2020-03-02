package operators.transforming;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;
import models.Shape;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtility;


//getting all shapes order by shape
public class GroupByOperator {
    private static final Logger logger = LoggerFactory.getLogger(GroupByOperator.class);

    public static void main(String[] args) throws InterruptedException {
        Observable.fromIterable(RxUtility.shapes(20))
                .groupBy((Function<Shape, Object>) shape -> shape.getShape()).observeOn(Schedulers.newThread()).subscribe(new Observer<GroupedObservable<Object, Shape>>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                logger.info("onSubscribe");
            }

            @Override
            public void onNext(GroupedObservable<Object, Shape> objectShapeGroupedObservable) {
                logger.info("key {}", objectShapeGroupedObservable.getKey());

                objectShapeGroupedObservable.subscribe(new DemoObserver());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
        Thread.sleep(10000);
    }
}
