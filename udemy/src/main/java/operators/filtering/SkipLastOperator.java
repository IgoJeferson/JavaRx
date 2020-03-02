package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class SkipLastOperator {


    public static void main(String[] args) {
        Observable.fromIterable(RxUtility.postiveNumbers(10))
                .skipLast(5)
                .subscribe(new DemoObserver());
    }
}

