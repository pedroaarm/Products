package com.uol.products.service;

import com.uol.products.model.Product;
import com.uol.products.repository.ProductRepository;
import com.uol.products.utils.validations.ProductValidation;
import com.uol.products.utils.validations.ValidationsMensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;


@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductValidation productValidation;

    public Product save(Product product){
        productValidation.validate(product);

        return productRepository.saveAndFlush(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }


    public Product getById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        ValidationsMensagens.NOT_FOUND_PRODUCT.getDescricao()));

    }

    public Product updateProduct(Long id, Product product){
        productValidation.validate(product);

        if(productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.saveAndFlush(product);
        } else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    ValidationsMensagens.NOT_FOUND_PRODUCT.getDescricao());
        }
    }
    public void delete(Long id){
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    ValidationsMensagens.NOT_FOUND_PRODUCT.getDescricao());
    }

    public  List<Product> seach(Double min_price, Double max_price, String q){
        return productRepository.
                filter(min_price,max_price,q);

    }
}
