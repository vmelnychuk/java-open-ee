package by.vamel.contacts.controllers;

import by.vamel.contacts.entities.Address;
import by.vamel.contacts.entities.Contact;
import by.vamel.contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET, produces="text/html")
    public String getContactList(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contact/list";
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getViewContact(@RequestParam long id, Model model) {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "contact/view";
    }
    
    @RequestMapping(value = "/contact", params = "add", method = RequestMethod.GET)
    public String getAddContact(Model model) {
        model.addAttribute("contact", new Object());
        return "contact/add";
    }
    
    @RequestMapping(value = "/contact", params = "edit", method = RequestMethod.GET)
    public String getEditContact(@RequestParam long id, Model model) {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "contact/edit";
    }

    @RequestMapping(value = "/contact", params = "add", method = RequestMethod.POST)
        public String postAddContact(@RequestParam String name,
                                     @RequestParam String street,
                                     @RequestParam String city) {
        Address address = new Address(street, city);
        Contact contact = null; //new Contact(name, address);
        contact = contactRepository.save(contact);
        return "redirect:contact?id=" + contact.getId();
    }

    @RequestMapping(value = "/contact", params = "edit", method = RequestMethod.POST)
    public String postEditContact(@RequestParam long id,
                                  @RequestParam String name,
                                  @RequestParam String street,
                                  @RequestParam String city) {
        Contact contact = contactRepository.findOne(id);
        contact.setName(name);
        Address address = null;//contact.getAddress();
        address.setStreet(street);
        address.setCity(city);
        contactRepository.save(contact);
        return "redirect:contact?id=" + contact.getId();
    }

    @RequestMapping(value = "/contact", params = "delete", method = RequestMethod.POST)
    public String postDeleteContact(@RequestParam long id) {
        contactRepository.delete(id);
        return "redirect:contacts";
    }
}
