package at.htl.cardealerManagement.model;

import javax.persistence.*;

@Entity
public class CarExemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mileage;
    private int horsepower;
    private String color;

    @OneToOne(cascade = CascadeType.ALL)
    private CarType carType;
    @OneToOne (cascade = CascadeType.ALL)
    private Customer oldCarOwner;
    @OneToOne (cascade = CascadeType.ALL)
    private Customer newCarOwner;
    @OneToOne (cascade = CascadeType.ALL)
    private Employee seller;

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Customer getOldCarOwner() {
        return oldCarOwner;
    }

    public CarExemplar(int mileage, int horsepower, String color, CarType carType, Customer oldCarOwner, Customer newCarOwner, Employee seller) {
        this.mileage = mileage;
        this.horsepower = horsepower;
        this.color = color;
        this.carType = carType;
        this.oldCarOwner = oldCarOwner;
        this.newCarOwner = newCarOwner;
        this.seller = seller;
    }

    public void setOldCarOwner(Customer oldCarOwner) {
        this.oldCarOwner = oldCarOwner;
    }

    public Customer getNewCarOwner() {
        return newCarOwner;
    }

    public void setNewCarOwner(Customer newCarOwner) {
        this.newCarOwner = newCarOwner;
    }

    public Employee getSeller() {
        return seller;
    }

    public void setSeller(Employee seller) {
        this.seller = seller;
    }

    public CarExemplar(int mileage, int horsepower, String color, CarType carType) {
        this.mileage = mileage;
        this.horsepower = horsepower;
        this.color = color;
        this.carType = carType;
    }

    public CarExemplar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarType getcarType() {
        return carType;
    }

    public void setcarType(CarType carType) {
        this.carType = carType;
    }
}
