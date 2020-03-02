package operators.transforming;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class BufferOperator {

    public static void main(String[] args) {
        Observable.fromIterable(RxUtility.shapes(10))
                .buffer(3)
                .subscribe(new DemoObserver());
    }
}
