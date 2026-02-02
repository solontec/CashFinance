package com.cashfinance.cashfinancesf.service;

import com.cashfinance.cashfinancesf.dao.UserDAO;
import com.cashfinance.cashfinancesf.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class UserService {

    UserDAO dao = new UserDAO();

    public void register(User user) throws SQLException {
        if(user.getName().isEmpty() || user.getName() == null){
            throw new IllegalArgumentException("Required name");
        }

        if(user.getEmail().isEmpty()|| user.getEmail() == null){
            throw new IllegalArgumentException("Required email");
        }

        if(user.getPhone().isEmpty()|| user.getPhone() == null){
            throw new IllegalArgumentException("Required phone");
        }

        if(user.getPassword().isEmpty()|| user.getPassword() == null){
            throw new IllegalArgumentException("Required password");
        }

        if(user.getType().isEmpty()|| user.getType() == null){
            throw new IllegalArgumentException("Required type");
        }

        String salt = BCrypt.gensalt(12);
        String passwordHash = BCrypt.hashpw(user.getPassword(), salt);

        // set password, before the value is withou hash, now with hash (passwordHash que tem o hash agora é a senha)
        // set.!
        user.setPassword(passwordHash);
        dao.registerUser(user);
    }

    public boolean login(String email, String passwordWrite) throws SQLException {
        if(email.isEmpty() || email == null){
            throw new IllegalArgumentException("Email is required");
        }

        if(passwordWrite.isEmpty() || passwordWrite == null){
            throw new IllegalArgumentException("Password is required");
        }

        User userData = dao.loginUser(email);

        if(userData == null){
            System.out.println("User not found");
            return false;
        }

        if(BCrypt.checkpw(passwordWrite, userData.getPassword())){
            System.out.println("Login with successfully");
            return true;
        }else{
            System.out.println("Password incorrect");
            return false;
        }

    }

}
