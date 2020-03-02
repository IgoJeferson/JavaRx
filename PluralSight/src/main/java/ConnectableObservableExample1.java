import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.GateBasedSynchronization;
import utility.ThreadHelper;
import utility.datasets.FibonacciSequence;
import utility.subscribers.DemoSubscriber;

import java.util.concurrent.TimeUnit;

public class ConnectableObservableExample1 {

    private final static Logger logger = LoggerFactory.getLogger(ConnectableObservableExample1.class);

    public static void main(String[] args) {
        GateBasedSynchronization gate1 = new GateBasedSynchronization();
        GateBasedSynchronization gate2 = new GateBasedSynchronization();

        ConnectableObservable<Long> fibonacciSequence = FibonacciSequence.create(20)
                .subscribeOn(Schedulers.computation())
                .publish();

        DemoSubscriber<Long> subscriber1 = new DemoSubscriber<>(gate1);
        DemoSubscriber<Long> subscriber2 = new DemoSubscriber<>(gate2);

        fibonacciSequence.subscribe(subscriber1);
        fibonacciSequence.subscribe(subscriber2);

        ThreadHelper.sleep(2, TimeUnit.SECONDS);

        fibonacciSequence.connect();

        GateBasedSynchronization.waitMultiple(new String[]{"onComplete", "onError"}, gate1, gate2);

        System.exit(0);


    }
}
