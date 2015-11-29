package by.vamel.contacts.servlets;

import by.vamel.contacts.entities.Address;
import by.vamel.contacts.entities.Contact;
import by.vamel.contacts.repositories.AddressRepository;
import by.vamel.contacts.repositories.ContactRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    private final ContactRepository contactRepository = new ContactRepository();
    private final AddressRepository addressRepository = new AddressRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("add") != null) {
            request.getRequestDispatcher("jsp/add-contact.jsp").forward(request, response);
        } else if (request.getParameter("edit") != null) {
            long id = Long.parseLong(request.getParameter("id"));

            Contact contact = contactRepository.find(id);
            Address address = addressRepository.find(contact.getAddressId());

            request.setAttribute("contact", contact);
            request.setAttribute("address", address);

            request.getRequestDispatcher("jsp/edit-contact.jsp").forward(request, response);
        } else {
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(id);

            long addressId = contact.getAddressId();
            Address address = addressRepository.find(addressId);

            request.setAttribute("contact", contact);
            request.setAttribute("address", address);

            RequestDispatcher view = request.getRequestDispatcher("jsp/view-contact.jsp");
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            Address address = new Address(street, city);
            address = addressRepository.save(address);

            String name = request.getParameter("name");
            Contact contact = new Contact(name, address.getId());
            contact = contactRepository.save(contact);
            response.sendRedirect("contact?id=" + contact.getId());
            return;
        } else if (request.getParameter("edit") != null) {
            long contactId = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(contactId);
            Address address = addressRepository.find(contact.getAddressId());

            String newName = request.getParameter("name");
            String newStreet = request.getParameter("street");
            String newCity = request.getParameter("city");

            contact.setName(newName);
            address.setStreet(newStreet);
            address.setCity(newCity);

            contactRepository.save(contact);
            addressRepository.save(address);

            response.sendRedirect("contact?id=" + contact.getId());
            return;
        } else if(request.getParameter("delete") != null) {
            long contactId = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(contactId);
            Address address = addressRepository.find(contact.getAddressId());
            contactRepository.delete(contact);
            addressRepository.delete(address);
        }
        response.sendRedirect("contacts");
    }
}
