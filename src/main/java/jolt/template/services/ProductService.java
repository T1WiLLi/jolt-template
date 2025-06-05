package jolt.template.services;

import java.util.List;

import io.github.t1willi.form.Form;
import io.github.t1willi.injector.annotation.Bean;
import jolt.template.entities.Product;
import jolt.template.interfaces.IProductService;
import jolt.template.repositories.ProductBroker;

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
        return null;
    }

    @Override
    public Product update(Form form) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return new ProductBroker().deleteById(id) != 0;
    }
}
