package dethitracnghiem.server;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class DBConnection {
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;Database=ThiTracNghiem;user=thanh76;password=thanhle762003;encrypt=true;trustServerCertificate=true";
            Connection con = DriverManager.getConnection(url);
            
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            
            return null;
        }
    }
    
    public static boolean getConnect(String str) {
        boolean check = false;
        Connection conn = null;
        String[] arrStr = str.split("///");
        System.out.println("\nServername: " + arrStr[1] + "\nUsername: " + arrStr[2] + "\nPassword: " + arrStr[3]);
        String ServerName = arrStr[1];
        String name = arrStr[2];
        String pass = arrStr[3];
        String url = "jdbc:sqlserver://" + ServerName + ";databaseName=ThiTracNghiem;user=" + name + ";password=" + pass;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, name, pass);
            if (conn != null) {
                System.out.println("Successful connection to database!!");
                check = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
