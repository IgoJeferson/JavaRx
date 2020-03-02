package operators.filtering;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.LoggerFactory;
import utils.RxUtility;

public class ElementAtOperator {

    public static final org.slf4j.Logger Logger = LoggerFactory.getLogger(ElementAtOperator.class);


    public static void main(String[] args) {
        Observable.fromIterable(RxUtility.postiveNumbers(10)
        ).elementAt(12).subscribe(new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                Logger.info("onSubscribe");
            }

            @Override
            public void onSuccess(Integer integer) {
                Logger.info("onSuccess -> {} ", integer);
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
