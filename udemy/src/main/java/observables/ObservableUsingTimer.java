package observables;


import io.reactivex.Observable;
import observer.DemoObserver;

import java.util.concurrent.TimeUnit;

//emits event after the specified time
public class ObservableUsingTimer {

    public static void main(String[] args) throws InterruptedException {
        Observable.timer(5, TimeUnit.SECONDS)
                .subscribe(new DemoObserver());
        Thread.sleep(7000);
    }
}
