package observables;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import observer.DemoObserver;
import utils.RxUtility;

public class ObservableWithoutBackPressure {

    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> positiveNumberEvents = Observable.fromIterable(RxUtility.postiveNumbers(1000000))
                .repeat()
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread());

        positiveNumberEvents.subscribe(new DemoObserver());

        Thread.sleep(10000);
    }
}
