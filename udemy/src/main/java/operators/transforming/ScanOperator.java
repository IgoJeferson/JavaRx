package operators.transforming;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

import java.util.List;

//transmits items after applying a fct to modify the item but includes previous results as well
public class ScanOperator {

    public static void main(String[] args) {
        List<Integer> positiveNumbers = RxUtility.postiveNumbers(10);

        Observable.fromIterable(positiveNumbers).scan((integer, integer2) -> integer + integer2).subscribe(new DemoObserver());
    }
}
