package com.uol.products.controller;


import com.uol.products.model.Product;
import com.uol.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAvailability(){

        return productService.getAll();
    }

    @GetMapping(value = "/{id}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Product postAvailability(@RequestBody Product product){

        return productService.save(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product update(@PathVariable Long id,
                                 @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){

        productService.delete(id);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam("min_price") Double min_price,
                                @RequestParam("max_price") Double max_price,
                                @RequestParam("q") String q) {
        return productService.seach(min_price,max_price,q);
    }
}
