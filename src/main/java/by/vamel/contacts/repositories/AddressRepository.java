package by.vamel.contacts.repositories;

import by.vamel.contacts.entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class AddressRepository extends Repository<Address> {

    public AddressRepository() {
        super(Address.class);
    }
}
