package com.demo.menuapi.service.product;

import com.demo.menuapi.model.dto.CreateProductDTO;
import com.demo.menuapi.model.dto.UpdateProductDTO;
import com.demo.menuapi.model.entity.Product;

import com.demo.menuapi.repository.ProductRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  implements  IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product createNewProduct(CreateProductDTO createProductDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(createProductDTO, product);
        return this.productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return this.productRepository.findById(id).orElseThrow(()-> new ClassCastException("Product not found"));
    }

    @Override
    public Product updateById(Integer id, UpdateProductDTO updateProductDTO) {
        Product product = this.productRepository.findById(id).orElseThrow(()-> new ClassCastException("Product not found"));

        product.setName(updateProductDTO.getName());
        product.setPrice(updateProductDTO.getPrice());
        product.setDescription(updateProductDTO.getDescription());
        return this.productRepository.saveAndFlush(product);
    }

    @Override
    public Void deleteById(Integer id) throws ClassNotFoundException {
        if (this.productRepository.existsById(id)) this.productRepository.deleteById(id);
        else throw new ClassNotFoundException("Product not found");
        return null;
    }
}
