package operators.utility_operators;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class TimeStampOperator {

    public static void main(String[] args) {
        Observable.fromIterable(RxUtility.shapes(10))
                .timestamp().subscribe(new DemoObserver());
    }
}
