package by.vamel.contacts.controllers;

import by.vamel.contacts.entities.Contact;
import by.vamel.contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public void getContactList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contacts", contactRepository.findAll());
        RequestDispatcher view = request.getRequestDispatcher("view/contact/list.jsp");
        view.forward(request, response);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public void getContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("add") != null) {
            request.getRequestDispatcher("view/contact/add.jsp").forward(request, response);
        } else {
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(id);
            request.setAttribute("contact", contact);

            if(request.getParameter("edit") != null) {
                request.getRequestDispatcher("view/contact/edit.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("view/contact/view.jsp");
            }
        }
    }
}
