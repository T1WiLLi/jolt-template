package jolt.template.services;

import java.util.List;

import io.github.t1willi.form.Form;
import io.github.t1willi.injector.annotation.Bean;
import jolt.template.entities.Product;
import jolt.template.interfaces.IProductService;

@Bean
public class ProductService implements IProductService {

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getAllByCategory(String category) {
        return null;
    }

    public Product getByName(String name) {
        return null;
    }

    @Override
    public Product getById(int id) {
        return null;
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
    public void delete(int id) {
        // no-op
    }
}
