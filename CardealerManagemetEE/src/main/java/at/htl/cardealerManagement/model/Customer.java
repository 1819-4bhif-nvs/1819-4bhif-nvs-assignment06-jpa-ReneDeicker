package at.htl.cardealerManagement.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@NamedQuery(name = "Customer.findAll", query = "select c from Customer c join Pupil p on p.id = c.id")
@Entity
public class Customer extends Pupil{
    public String getIBAN() {
        return IBAN;
    }

    public Customer(String firstName, String lastName, String phoneNumber, String city, String street, int zipCode, String IBAN) {
        super(firstName, lastName, phoneNumber, city, street, zipCode);
        this.IBAN = IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    private String IBAN;

    public Customer() {
    }
}
