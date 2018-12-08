package at.htl.cardealerManagement.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.time.LocalDate;

@Entity
public class Customer extends Pupil{
    public String getIBAN() {
        return IBAN;
    }

    public Customer(String firstName, String lastName, String phoneNumber, String city, String street, int zipCode, LocalDate birthDate, String IBAN) {
        super(firstName, lastName, phoneNumber, city, street, zipCode, birthDate);
        this.IBAN = IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    private String IBAN;

    public Customer() {
    }
}
