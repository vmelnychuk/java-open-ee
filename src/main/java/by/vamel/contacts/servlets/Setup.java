package by.vamel.contacts.servlets;

import by.vamel.contacts.entities.Address;
import by.vamel.contacts.repositories.AddressRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Setup implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AddressRepository addressRepository = new AddressRepository();
        addressRepository.init();
        Address address = new Address("Lenina 1", "Gomel");

        addressRepository.create(address);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        AddressRepository addressRepository = new AddressRepository();
        addressRepository.destroy();
    }
}
