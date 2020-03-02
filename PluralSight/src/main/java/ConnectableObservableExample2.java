import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.GateBasedSynchronization;
import utility.ThreadHelper;
import utility.datasets.FibonacciSequence;
import utility.subscribers.DemoSubscriber;

import java.util.concurrent.TimeUnit;

public class ConnectableObservableExample2 {

    private final static Logger logger = LoggerFactory.getLogger(ConnectableObservableExample2.class);

    public static void main(String[] args) {
        Observable<Long> intervalSequence = Observable.interval(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .doOnNext(nextLong -> logger.info("doOnNext - {} ", nextLong))
                .publish()
                .refCount();

        DemoSubscriber<Long> demoSubscriber1 = new DemoSubscriber<>();
        DemoSubscriber<Long> demoSubscriber2 = new DemoSubscriber<>();

        intervalSequence.subscribe(demoSubscriber1);
        intervalSequence.subscribe(demoSubscriber2);

        ThreadHelper.sleep(2, TimeUnit.SECONDS);

        demoSubscriber1.dispose();

        ThreadHelper.sleep(2, TimeUnit.SECONDS);

        demoSubscriber2.dispose();

        logger.info("Pausing for 2 seconds...");
        ThreadHelper.sleep(2, TimeUnit.SECONDS);
        logger.info("...pause complete");

        ThreadHelper.sleep(2, TimeUnit.SECONDS);
        System.exit(0);


    }
}
