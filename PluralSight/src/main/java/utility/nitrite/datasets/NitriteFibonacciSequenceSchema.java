package utility.nitrite.datasets;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.datasets.FibonacciSequence;
import utility.nitrite.NitriteSchema;
import utility.nitrite.entity.FibonacciNumber;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class NitriteFibonacciSequenceSchema implements NitriteSchema {

    private final static Logger log = LoggerFactory.getLogger(NitriteFibonacciSequenceSchema.class);

    @Override
    public void applySchema(Nitrite nitriteDatabase) {

        ObjectRepository<FibonacciNumber> fibonacciRepo = nitriteDatabase.getRepository(FibonacciNumber.class);
        AtomicInteger counter = new AtomicInteger();

        if (fibonacciRepo.find().totalCount() == 0) {

            FibonacciSequence.create(300).subscribe(
                    nextNumber -> {

                        if (counter.incrementAndGet() % 1000 == 0) {
                            log.info("Fibonacci numbers generating: {}", counter.get());
                        }

                        fibonacciRepo.insert(new FibonacciNumber(UUID.randomUUID(), nextNumber));
                    }
            );

        }
    }
}
