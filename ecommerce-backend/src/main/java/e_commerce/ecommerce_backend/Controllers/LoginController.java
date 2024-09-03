package e_commerce.ecommerce_backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.ecommerce_backend.Models.SignUpModel;
import e_commerce.ecommerce_backend.Services.LoginService;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired 
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> checkUser(@RequestBody SignUpModel loginModel){
        return loginService.login(loginModel);
    }
}
