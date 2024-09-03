package e_commerce.ecommerce_backend.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import e_commerce.ecommerce_backend.Models.SignUpModel;
import e_commerce.ecommerce_backend.Repos.SignUpRepo;

@Service
public class LoginService {

    @Autowired
    private SignUpRepo signUpRepo;

    public ResponseEntity<Map<String, String>> login(@RequestBody SignUpModel loginModel){
        Optional<SignUpModel> userdetails = signUpRepo.findUserByMobileNumber(loginModel.getMobileNumber());
        Map<String, String> response = new HashMap<>();
        if (userdetails.isPresent()) {
            SignUpModel user = userdetails.get();
            if(user.getPassword().equals(loginModel.getPassword())){
                response.put("message", "success");
            }
            else{
                response.put("message", "Invalid credentials");
            }
        }
        else{
            response.put("message", "Not Found");
        }
        return new ResponseEntity<>(response, HttpStatus.OK); // Changed status to OK
    }

}
