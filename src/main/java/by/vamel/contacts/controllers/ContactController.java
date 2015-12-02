package by.vamel.contacts.controllers;

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
    
//    @RequestMapping(value = "/contact", method = RequestMethod.GET)
//    public void getContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(request.getParameter("add") != null) {
//            request.getRequestDispatcher("view/contact/add.jsp").forward(request, response);
//        } else {
//            long id = Long.parseLong(request.getParameter("id"));
//            Contact contact = contactRepository.findOne(id);
//            request.setAttribute("contact", contact);
//
//            if(request.getParameter("edit") != null) {
//                request.getRequestDispatcher("view/contact/edit.jsp").forward(request, response);
//            } else {
//                request.getRequestDispatcher("view/contact/view.jsp");
//            }
//        }
//    }
}
