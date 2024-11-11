package com.yash.contactapp.controller;

import com.yash.contactapp.domain.Contact;
import com.yash.contactapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/user_edit_contact")
    public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
        session.setAttribute("aContactId", contactId);
        Contact c = contactService.findById(contactId);
        m.addAttribute("command", c);
        return "contact_form";//JSP form view
    }

    @RequestMapping(value = "/user_save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
        Integer contactId = (Integer) session.getAttribute("aContactId");
        if (contactId == null) {
            //save task
            try {
                Integer userId = (Integer) session.getAttribute("userId");
                c.setUserId(userId);//FK ; logged in userId
                contactService.save(c);
                return "redirect:user_clist?act=sv";//redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to save contact");
                return "contact_form";
            }
        } else {
            //update task
            System.out.println("inside update task!!");
            try {
                c.setContactId(contactId); //PK
                System.out.println(contactId);
                contactService.update(c);
                session.removeAttribute("aContactId");
                return "redirect:user_clist?act=ed";//redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Edit contact");
                return "contact_form";
            }
        }
    }

    @RequestMapping(value="/user_clist")
    public String contactList(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId));
        m.addAttribute("test", "helloTest");
        return "clist";
    }

    @RequestMapping(value = "/user_contact_search")
    public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId, freeText));
        return "clist"; //JSP
    }

    @RequestMapping(value = "/user_del_contact")
    public String deleteContact(@RequestParam("cid") Integer contactId) {
        contactService.delete(contactId);
        return "redirect:user_clist?act=del";
    }

    @RequestMapping(value = "/user_bulk_cdelete")
    public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
        contactService.delete(contactIds);
        return "redirect:user_clist?act=del";
    }

}
