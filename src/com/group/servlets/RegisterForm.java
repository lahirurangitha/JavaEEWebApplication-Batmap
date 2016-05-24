package com.group.servlets;

import com.group.db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lahiru on 5/21/16.
 */
public class RegisterForm extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");

        if (username.equals("") || password.equals("")|| rePassword.equals("")) {
            // fields are empty
            resp.sendRedirect("register.jsp?emptyFields=Empty Fields.");
        }else{
            //passwords not matching
            if(!password.equals(rePassword)){
                resp.sendRedirect("register.jsp?passNoMatch=Passwords does not match.");
            }else{
                //passwords matching
                DBConnection registerCheckDB = DBConnection.getDbCon();
                String sql1 = "SELECT * FROM user WHERE username =?";
                String prm[] = {username};
                ResultSet rs1 = null;
                try {
                    rs1 = registerCheckDB.query(sql1, prm);
                    if(rs1.next()){
                        //username exists
                        resp.sendRedirect("register.jsp?usrExists=Username already exists.");
                    }else{
                        //registration possible
                        DBConnection registerDB = DBConnection.getDbCon();
                        String sql2 = "INSERT INTO user(username,password,utype) VALUES (?,?,?)";
                        String researcher = "researcher";
                        String parms[] = {username,password,researcher};
                        int flag = registerDB.insert(sql2, parms);
                        if(flag==1){
                            resp.sendRedirect("register.jsp?regSuccess=Registration was successful. Please sign in.");
                        }else{
                            resp.sendRedirect("register.jsp?regFailed=Registration Failed");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
