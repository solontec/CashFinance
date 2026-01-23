package com.cashfinance.cashfinancesf.service;

import com.cashfinance.cashfinancesf.dao.UserDAO;
import com.cashfinance.cashfinancesf.model.User;

import java.sql.SQLException;

public class UserService {

    UserDAO dao = new UserDAO();
    public void register(User user) throws SQLException {
        if(user.getName().isEmpty() || user.getName() == null){
            throw new IllegalArgumentException("Required name");
        }

        if(user.getEmail().isEmpty()|| user.getEmail() == null){
            throw new IllegalArgumentException("Required name");
        }

        if(user.getPhone().isEmpty()|| user.getPhone() == null){
            throw new IllegalArgumentException("Required name");
        }

        if(user.getPassword().isEmpty()|| user.getPassword() == null){
            throw new IllegalArgumentException("Required name");
        }

        if(user.getType().isEmpty()|| user.getType() == null){
            throw new IllegalArgumentException("Required name");
        }

        dao.registerUser(user);
    }

    public void login(User user){
        if(user.getEmail().isEmpty() || user.getEmail() == null){
            throw new IllegalArgumentException("Email is required");

        }

    }
}
