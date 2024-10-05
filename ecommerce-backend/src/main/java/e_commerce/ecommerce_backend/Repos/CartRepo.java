package e_commerce.ecommerce_backend.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import e_commerce.ecommerce_backend.Models.CartModel;

@Repository
public interface CartRepo extends JpaRepository<CartModel, String>{
    @Query("Select c from CartModel c where c.mobileNumber= ?1")
    Optional<CartModel> findCartByMobileNumber(String mobileNumber);

}
