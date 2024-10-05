package e_commerce.ecommerce_backend.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double sellingprice;
    private Double originalprice;
    private Double quantity;
    private String description;
    private String images;

    public ProductModel(){

    }

    public ProductModel(int id, String name, Double sellingprice, Double originalprice, Double quantity, String description, String images){
        this.id = id;
        this.name = name;
        this.sellingprice = sellingprice;
        this.originalprice = originalprice;
        this.quantity = quantity;
        this.description = description;
        this.images = images;
    }

    public ProductModel(String name, Double sellingprice, Double originalprice, Double quantity, String description, String images ){
        this.name = name;
        this.sellingprice = sellingprice;
        this.originalprice = originalprice;
        this.quantity = quantity;
        this.description = description;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(Double sellingprice) {
        this.sellingprice = sellingprice;
    }

    public Double getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(Double originalprice) {
        this.originalprice = originalprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @OneToMany(mappedBy = "productid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartModel> carts;

}
