package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class TakeOperator {

    public static void main(String[] args) {
        Observable.fromIterable(RxUtility.postiveNumbers(10))
                .take(6)
                .subscribe(new DemoObserver());
    }
}
