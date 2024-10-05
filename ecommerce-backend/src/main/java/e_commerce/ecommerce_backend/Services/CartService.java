package e_commerce.ecommerce_backend.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import e_commerce.ecommerce_backend.Models.CartModel;
import e_commerce.ecommerce_backend.Repos.CartRepo;

@Service
public class CartService {
    @Autowired
    public CartRepo cartRepo;

    public ResponseEntity<Map<String, String>> addCart(@RequestBody CartModel cartModel){
        Map<String, String> response = new HashMap<>();
        cartRepo.save(cartModel);
        response.put("message", "Cart details added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<Map<String, String>> updateCart(@RequestBody CartModel cartModel){
        Map<String, String> response = new HashMap<>();
        Optional<CartModel> cartDetails = cartRepo.findCartByMobileNumber(cartModel.getMobileNumber());
        if(cartDetails.isPresent()){
            CartModel cart = cartDetails.get();
            if(cart.getProductid().equals(cartModel.getProductid())){
                cart.setQuantity(cartModel.getQuantity());
                cartRepo.save(cart);
                response.put("message", "success");
            }
            else{
                response.put("message", "Product Details not match");
                return addCart(cartModel);
            }
        }
        else{
            response.put("message", "no ");
            return addCart(cartModel);
            
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    
    public ResponseEntity<Map<String, String>> deleteCart(@RequestBody CartModel cartModel){
        Map<String, String> response = new HashMap<>();
        Optional<CartModel> cartDetails = cartRepo.findCartByMobileNumber(cartModel.getMobileNumber());
        if (cartDetails.isPresent()) {
            CartModel cart = cartDetails.get();
            if(cart.getProductid().equals(cartModel.getProductid())){
                String id = cart.getId()+"";
                cartRepo.deleteById(id);
                response.put("message", "success");
            }
            else{
                response.put("message", "Product Details Not Match");
            }

        } else {
            response.put("message", "Cart not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    
}
