package com.cashfinance.cashfinancesf.controller;

import com.cashfinance.cashfinancesf.model.User;
import com.cashfinance.cashfinancesf.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import
import static java.nio.file.Files.delete;

@WebServlet("/api/users")
public class UserDeleteController {

    private UserService userService;
    private ObjectMapper objectMapper = new ObjectMapper();

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        UserService service = new UserService();

        try{
            BufferedReader reader = request.getReader();
            User data = objectMapper.readValue(reader, User.class);

            boolean isDeleted = service.delete(data.getEmail(), data.getPassword());

            if(isDeleted){
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                response.getWriter().println("Deleted Successfully");
            } else{
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Delete Failed");
            }
        } catch (Exception e){
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Delete Failed");
        }
    }

}
