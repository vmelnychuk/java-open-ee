package by.vamel.contacts.servlets;

import by.vamel.contacts.entities.Address;
import by.vamel.contacts.entities.Contact;
import by.vamel.contacts.repositories.AddressRepository;
import by.vamel.contacts.repositories.ContactRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Setup implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        new AddressRepository().init();
        new ContactRepository().init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        new AddressRepository().destroy();
        new ContactRepository().destroy();
    }
}
