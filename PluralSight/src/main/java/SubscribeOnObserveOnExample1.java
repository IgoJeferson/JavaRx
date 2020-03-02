import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.GateBasedSynchronization;
import utility.datasets.FibonacciSequence;
import utility.subscribers.DemoSubscriber;

public class SubscribeOnObserveOnExample1 {

    private static Logger logger = LoggerFactory.getLogger(SubscribeOnObserveOnExample1.class);

    public static void main(String[] args) {
        GateBasedSynchronization gate = new GateBasedSynchronization();
        Observable<Long> fibonacciObservable = FibonacciSequence.create(10)
                .doOnSubscribe(disposable -> logger.info("fibonacciObservable::onSubscribe"));

        fibonacciObservable.subscribe(new DemoSubscriber<>(gate));

        gate.waitForAny("onError", "onComplete");
        logger.info("-----------------------------------------------");

        gate.resetAll();

        fibonacciObservable.subscribeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())
                .subscribe(new DemoSubscriber<>(gate));

        gate.waitForAny("onError", "onComplete");
        logger.info("-----------------------------------------------");

        gate.resetAll();

        fibonacciObservable.observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .subscribe(new DemoSubscriber<>(gate));

        gate.waitForAny("onError", "onComplete");
        logger.info("-------------------------------------------------");

        System.exit(0);
    }
}
