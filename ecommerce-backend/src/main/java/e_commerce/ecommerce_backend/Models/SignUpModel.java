package e_commerce.ecommerce_backend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SignUpModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mobileNumber;
    private String name;
    private String password;

    public SignUpModel(){

    }

    public SignUpModel(int id, String mobileNumber, String name, String password){
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.password = password;
    }

    public SignUpModel(String mobileNumber, String name, String password){
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "SignUp{" +
                "id = "+id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                "}";
    }

}
