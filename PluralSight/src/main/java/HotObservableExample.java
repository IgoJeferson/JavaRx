import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.GateBasedSynchronization;
import utility.ThreadHelper;
import utility.datasets.GreekAlphabet;
import utility.subscribers.DemoSubscriber;

import java.util.concurrent.TimeUnit;

public class HotObservableExample {

    private static Logger logger = LoggerFactory.getLogger(HotObservableExample.class);

    public static void main(String[] args) {
        GateBasedSynchronization gate = new GateBasedSynchronization();

        Observable<String> coldGreekAlphabet = GreekAlphabet.greekAlphabetInEnglishHotObservable(true)
                .take(49);

        ThreadHelper.sleep(2, TimeUnit.SECONDS);

        logger.info("Subscribing...");

        DemoSubscriber<String> subscriber = new DemoSubscriber<>(gate);

        coldGreekAlphabet.subscribe(subscriber);


        logger.info("Wait for subscriber to signal that is has finished");
        gate.waitForAny("onComplete", "onError");

        System.exit(0);

    }
}
