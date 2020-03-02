package operators.filtering;

import io.reactivex.Observable;
import models.Shape;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtility;

import java.util.List;

public class FilterOperator {

    public static final Logger Logger = LoggerFactory.getLogger(ElementAtOperator.class);

    public static void main(String[] args) {

        List<Shape> shapes = RxUtility.shapes(10);
        for (Shape shape : shapes) {
            Logger.info("shape -> {} ", shape);
        }
        Observable.fromIterable(shapes)
                .filter(shape -> shape.getColor().equals("blue")).subscribe(new DemoObserver());
    }
}
