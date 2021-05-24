package com.uol.products.repository;

import com.uol.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    boolean existsById(Long id);

    @Query(value = "SELECT  p" +
            "FROM products p " +
            "WHERE name like %?3% " +
            "OR description like %?3% " +
            "AND price BETWEEN ?1 AND ?2 ",
            nativeQuery = true)
    List<Product> filter(Double min_price, Double max_price, String q);
}
