package observer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoObserver implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(DemoObserver.class);

    public void onSubscribe(Disposable disposable) {
        logger.info("onSubscribe");
    }

    public void onNext(Object o) {
        logger.info("onNext -> {} ", o);
    }

    public void onError(Throwable throwable) {
        logger.info("onError -> {} ", throwable.getMessage());
    }

    public void onComplete() {
        logger.info("onComplete");
    }
}
