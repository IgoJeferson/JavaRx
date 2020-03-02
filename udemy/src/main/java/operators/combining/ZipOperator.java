package operators.combining;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class ZipOperator {

    // it will get only 3 events because for shape 4 and 5 we don't have positive number for zip
    public static void main(String[] args) {
        Observable shapes = Observable.fromIterable(RxUtility.shapes(5));
        Observable numbers = Observable.fromIterable(RxUtility.postiveNumbers(3));

        numbers.zipWith(shapes, (o, o2) -> o.toString() + ": " + o2.toString()).subscribe(new DemoObserver());
    }
}
