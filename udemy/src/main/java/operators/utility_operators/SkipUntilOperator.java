package operators.utility_operators;

import io.reactivex.Observable;
import observer.DemoObserver;

import java.util.concurrent.TimeUnit;

public class SkipUntilOperator {

    public static void main(String[] args) throws InterruptedException {
        Observable singleSecond = Observable.interval(1, TimeUnit.SECONDS);
        Observable fiveSecond = Observable.interval(5, TimeUnit.SECONDS);

        singleSecond.skipUntil(fiveSecond).subscribe(new DemoObserver());

        Thread.sleep(12000);
    }
}
