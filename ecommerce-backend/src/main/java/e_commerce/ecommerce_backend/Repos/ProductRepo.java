package e_commerce.ecommerce_backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.ecommerce_backend.Models.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel,String> {
    
}
