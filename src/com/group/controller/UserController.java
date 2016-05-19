package com.group.controller;

import com.group.db.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lahiru on 5/18/2016.
 */
public class UserController {

    public static String getDetails() throws ClassNotFoundException, SQLException {
        String str;
        DBConnection mydb = DBConnection.getDbCon();
        if(mydb!=null){
            ResultSet rs = mydb.query("SELECT * FROM user WHERE uid = 2");
            if(rs.next()){
                str = rs.getString("username");
            }else {
                str = "else else";
            }
        }else{
            str="else";
        }
        return str;
    }


}
