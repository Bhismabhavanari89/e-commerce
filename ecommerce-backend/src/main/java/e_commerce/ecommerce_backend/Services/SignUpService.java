package e_commerce.ecommerce_backend.Services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import e_commerce.ecommerce_backend.Models.SignUpModel;
import e_commerce.ecommerce_backend.Repos.SignUpRepo;

@Service
public class SignUpService {

    private final SignUpRepo signUpRepo;


    @Autowired
    public SignUpService(SignUpRepo signUpRepo){
        this.signUpRepo = signUpRepo;
    }

    public List<SignUpModel> getUserDetails(){
        return signUpRepo.findAll();
    }

    public ResponseEntity<Map<String, String>> addNewUser(@RequestBody SignUpModel signUpModel) {
        Optional<SignUpModel> userdetails = signUpRepo.findUserByMobileNumber(signUpModel.getMobileNumber());
        Map<String, String> response = new HashMap<>();
        if (userdetails.isPresent()) {
            response.put("message", "User exists with this mobile number");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);

        }

        signUpRepo.save(signUpModel);
        response.put("message", "User details saved");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
