package observables;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtility;

public class ObservableUsingDefer {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.defer(() -> Observable.fromIterable(RxUtility.postiveNumbers(5)));

        observable.subscribe(new DemoObserver());
    }
}
