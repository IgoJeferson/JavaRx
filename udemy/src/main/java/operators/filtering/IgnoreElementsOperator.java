package operators.filtering;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.LoggerFactory;
import utils.RxUtility;

public class IgnoreElementsOperator {

    public static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IgnoreElementsOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtility.primeNumbers(10))
                .ignoreElements()
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        Logger.info("onSubscribe");
                    }


                    @Override
                    public void onError(Throwable throwable) {
                        Logger.info("onError -> {} ", throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Logger.info("onComplete");
                    }
                });
    }
}
