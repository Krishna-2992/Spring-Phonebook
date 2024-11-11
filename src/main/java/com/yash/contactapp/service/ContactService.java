package com.yash.contactapp.service;

import com.yash.contactapp.domain.Contact;

import java.util.List;

public interface ContactService {
    public void save(Contact c);
    public void update(Contact c);
    public void delete(Integer contactId);
    public void delete(Integer[] contactIds);
    public Contact findById(Integer contactId);

    /**
     * this method returns all user contact (user who is logged in)
     * @param userId
     * @return
     */
    public List<Contact> findUserContact(Integer userId);

    /**
     * the method search user contacts based on free text (txt)
     * @param userId
     * @param txt
     * @return
     */
    public List<Contact> findUserContact(Integer userId, String txt);
}
