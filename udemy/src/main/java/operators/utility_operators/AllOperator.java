package operators.utility_operators;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtility;

public class AllOperator {

    public static final Logger logger = LoggerFactory.getLogger(AllOperator.class);

    public static void main(String[] args) {
        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtility.postiveNumbers(10));
        positiveNumbers.all(
                integer -> integer > 5
        ).subscribe(new SingleObserver<Boolean>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                logger.info("onSubscribe");
            }

            @Override
            public void onSuccess(Boolean aBoolean) {
                logger.info("Do all of the events are grater than 5 {} ", aBoolean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
