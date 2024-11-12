package com.yash.contactapp.service;

import com.yash.contactapp.domain.User;
import com.yash.contactapp.exception.UserBlockedException;

import java.util.List;

public interface UserService {

    public static final Integer LOGIN_STATUS_ACTIVE=1;
    public static final Integer LOGIN_STATUS_BLOCKED=2;

    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;

    public Boolean isUsernameExist(String username);

    /**
     * method handles the user registration task.
     * @param u
     */
    public void register(User u);

    /**
     * the method handles login operation using given credentials. null when validation fails
     * when user account is blocked, an exception will be thrown by this method
     * @param loginName
     * @param password
     * @return
     */
    public User login(String loginName, String password) throws UserBlockedException;

    public List<User> getUserList();

    /**
     * this method will change the user login status
     * @param userId
     * @param loginStatus
     */
    public void changeLoginStatus(Integer userId, Integer loginStatus);
}
