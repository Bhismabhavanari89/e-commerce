package e_commerce.ecommerce_backend.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.ecommerce_backend.Models.CartModel;
import e_commerce.ecommerce_backend.Services.CartService;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    public CartService cartService;

    @PostMapping(path = "/add")
    public ResponseEntity<?> addToCart(@RequestBody CartModel cartModel){
        return cartService.addCart(cartModel);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<?> updateToCart(@RequestBody CartModel cartModel){
        return cartService.updateCart(cartModel);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<?> deleteToCart(@RequestBody CartModel cartModel){
        return cartService.deleteCart(cartModel);
    }
}
