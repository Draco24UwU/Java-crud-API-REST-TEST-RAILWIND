package com.apirest.example.apirest.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.example.apirest.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
