package observables;

import io.reactivex.Observable;
import observer.DemoObserver;

import java.util.concurrent.TimeUnit;

// emits sequence of integer at regular interval
// ideal for repetitive jobs
public class ObservableUsingInterval {

    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new DemoObserver());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
