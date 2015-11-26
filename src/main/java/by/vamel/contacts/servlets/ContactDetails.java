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
public class ContactDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contactId = request.getParameter("id");
        long id = Long.parseLong(contactId);
        ContactRepository contactRepository = new ContactRepository();
        Contact contact = contactRepository.find(id);
        long addressId = contact.getAddressId();
        AddressRepository addressRepository = new AddressRepository();
        Address address = addressRepository.find(addressId);
        request.setAttribute("contact", contact);
        request.setAttribute("address", address);

        RequestDispatcher view = request.getRequestDispatcher("jsp/contact-details.jsp");
        view.forward(request, response);
    }
}
