package com.cashfinance.cashfinancesf.controller;

import com.cashfinance.cashfinancesf.dao.UserDAO;
import com.cashfinance.cashfinancesf.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("api/auth/login")
public class UserLoginController extends HttpServlet {
    private UserDAO dao = new UserDAO();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            login(request, response);
        }catch(Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Erro na requisicao");
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try{
            BufferedReader reader = request.getReader();
            User data = objectMapper.readValue(reader, User.class);

            dao.loginUser(data);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            response.getWriter().write("Login with sucess");
        }catch(Exception e){
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("error");
        }
    }

}
