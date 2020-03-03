package utility.nitrite.aggregate;

import io.reactivex.Observable;
import io.reactivex.Single;
import utility.nitrite.entity.Customer;
import utility.nitrite.entity.CustomerAddress;
import utility.nitrite.entity.Product;

public class CustomerAggregateOperations {

    public static Single<CustomerAggregate> aggregate(Observable<Object> customerPartObservable) {

        return customerPartObservable.collect(
                CustomerAggregate::new,
                (customerAggregate, nextObject) -> {
                    if (nextObject instanceof Customer) {
                        customerAggregate.setCustomer((Customer) nextObject);
                    } else if (nextObject instanceof CustomerAddress) {
                        customerAggregate.addCustomerAddress((CustomerAddress) nextObject);
                    } else if (nextObject instanceof Product) {
                        customerAggregate.addOwnedProduct((Product) nextObject);
                    }
                }
        );
    }
}
