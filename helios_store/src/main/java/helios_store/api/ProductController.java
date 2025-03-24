package helios_store.api;

import helios_store.data.ProductRepository;
import helios_store.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/public/collections")
    public Iterable<Product> fetchAllCollections() {
        return productRepository.findAll();
    }

    @PostMapping("/private/create-product")
    public Product postProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PatchMapping("/private/update-product/{id}")
    public Product patchProduct(@PathVariable Long id,
                                @RequestBody Product patchProduct) {

        Product newProduct = productRepository.findById(id).get();

        if (patchProduct.getName() != null)
            newProduct.setName(patchProduct.getName());

        if (patchProduct.getSize() != null)
            newProduct.setSize(patchProduct.getSize());

        if (patchProduct.getQuantity() != null)
            newProduct.setQuantity(patchProduct.getQuantity());

        if (patchProduct.getPrice() != null)
            newProduct.setPrice(patchProduct.getPrice());

        return productRepository.save(newProduct);
    }

}
