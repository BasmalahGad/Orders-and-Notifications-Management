package com.onm.ordersandnotificationsmanagement.products.controllers;

import com.onm.ordersandnotificationsmanagement.products.models.Category;
import com.onm.ordersandnotificationsmanagement.products.models.Product;
import com.onm.ordersandnotificationsmanagement.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * The type Product controller.
 */
@RequestMapping("/product")
@RestController
public class ProductController {
    /**
     * The Product service.
     */
    @Autowired
    ProductService productService;

    /**
     * Add product response entity.
     *
     * @param product the product
     * @return the response entity
     */
    @PostMapping("/add")
    public ResponseEntity<ArrayList<Product>> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    /**
     * Remove product response entity.
     *
     * @param serialNumber the serial number
     * @return the response entity
     */
    @DeleteMapping("/remove/{serialNumber}")
    public ResponseEntity<ArrayList<Product>> removeProduct(@PathVariable("serialNumber") String serialNumber) {
        return ResponseEntity.ok(productService.removeProduct(serialNumber));
    }

    /**
     * List all products response entity.
     *
     * @return the response entity
     */
    @GetMapping("/list")
    public ResponseEntity<ArrayList<Product>> listAvailableProducts() {
        return ResponseEntity.ok(productService.listAvailableProducts());
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<Integer> countProducts(@PathVariable(value = "categoryName") Category category) {
        return ResponseEntity.ok(productService.countProducts(category));
    }
}
