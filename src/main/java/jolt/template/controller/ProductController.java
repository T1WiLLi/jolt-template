package jolt.template.controller;

import io.github.t1willi.annotations.Controller;
import io.github.t1willi.core.ApiController;
import io.github.t1willi.injector.annotation.Autowire;
import jolt.template.services.ProductService;

@Controller("[controller]s") // https://localhost/products
public class ProductController extends ApiController {

    @Autowire
    private ProductService productService;
}
