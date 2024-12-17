/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author USER
 */
public class UserService {
    public boolean dangKy(String email, String password, String hoTen, String gioiTinh, Date ngaySinh, String soDienThoai) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            DBConnection dbConnection = new DBConnection();
            conn = dbConnection.getConnection();
            
            if(conn == null) {
                return false;
            }
            
            String insertUsers = "INSERT INTO Users(Email, Password, HoTen, GioiTinh, NgaySinh, SoDienThoai) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(insertUsers);
            
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, hoTen);
            ps.setString(4, gioiTinh);
            ps.setDate(5, new java.sql.Date(ngaySinh.getTime()));
            ps.setString(6, soDienThoai);
            
            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if(ps != null) {
                    ps.close();
                }
                
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
