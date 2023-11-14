package com.demo.menuapi.controller;

import com.demo.menuapi.model.dto.CreateProductDTO;
import com.demo.menuapi.model.dto.UpdateProductDTO;
import com.demo.menuapi.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<?> createNewProduct (@RequestBody CreateProductDTO createProductDTO) {
        return ResponseEntity.ok(this.productService.createNewProduct(createProductDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct (
            @PathVariable Integer id,
            @RequestBody UpdateProductDTO updateProductDTO
    ) throws ClassNotFoundException {
        return ResponseEntity.ok(this.productService.updateById(id, updateProductDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById (@PathVariable Integer id) throws ClassNotFoundException {
        this.productService.deleteById(id);
        return ResponseEntity.ok("Product Deleted Successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById (@PathVariable Integer id) throws ClassNotFoundException {
        return ResponseEntity.ok(this.productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll () {
        return ResponseEntity.ok(this.productService.findAll());
    }


}
