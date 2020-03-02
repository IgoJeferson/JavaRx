package operators.utility_operators;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class SkipWhileOperator {

    public static void main(String[] args) {

        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtility.postiveNumbers(10));

        positiveNumbers.skipWhile(integer -> integer < 4).subscribe(new DemoObserver());
    }
}
