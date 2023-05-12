/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phan Nguyen Tu Anh
 */
class DBConnect {
     public Connection conn=null;
     public DBConnect(String url,String userName,String pass){
         try {
            String user = "sa";
            String password= "123456";
            String urlconnect = "jdbc:sqlserver://localhost:1433;databaseName=se1709";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public DBConnect(){
        this("jdbc:sqlserver://localhost:1433;databaseName=se1709",
                "sa","123456");
    }
    public ResultSet getData(String sql){
        ResultSet rs=null;
        try {
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs=state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    } 
     
    public static void main(String[] args) {
        DBConnect dbConnect = new DBConnect();
    }
}
