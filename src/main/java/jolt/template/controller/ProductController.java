package jolt.template.controller;

import java.util.List;

import io.github.t1willi.annotations.Controller;
import io.github.t1willi.annotations.Get;
import io.github.t1willi.annotations.Path;
import io.github.t1willi.annotations.Query;
import io.github.t1willi.core.ApiController;
import io.github.t1willi.http.ResponseEntity;
import io.github.t1willi.injector.annotation.Autowire;
import jolt.template.entities.Product;
import jolt.template.interfaces.IProductService;

@Controller("[controller]s") // https://localhost/products
public class ProductController extends ApiController {

    @Autowire
    private IProductService productService;

    @Get
    public ResponseEntity<List<Product>> getProducts() {
        return okJson(this.productService.getAll());
    }

    @Get("/category")
    public ResponseEntity<List<Product>> getProductsByCategory(@Query String category) {
        return okJson(this.productService.getAllByCategory(category));
    }

    @Get("/name")
    public ResponseEntity<?> getProductByName(@Query String name) {
        return getProductResponse(this.productService.getByName(name));
    }

    @Get("{id}")
    public ResponseEntity<?> getProductById(@Path int id) {
        return getProductResponse(this.productService.getById(id));
    }

    private ResponseEntity<?> getProductResponse(Product product) {
        return product != null ? okJson(product) : notFound("Le produit n'a pas été trouvé");
    }
}
