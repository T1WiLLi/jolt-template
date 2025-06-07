package jolt.template.repositories;

import java.util.List;
import java.util.Map;

import io.github.t1willi.database.RestBroker;
import jolt.template.entities.Product;

public class ProductBroker extends RestBroker<Integer, Product> {

    public ProductBroker() {
        super("products", Product.class, int.class);
    }

    public Product findByName(String name) {
        List<Product> products = findByCriteria(Map.of("name", name));
        return products.isEmpty() ? null : products.get(0);
    }

    public List<Product> findByCategory(String category) {
        return findByCriteria(Map.of("category", category));
    }
}