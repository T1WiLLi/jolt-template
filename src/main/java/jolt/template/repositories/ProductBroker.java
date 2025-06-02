package jolt.template.repositories;

import io.github.t1willi.database.RestBroker;
import jolt.template.entities.Product;

public class ProductBroker extends RestBroker<Integer, Product> {

    protected ProductBroker() {
        super("products", Product.class, int.class);
    }
}