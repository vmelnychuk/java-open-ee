package by.vamel.contacts.entities;

import javax.persistence.*;

@Entity
public class Office {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Address address;
    @Column
    private String name;

    public Office() {}

    public Office(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
