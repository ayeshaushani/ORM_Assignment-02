package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Phone {

@Id
    private String PId;
    private String brand;
    private String price;
    private User user;
    public Phone() {
    }

    public Phone(String PId, String brand, String price, User user) {
        this.PId = PId;
        this.brand = brand;
        this.price = price;
        this.user = user;
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

    public User getUser(List<Phone> list) {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
