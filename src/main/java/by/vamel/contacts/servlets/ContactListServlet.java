package by.vamel.contacts.servlets;

import by.vamel.contacts.entities.Contact;
import by.vamel.contacts.repositories.ContactRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/contacts")
public class ContactListServlet extends HttpServlet {
    private final ContactRepository contactRepository = new ContactRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contact> contacts = contactRepository.findAll();

        request.setAttribute("contacts", contacts);

        RequestDispatcher view = request.getRequestDispatcher("jsp/list.jsp");
        view.forward(request, response);
    }
}
