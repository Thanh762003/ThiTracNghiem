/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USER
 */
public class UpdateUsers {
    Connection con = new DBConnection().getConnection();
    
    public List<Integer> getAllUsersIDs() {
        List<Integer> userIDs = new ArrayList<>();
        String query = "SELECT ID FROM Users";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                userIDs.add(rs.getInt("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return userIDs;
    }
    
    public Users findUserByID(int id) {
        Users user = null;
        String listUsers = "SELECT * FROM Users WHERE ID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(listUsers);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                user = new Users(
                        rs.getInt("ID"), 
                        rs.getString("MaUsers"), 
                        rs.getString("HoTen"), 
                        rs.getString("SoDienThoai"), 
                        rs.getString("GioiTinh").charAt(0), 
                        rs.getString("Email"), 
                        rs.getString("Password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public boolean updateUser(Users user) {
        String update = "UPDATE Users SET MaUsers = ?, HoTen = ?, SoDienThoai = ?, GioiTinh = ?, Email = ?, Password = ?\n"
                        + "WHERE ID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(update);
            
            ps.setString(1, user.getMaUsers());
            ps.setString(2, user.getHoTen());
            ps.setString(3, user.getMobile());
            ps.setString(4, String.valueOf(user.getGioiTinh()));
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setInt(7, user.getID());
            
            int i = ps.executeUpdate();
            System.out.println("Updated rows: " + i);
            
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        return "UpdateUsers{" + "con=" + con + '}';
    }
}
