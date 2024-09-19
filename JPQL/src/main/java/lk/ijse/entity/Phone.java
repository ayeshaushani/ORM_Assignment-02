package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Phone {

    @Id
    private String PId;
    private String brand;
    private String price;
    public Phone() {
    }
    public Phone(String PId, String brand, String price) {
        this.PId = PId;
        this.brand = brand;
        this.price = price;
    }

    public String getPId() {
        return PId;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
