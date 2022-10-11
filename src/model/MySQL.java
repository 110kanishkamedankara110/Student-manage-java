/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kanishka
 */
import com.pixbin.encript.Decriptor;
import gui.Login;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQL {

    private static final Connection c;

    private static  String DB_NAME ;
    private static  String USER_NAME;
    private static  String PASSWORD;

    static {
        
        try {
            File f = new File("C:\\Users\\Kanishka\\Documents\\ClassManage\\Database.txt");
            if (f.exists()) {
                FileReader fr = new FileReader("C:\\Users\\Kanishka\\Documents\\ClassManage\\Database.txt");
                BufferedReader br = new BufferedReader(fr);
                int i;
                StringBuffer s = new StringBuffer();

                while ((i = br.read()) != -1) {
                    s.append((char) i);
                }

                String str = s.toString();
                if (!str.isBlank()) {
                    Decriptor d = new Decriptor();
                    String decripted = d.decriptString(str);
                    

                   
                    
                        DB_NAME= decripted.split("-")[2];
                        USER_NAME=decripted.split("-")[0];
                        PASSWORD=decripted.split("-")[1];
                    }

                }

               
             
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        Connection con;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql213.epizy.com:3306/" + DB_NAME, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            con = null;
        }
        c = con;
    }

    private static Statement connect() throws Exception {

        return c.createStatement();
    }

    public static final void iud(String query) {
        try {
            Statement s = connect();
            s.executeUpdate(query);
        } catch (Exception ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static final ResultSet s(String query) throws Exception {
        Statement s = connect();
        return s.executeQuery(query);
    }

}


