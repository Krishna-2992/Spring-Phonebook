package com.yash.contactapp.service;

import com.yash.contactapp.dao.BaseDAO;
import com.yash.contactapp.dao.UserDAO;
import com.yash.contactapp.dao.UserDAOImpl;
import com.yash.contactapp.domain.User;
import com.yash.contactapp.exception.UserBlockedException;
import com.yash.contactapp.rm.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User u) {
        userDAO.save(u);
    }

    @Override
    public User login(String loginName, String password) throws UserBlockedException {
        String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName " +
                "from user where loginName=:ln and password=:pw";
        Map m = new HashMap();
        m.put("ln", loginName);
        m.put("pw", password);

        try {
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
                throw new UserBlockedException("Your account has been blocked. contact the Admin!!");
            } else {
                return u;
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        return userDAO.findByProperty("role", UserService.ROLE_USER);
    }

    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {

    }


}
