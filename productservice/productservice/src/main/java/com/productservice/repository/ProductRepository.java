package com.productservice.repository;

import com.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select p.name from Product p where p.id = :id")
    String getNameById(Long id);

}
