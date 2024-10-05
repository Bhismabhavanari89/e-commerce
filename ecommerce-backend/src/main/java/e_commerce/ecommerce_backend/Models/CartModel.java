package e_commerce.ecommerce_backend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mobileNumber;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel productid;
    private String quantity;

    public CartModel(){

    }

    public CartModel(int id, String mobileNumber, ProductModel productid, String quantity){
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.productid = productid;
        this.quantity = quantity;
    }

    public CartModel(String mobileNumber, ProductModel productid, String quantity){
        this.mobileNumber = mobileNumber;
        this.productid = productid;
        this.quantity = quantity;
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
    
    public ProductModel getProductid() {
        return productid;
    }

    public void setProductid(ProductModel productid) {
        this.productid = productid;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
}
