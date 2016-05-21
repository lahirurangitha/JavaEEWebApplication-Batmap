package com.group.servlets;

import com.group.controller.LoginController;
import com.group.db.DBConnection;
import com.group.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by lahiru on 5/21/16.
 */

public class LoginForm extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // error feedback message
        String error = "";
        if (username.equals("") || password.equals("")) {
            // fields are empty
            error += "Empty Fields!";
            resp.sendRedirect("login.jsp?msg=" + error);
        }else{
            // checks for a valid user
            DBConnection loginDB = DBConnection.getDbCon();
            String sql = "SELECT * FROM user WHERE username =? AND password = ?";
            try {
                String [] parms= {username,password} ;
                ResultSet rs = null;
                try {
                    rs = loginDB.query(sql,parms);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(rs.next()){

                    // user is redirected to the appropriate home page
                    String type = rs.getString("utype");
                    if (type.equalsIgnoreCase("admin")) {
                        resp.sendRedirect("admin.jsp");
                    }else if (type.equalsIgnoreCase("researcher")) {
                        resp.sendRedirect("researcher.jsp");

                    }
                }else {
                    // if errors found redirected back to the log in page
                    resp.sendRedirect("index.jsp?msg=" + error);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
}
