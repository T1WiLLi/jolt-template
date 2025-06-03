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

    }

    @Override
    public List<Product> getAllByCategory(String category) {

    }

    @Override
    public Product getProductById(int id) {

    }

    @Override
    public Product getProductByName(String name) {

    }

    @Override
    public Product save(Form form) {

    }

    @Override
    public Product update(Form form) {

    }

    @Override
    public void delete(int id) {

    }
}
