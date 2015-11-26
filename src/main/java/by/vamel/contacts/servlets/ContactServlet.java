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
        } else {
            String contactId = request.getParameter("id");
            long id = Long.parseLong(contactId);
            Contact contact = contactRepository.find(id);

            long addressId = contact.getAddressId();
            Address address = addressRepository.find(addressId);

            request.setAttribute("contact", contact);
            request.setAttribute("address", address);

            RequestDispatcher view = request.getRequestDispatcher("jsp/contact-details.jsp");
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
            addressRepository.create(address);

            String name = request.getParameter("name");
            Contact contact = new Contact(name, address.getId());
            contactRepository.create(contact);
        }
        response.sendRedirect("contacts");
    }
}
