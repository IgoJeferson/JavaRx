package operators.combining;

import io.reactivex.Observable;
import observer.DemoObserver;

import java.util.concurrent.TimeUnit;

public class CombiningLastestOperator {

    public static void main(String[] args) throws InterruptedException {
        Observable observable = Observable.interval(1000, TimeUnit.MILLISECONDS);
        Observable observable1 = Observable.interval(2000, TimeUnit.MILLISECONDS);

        Observable.combineLatest(observable, observable1, (o, o2) -> "first: " + o.toString() + " second " + o2.toString()).take(8).subscribe(new DemoObserver());
        Thread.sleep(10000);
    }
}
