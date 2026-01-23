package com.cashfinance.cashfinancesf.controller;

import com.cashfinance.cashfinancesf.dao.UserDAO;
import com.cashfinance.cashfinancesf.model.User;
import com.cashfinance.cashfinancesf.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/api/auth/register")
public class UserRegisterController extends HttpServlet {

    private UserService service = new UserService();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            register(request, response);
        } catch (SQLException e) {
            e.printStackTrace();

            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Erro no banco");
        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        // Configure response to just json

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // he here only accept format json

        try{
            BufferedReader reader = request.getReader();
            User data = objectMapper.readValue(reader, User.class);

            // object data with objectMapper for transform in json too

            service.register(data);// call method register user

            // status code.
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("Create User with sucessfully");

        } catch(Exception e){
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Error for create");
        }


    }
}