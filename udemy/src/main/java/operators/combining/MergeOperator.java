package operators.combining;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class MergeOperator {
    public static void main(String[] args) {
        Observable observable = Observable.fromIterable(RxUtility.shapes(6));
        Observable observable1 = Observable.fromIterable(RxUtility.postiveNumbers(5));

        Observable.merge(observable, observable1).subscribe(new DemoObserver());
    }
}
