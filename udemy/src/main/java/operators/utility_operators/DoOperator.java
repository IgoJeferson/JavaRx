package operators.utility_operators;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtility;

public class DoOperator {
    public static final Logger logger = LoggerFactory.getLogger(DoOperator.class);

    public static void main(String[] args) throws InterruptedException {
        Observable.fromIterable(RxUtility.shapes(10))
                .doOnSubscribe(disposable -> logger.info("Stream is subscribed"))
                .doOnEach(shapeNotification -> logger.info("current value {}", shapeNotification.getValue()))
                .doOnNext(shape -> logger.info("Shape is : {} ", shape))
                .doOnComplete(() -> logger.info("Completed"))
                .subscribe(new DemoObserver());

        Thread.sleep(5000);
    }
}
