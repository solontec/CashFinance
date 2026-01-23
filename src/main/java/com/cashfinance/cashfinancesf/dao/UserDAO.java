package com.cashfinance.cashfinancesf.dao;


import com.cashfinance.cashfinancesf.model.User;
import infra.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public void registerUser(User user) throws SQLException {
        String sql = "INSERT INTO tb_users(name, email, phone, password, profileType) VALUES (?,?,?,?,?)";

       try(
               Connection conn = ConnectionFactory.getConnection();
               PreparedStatement stmt = conn.prepareStatement(sql);
               ){
           stmt.setString(1, user.getName());
           stmt.setString(2, user.getEmail());
           stmt.setString(3,user.getPhone());
           stmt.setString(4, user.getPassword());
           stmt.setString(5, user.getType());

           stmt.execute();
           System.out.println("Client saved");
       } catch(SQLException e){
           e.printStackTrace();
       }
    }

    public void loginUser(User user) throws SQLException{



    }

}
