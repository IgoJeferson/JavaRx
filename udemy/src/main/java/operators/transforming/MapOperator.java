package operators.transforming;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class MapOperator {

    public static void main(String[] args) {
        Observable.fromIterable(RxUtility.postiveNumbers(10))
                .map(integer -> integer * 2)
                .subscribe(new DemoObserver());
    }
}
