package jolt.template.controller;

import java.util.List;

import io.github.t1willi.annotations.Controller;
import io.github.t1willi.annotations.Get;
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
}
