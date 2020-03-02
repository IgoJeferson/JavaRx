package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;

public class DistinctOperator {

    // take only unique
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 2, 1, 4, 5, 6)
                .distinct().subscribe(new DemoObserver());
    }
}
