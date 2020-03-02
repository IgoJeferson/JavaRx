package observables;


import io.reactivex.Observable;
import observer.DemoObserver;

// emits range of elements
public class ObservableUsingRange {


    public static void main(String[] args) {
        Observable.range(2, 10)
                .subscribe(new DemoObserver());
    }
}
