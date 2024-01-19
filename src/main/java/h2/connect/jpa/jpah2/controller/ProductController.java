package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.Products;
import h2.connect.jpa.jpah2.model.dto.ProductDTo;
import h2.connect.jpa.jpah2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Product")
public class ProductController {
    private final ProductService productService;

    @Autowired

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTo> addProduct(@RequestBody final ProductDTo productDTo) {
        Products products = productService.addProduct(Products.from(productDTo));
        return new ResponseEntity<>(ProductDTo.from(products), HttpStatus.OK);

    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTo>> getAllProducts() {
        List<Products> products = productService.getAllProduct();
        List<ProductDTo> productDTos = products.stream().map(ProductDTo::from).collect(Collectors.toList());
        return new ResponseEntity<>(productDTos, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ProductDTo> getProductById(@PathVariable final long id) {
        Products products = productService.getProductById(id);
        return new ResponseEntity<>(ProductDTo.from(products), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ProductDTo> deleteProduct(@PathVariable final long id) {
        Products products = productService.deleteProduct(id);
        return new ResponseEntity<>(ProductDTo.from(products), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ProductDTo> editCustomer(@PathVariable final long id, @RequestBody final ProductDTo productDTo) {
        Products editedProduct = productService.editProduct(id, Products.from(productDTo));
        return new ResponseEntity<>(ProductDTo.from(editedProduct), HttpStatus.OK);
    }

    @PostMapping(value = "{card_id)/products/{product_id}/add")
    public ResponseEntity<ProductDTo> addProductToCartD(@PathVariable final long product_id,
                                                        @PathVariable final long cartD_id) {
        Products products = productService.addProductToCart(product_id, cartD_id);
        return new ResponseEntity<>(ProductDTo.from(products), HttpStatus.OK);
    }

    @DeleteMapping(value = "{card_id)/products/{product_id}/remove")
    public ResponseEntity<ProductDTo> removeProductFromCart(@PathVariable final long product_id,
                                                            @PathVariable final long cartD_id) {
        Products products = productService.removeProductFromCart(product_id, cartD_id);
        return new ResponseEntity<>(ProductDTo.from(products), HttpStatus.OK);
    }

    @PostMapping(value = "{oreder_id)/products/{product_id}/add")
    public ResponseEntity<ProductDTo> addProductToOrder(@PathVariable final long product_id,
                                                        @PathVariable final long orderD_id) {
        Products products = productService.addProductToOrder(product_id, orderD_id);
        return new ResponseEntity<>(ProductDTo.from(products), HttpStatus.OK);
    }

    @DeleteMapping(value = "{order_id)/products/{product_id}/remove")
    public ResponseEntity<ProductDTo> removeProductFromOrder(@PathVariable final long product_id,
                                                            @PathVariable final long orderD_id) {
        Products products = productService.removeProductFromOrder(product_id, orderD_id);
        return new ResponseEntity<>(ProductDTo.from(products), HttpStatus.OK);
    }

}
