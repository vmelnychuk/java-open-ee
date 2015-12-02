package by.vamel.contacts.repositories;

import by.vamel.contacts.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Long> {

}
