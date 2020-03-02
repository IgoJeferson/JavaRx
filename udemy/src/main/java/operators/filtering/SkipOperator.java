package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class SkipOperator {


    public static void main(String[] args) {
        Observable.fromIterable(RxUtility.postiveNumbers(10))
                .skip(5)
                .subscribe(new DemoObserver());
    }
}
