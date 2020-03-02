package observables;

import io.reactivex.Observable;
import observer.DemoObserver;

import java.util.concurrent.Callable;

public class ObservableUsingFrom {

    public static String doSomething() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello";
    }

    public static void main(String[] args) {

        // subscribe and after 2 seconds the onNext will be executed
        Callable<String> callable = () -> doSomething();

        Observable.fromCallable(callable)
                .subscribe(new DemoObserver());
    }
}
