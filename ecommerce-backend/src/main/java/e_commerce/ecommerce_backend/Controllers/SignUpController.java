package e_commerce.ecommerce_backend.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.ecommerce_backend.Models.SignUpModel;
import e_commerce.ecommerce_backend.Services.SignUpService;

@RestController
@RequestMapping(path = "/signup")
public class SignUpController {
    public final SignUpService signUpService;

    public SignUpController(SignUpService signUpService){
        this.signUpService = signUpService;
    }

    @PostMapping
    public ResponseEntity<?> registerNewUser(@RequestBody SignUpModel signUpModel){

        return  signUpService.addNewUser(signUpModel);
    }

}
