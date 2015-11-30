package by.vamel.contacts.servlets;

import by.vamel.contacts.entities.Address;
import by.vamel.contacts.entities.Contact;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("add") != null) {
            request.getRequestDispatcher("jsp/add-contact.jsp").forward(request, response);
        } else if (request.getParameter("edit") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(id);
            request.setAttribute("contact", contact);
            request.getRequestDispatcher("jsp/edit-contact.jsp").forward(request, response);
        } else {
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(id);
            request.setAttribute("contact", contact);
            RequestDispatcher view = request.getRequestDispatcher("jsp/view-contact.jsp");
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            Address address = new Address(request.getParameter("street"), request.getParameter("city"));
            Contact contact = new Contact(request.getParameter("name"), address);
            contact = contactRepository.save(contact);
            response.sendRedirect("contact?id=" + contact.getId());
            return;
        } else if (request.getParameter("edit") != null) {
            long contactId = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(contactId);
            Address address = contact.getAddress();

            contact.setName(request.getParameter("name"));
            address.setStreet(request.getParameter("street"));
            address.setCity(request.getParameter("city"));

            contactRepository.save(contact);
            response.sendRedirect("contact?id=" + contact.getId());
            return;
        } else if(request.getParameter("delete") != null) {
            long contactId = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(contactId);
            contactRepository.delete(contact);
        }
        response.sendRedirect("contacts");
    }
}
