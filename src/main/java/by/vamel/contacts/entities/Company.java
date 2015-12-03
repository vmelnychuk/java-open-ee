package by.vamel.contacts.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Company extends Contact {

    @OneToMany
    private Set<Office> offices;

    public Company() {
    }

    public Company(String name, Set<Office> offices) {
        super(name);
        this.offices = offices;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}
