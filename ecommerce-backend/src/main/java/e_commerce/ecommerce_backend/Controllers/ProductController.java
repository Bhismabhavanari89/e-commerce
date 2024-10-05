package e_commerce.ecommerce_backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.ecommerce_backend.Models.ProductModel;
import e_commerce.ecommerce_backend.Services.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    public ProductService productService;

    @PostMapping(path = "/add")
    public ResponseEntity<?> addToProducts(@RequestBody ProductModel productModel){
        return productService.addproduct(productModel);
    }

    @PostMapping(path = "/view")
    public ResponseEntity<?> viewAllProducts(){
        return productService.viewproducts();
    }

    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable String id){
        return productService.deleteProductById(id);
    }
}
