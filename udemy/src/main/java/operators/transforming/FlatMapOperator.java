package operators.transforming;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

import java.util.List;

public class FlatMapOperator {

    public static void main(String[] args) {
        List<Integer> positiveNumbers = RxUtility.postiveNumbers(10);

        Observable.fromIterable(positiveNumbers)
                .flatMap(integer -> twice(integer)).subscribe(new DemoObserver());
    }

    public static Observable<Integer> twice(Integer integer) {
        return Observable.create(observableEmitter -> {
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onNext(integer * 2);
            } else {
                observableEmitter.onComplete();
            }
        });
    }
}
