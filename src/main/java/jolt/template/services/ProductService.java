package jolt.template.services;

import java.util.List;

import io.github.t1willi.form.Form;
import io.github.t1willi.injector.annotation.Bean;
import jolt.template.entities.Product;
import jolt.template.interfaces.IProductService;
import jolt.template.repositories.ProductBroker;
import jolt.template.validators.ProductValidator;

@Bean
public class ProductService implements IProductService {

    @Override
    public List<Product> getAll() {
        return new ProductBroker().findAll();
    }

    @Override
    public List<Product> getAllByCategory(String category) {
        return new ProductBroker().findByCategory(category);
    }

    @Override
    public Product getByName(String name) {
        return new ProductBroker().findByName(name);
    }

    @Override
    public Product getById(int id) {
        return new ProductBroker().findById(id).orElse(null);
    }

    @Override
    public Product save(Form form) {
        boolean isValid = new ProductValidator().validateCreation(form);
        Product product = null;
        if (isValid) {
            product = form.buildEntity(Product.class, "product_id", "created_at", "updated_at");
            new ProductBroker().save(product);
        }
        return product;
    }

    @Override
    public Product update(Form form, int id) {
        boolean isValid = new ProductValidator().validateUpdate(form);
        Product product = new ProductBroker().findById(id).orElse(null);
        if (isValid && product != null) {
            product = form.updateEntity(product, "product_id", "created_at", "updated_at");
            new ProductBroker().save(product);
        }
        return product;
    }

    @Override
    public boolean delete(int id) {
        return new ProductBroker().deleteById(id) != 0;
    }
}
