package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class TakeLastOperator {


    public static void main(String[] args) {
        Observable.fromIterable(RxUtility.postiveNumbers(10))
                .takeLast(2)
                .subscribe(new DemoObserver());
    }
}
