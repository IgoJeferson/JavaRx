import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.GateBasedSynchronization;
import utility.nitrite.NO2;
import utility.nitrite.NitriteTestDatabase;
import utility.nitrite.NitriteUnitOfWorkWithResult;
import utility.nitrite.datasets.NitriteGreekAlphabetSchema;
import utility.nitrite.entity.LetterPair;
import utility.subscribers.DemoSubscriber;

import java.io.IOException;
import java.util.Optional;

public class ResourceExample1 {

    private static final Logger log = LoggerFactory.getLogger(ResourceExample1.class);

    public static void main(String[] args) {
        GateBasedSynchronization gate = new GateBasedSynchronization();

        Observable.using(
                ResourceExample1::resourceCreator,
                ResourceExample1::observableCreator,
                ResourceExample1::resourceDisposer)
                .subscribe(new DemoSubscriber<>(gate));
    }

    private static NitriteTestDatabase resourceCreator() {
        try {
            log.info("resource creator - opening database");
            return new NitriteTestDatabase(Optional.of(new NitriteGreekAlphabetSchema()));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static ObservableSource<LetterPair> observableCreator(NitriteTestDatabase inDatabase) {
        log.info("observableCreator - opening Observable");

        return NO2.execute(inDatabase.getNitriteDatabase(),
                (NitriteUnitOfWorkWithResult<ObservableSource<LetterPair>>) database ->
                        Observable.fromIterable(
                                database.getRepository(LetterPair.class).find()));
    }

    private static void resourceDisposer(NitriteTestDatabase database) {
        log.info("resourceDisposer - closing Observable");

        try {
            database.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
