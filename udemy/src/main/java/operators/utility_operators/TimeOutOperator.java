package operators.utility_operators;

import io.reactivex.Observable;
import observer.DemoObserver;

import java.util.concurrent.TimeUnit;

public class TimeOutOperator {
    public static void main(String[] args) throws InterruptedException {
        Observable.timer(2, TimeUnit.SECONDS)
                .timeout(1, TimeUnit.SECONDS)
                .subscribe(new DemoObserver());

        Thread.sleep(3000);
    }
}
