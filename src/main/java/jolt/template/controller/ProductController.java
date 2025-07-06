package jolt.template.controller;

import java.util.List;

import io.github.t1willi.annotations.Controller;
import io.github.t1willi.annotations.Delete;
import io.github.t1willi.annotations.Get;
import io.github.t1willi.annotations.Path;
import io.github.t1willi.annotations.Post;
import io.github.t1willi.annotations.Put;
import io.github.t1willi.annotations.Query;
import io.github.t1willi.annotations.ToForm;
import io.github.t1willi.core.ApiController;
import io.github.t1willi.form.Form;
import io.github.t1willi.http.HttpStatus;
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

    @Post
    public ResponseEntity<?> createProduct(@ToForm Form form) {
        Product product = this.productService.save(form);
        return product != null ? okJson(product).status(HttpStatus.CREATED)
                : notFound(form.errors());
    }

    @Put("{product_id}")
    public ResponseEntity<?> updateProduct(@ToForm Form form, @Path("product_id") int id) {
        Product product = this.productService.update(form, id);
        return product != null ? okJson(product).status(HttpStatus.CREATED)
                : notFound(form.errors());
    }

    @Delete("{id}")
    public ResponseEntity<String> deleteProduct(@Path int id) {
        boolean result = this.productService.delete(id);
        return result ? okJson("Produit supprimer") : notFound("Le produit n'a pas été supprimé");
    }

    private ResponseEntity<?> getProductResponse(Product product) {
        return product != null
                ? okJson(product)
                : notFound("Le produit n'a pas été trouvé");
    }
}
