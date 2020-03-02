package operators.utility_operators;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

import java.util.concurrent.TimeUnit;

public class DelayOperator {
    public static void main(String[] args) throws InterruptedException {
        Observable.fromIterable(RxUtility.postiveNumbers(10))
                .delay(2, TimeUnit.SECONDS)
                .subscribe(new DemoObserver());
        Thread.sleep(5000);
    }
}
