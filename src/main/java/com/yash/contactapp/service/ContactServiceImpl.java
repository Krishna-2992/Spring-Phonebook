package com.yash.contactapp.service;

import com.yash.contactapp.dao.BaseDAO;
import com.yash.contactapp.dao.ContactDAO;
import com.yash.contactapp.domain.Contact;
import com.yash.contactapp.rm.ContactRowMapper;
import com.yash.contactapp.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class ContactServiceImpl extends BaseDAO implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void save(Contact c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contact c) {
        contactDAO.update(c);
    }

    @Override
    public void delete(Integer contactId) {
        contactDAO.delete(contactId);
    }

    @Override
    public void delete(Integer[] contactIds) {
        String ids = StringUtil.toCommaSeparatedString(contactIds);
        String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
        return contactDAO.findByProperty("userId", userId);
    }

    @Override
    public List<Contact> findUserContacts(Integer userId, String txt) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(sql, new ContactRowMapper(),userId);
    }
}
