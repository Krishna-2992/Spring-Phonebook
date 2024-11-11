package com.yash.contactapp.controller;

import com.yash.contactapp.domain.Contact;
import com.yash.contactapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Constructor;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value="/user_contact_form")
    public String contactForm(Model m) {
        Contact contact = new Contact();
        m.addAttribute("command", contact);
        return "contact_form";
    }

    @RequestMapping(value="/save_contact")
    public String saveContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
        try{
            Integer userId = (Integer) session.getAttribute("userId");
            c.setUserId(userId); // FK logged in user id

            contactService.save(c);
            return "redirect:user_clist?act=sv";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to save contact");
            return "contact_form";
        }
    }

    @RequestMapping(value="/user_clist")
    public String contactList(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId));
        m.addAttribute("test", "helloTest");
        return "clist";
    }


}
