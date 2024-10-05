package e_commerce.ecommerce_backend.Services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import e_commerce.ecommerce_backend.Models.ProductModel;
import e_commerce.ecommerce_backend.Repos.ProductRepo;

@Service
public class ProductService {
    @Autowired
    public ProductRepo productRepo;
    
    public ResponseEntity<Map<String,String>> addproduct(@RequestBody ProductModel productModel){
        Map<String, String> response = new HashMap<>();
        productRepo.save(productModel);
        response.put("message", "Cart details added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<Map<String,Object>> viewproducts(){
        Map<String, Object> response = new HashMap<>();
        response.put("products", productRepo.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String,String>> deleteProductById(String id){
        Map<String, String> response = new HashMap<>();
        if(productRepo.existsById(id)){
            productRepo.deleteById(id);
            response.put("message", "Deleted for id "+id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.put("products", "Not Found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
