package operators.utility_operators;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtility;

public class ContainsOperator {

    public static final Logger logger = LoggerFactory.getLogger(ContainsOperator.class);

    public static void main(String[] args) {
        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtility.postiveNumbers(10));
        positiveNumbers.contains(10).subscribe(new SingleObserver<Boolean>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                logger.info("onSubscribe");
            }

            @Override
            public void onSuccess(Boolean aBoolean) {
                logger.info("Element is present {} ", aBoolean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
