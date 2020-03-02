package observables;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import models.Shape;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtility;

import java.util.List;

public class ObservableUsingCreate {

    private static final Logger logger = LoggerFactory.getLogger(ObservableUsingCreate.class);


    public static void main(String[] args) {
        List<Shape> shapes = RxUtility.shapes(20);

        Observable.create(observableEmitter -> {
            try {
                shapes.forEach(observableEmitter::onNext);
            } catch (Exception e) {
                observableEmitter.onError(e);
            }
            observableEmitter.onComplete();

        }).subscribe(new DemoObserver());

    }
}
