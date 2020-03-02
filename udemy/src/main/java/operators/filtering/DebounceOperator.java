package operators.filtering;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DebounceOperator {

    private static Logger logger = LoggerFactory.getLogger(DebounceOperator.class);

    private static List<Character> characters = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        Observable.interval(2, TimeUnit.SECONDS)
                .map(ch -> {
                    characters.add((char) (random.nextInt(26) + 'a'));
                    return characters;
                }).doOnEach(notification -> {
            logger.info("Current value -> {}", notification);
        })
                .debounce(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new DemoObserver());

        Thread.sleep(10000);
    }
}
