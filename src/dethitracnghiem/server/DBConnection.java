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
            String url = "jdbc:sqlserver://localhost:1433;Database=ThiTracNghiem;user=thanh76;password=thanh762003;encrypt=true;trustServerCertificate=true";
            Connection con = DriverManager.getConnection(url);
            
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            
            return null;
        }
    }
}
