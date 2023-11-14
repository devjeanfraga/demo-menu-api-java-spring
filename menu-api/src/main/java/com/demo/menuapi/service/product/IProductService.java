package com.demo.menuapi.service.product;

import com.demo.menuapi.model.dto.CreateProductDTO;
import com.demo.menuapi.model.dto.UpdateProductDTO;
import com.demo.menuapi.model.entity.Product;

import java.util.List;

public interface IProductService {
    Product createNewProduct (CreateProductDTO createProductDTO);
    List<Product> findAll();

    Product findById (Integer id);

    Product updateById (Integer id, UpdateProductDTO updateProductDTO);

    Void deleteById (Integer id) throws ClassNotFoundException;
}
