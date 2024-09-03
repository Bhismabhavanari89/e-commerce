package e_commerce.ecommerce_backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import e_commerce.ecommerce_backend.Models.SignUpModel;

import java.util.Optional;

@Repository
public interface SignUpRepo extends JpaRepository<SignUpModel, String> {
    @Query("Select s from SignUpModel s where s.mobileNumber= ?1")
    Optional<SignUpModel> findUserByMobileNumber(String mobilenumber);
}
