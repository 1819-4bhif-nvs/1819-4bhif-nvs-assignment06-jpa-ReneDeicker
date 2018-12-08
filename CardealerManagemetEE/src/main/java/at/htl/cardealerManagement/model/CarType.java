package at.htl.cardealerManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String brand;
    private String model;

    public CarType(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public CarType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
