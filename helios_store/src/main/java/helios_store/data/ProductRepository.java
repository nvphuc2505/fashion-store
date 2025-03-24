package helios_store.data;

import helios_store.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository
        extends CrudRepository<Product, Long> {

    Product findByName(String productName);

}
