package at.htl.cardealerManagement.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Employee extends Pupil{
    private double salary;
    private String socialSecurityNumber;

    public Employee(String firstName, String lastName, String phoneNumber, String city, String street, int zipCode, LocalDate birthDate, double salary, String socialSecurityNumber) {
        super(firstName, lastName, phoneNumber, city, street, zipCode, birthDate);
        this.salary = salary;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getsocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setsocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Employee() {
    }
}

