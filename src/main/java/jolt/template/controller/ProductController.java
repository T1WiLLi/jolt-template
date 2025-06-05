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
import io.github.t1willi.openapi.annotations.ApiParameter;
import io.github.t1willi.openapi.annotations.ApiResponse;
import io.github.t1willi.openapi.annotations.Docs;
import jolt.template.entities.Product;
import jolt.template.interfaces.IProductService;

@Controller("[controller]s") // https://localhost/products
public class ProductController extends ApiController {

    @Autowire
    private IProductService productService;

    @Get
    @Docs(summary = "Get all products", description = "Retrieves a list of all available products", tags = {
            "Products" }, responses = {
                    @ApiResponse(code = 200, description = "Successfully retrieved products list", schema = Product[].class)
            })
    public ResponseEntity<List<Product>> getProducts() {
        return okJson(this.productService.getAll());
    }

    @Get("/category")
    @Docs(summary = "Get products by category", description = "Retrieves all products that belong to a specific category", tags = {
            "Products" }, parameters = {
                    @ApiParameter(name = "category", in = ApiParameter.In.QUERY, description = "Category name to filter products", required = true, type = String.class, example = "electronics")
            }, responses = {
                    @ApiResponse(code = 200, description = "Successfully retrieved products by category", schema = Product[].class)
            })
    public ResponseEntity<List<Product>> getProductsByCategory(@Query String category) {
        return okJson(this.productService.getAllByCategory(category));
    }

    @Get("/name")
    @Docs(summary = "Get product by name", description = "Retrieves a single product by its name", tags = {
            "Products" }, parameters = {
                    @ApiParameter(name = "name", in = ApiParameter.In.QUERY, description = "Product name to search for", required = true, type = String.class, example = "iPhone 15")
            }, responses = {
                    @ApiResponse(code = 200, description = "Product found successfully", schema = Product.class),
                    @ApiResponse(code = 404, description = "Product not found", contentType = "text/plain")
            })
    public ResponseEntity<?> getProductByName(@Query String name) {
        return getProductResponse(this.productService.getByName(name));
    }

    @Get("{id}")
    @Docs(summary = "Get product by ID", description = "Retrieves a single product by its unique identifier", tags = {
            "Products" }, parameters = {
                    @ApiParameter(name = "id", in = ApiParameter.In.PATH, description = "Product unique identifier", required = true, type = Integer.class, example = "1")
            }, responses = {
                    @ApiResponse(code = 200, description = "Product found successfully", schema = Product.class),
                    @ApiResponse(code = 404, description = "Product not found", contentType = "text/plain")
            })
    public ResponseEntity<?> getProductById(@Path int id) {
        return getProductResponse(this.productService.getById(id));
    }

    @Post
    @Docs(summary = "Create a new product", description = "Creates a new product with the provided information", tags = {
            "Products" }, requestDescription = "Product information form data", responses = {
                    @ApiResponse(code = 201, description = "Product created successfully", schema = Product.class),
                    @ApiResponse(code = 404, description = "Validation errors occurred", contentType = "application/json")
            })
    public ResponseEntity<?> createProduct(@ToForm Form form) {
        Product product = this.productService.save(form);
        return product != null ? okJson(product).status(HttpStatus.CREATED)
                : ResponseEntity.of(HttpStatus.NOT_FOUND, form.errors()).header("Content-Type", "application/json");
    }

    @Put("{product_id}")
    @Docs(summary = "Update an existing product", description = "Updates an existing product with the provided information", tags = {
            "Products" }, requestDescription = "Updated product information form data", parameters = {
                    @ApiParameter(name = "product_id", in = ApiParameter.In.PATH, description = "Product ID to update", required = true, type = Integer.class, example = "1")
            }, responses = {
                    @ApiResponse(code = 201, description = "Product updated successfully", schema = Product.class),
                    @ApiResponse(code = 404, description = "Product not found or validation errors", contentType = "application/json")
            })
    public ResponseEntity<?> updateProduct(@ToForm Form form, @Path("product_id") int id) {
        Product product = this.productService.update(form, id);
        return product != null ? okJson(product).status(HttpStatus.CREATED)
                : ResponseEntity.of(HttpStatus.NOT_FOUND, form.errors()).header("Content-Type", "application/json");
    }

    @Delete("{id}")
    @Docs(summary = "Delete a product", description = "Deletes a product by its unique identifier", tags = {
            "Products" }, parameters = {
                    @ApiParameter(name = "id", in = ApiParameter.In.PATH, description = "Product ID to delete", required = true, type = Integer.class, example = "1")
            }, responses = {
                    @ApiResponse(code = 200, description = "Product deleted successfully", schema = String.class),
                    @ApiResponse(code = 404, description = "Product not found", schema = String.class)
            })
    public ResponseEntity<String> deleteProduct(@Path int id) {
        boolean result = this.productService.delete(id);
        return result ? okJson("Product deleted") : notFound("Product not found");
    }

    private ResponseEntity<?> getProductResponse(Product product) {
        return product != null
                ? okJson(product)
                : ResponseEntity.of(HttpStatus.NOT_FOUND, "Le produit n'a pas été trouvé").header("Content-Type",
                        "text/plain");
    }
}
