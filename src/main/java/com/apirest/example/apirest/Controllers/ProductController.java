package com.apirest.example.apirest.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.example.apirest.Repositories.ProductRepository;
import com.apirest.example.apirest.Entities.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).
        orElseThrow(()-> new RuntimeException("Producto con el ID solicitado no encontrado"));

    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct){

        Product product = productRepository.findById(id).
        orElseThrow(()-> new RuntimeException("Producto con el ID solicitado no encontrado"));

        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());

        return productRepository.save(product);
        
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){

        Product product = productRepository.findById(id).
        orElseThrow(()-> new RuntimeException("Producto con el ID solicitado no encontrado"));

        productRepository.delete(product);

        return "El producto " + product.getName() + " con ID: " + id + " a sido eliminado exitosamente";
    }   


}
