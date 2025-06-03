package jolt.template.interfaces;

import java.util.List;

import io.github.t1willi.form.Form;
import jolt.template.entities.Product;

public interface IProductService {

    public List<Product> getAll();

    public List<Product> getAllByCategory(String category);

    public Product getById(int id);

    public Product getByName(String name);

    public Product save(Form form);

    public Product update(Form form);

    public void delete(int id);
}
