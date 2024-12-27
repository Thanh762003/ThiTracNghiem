/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author USER
 */
public class Users {
    private Integer ID;
    private String maUsers;
    private String hoTen;
    private String mobile;
    private Character gioiTinh;
    private String email;
    private String password;

    public Users() {
    }

    public Users(Integer ID, String maUsers, String hoTen, String mobile, Character gioiTinh, String email, String password) {
        this.ID = ID;
        this.maUsers = maUsers;
        this.hoTen = hoTen;
        this.mobile = mobile;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.password = password;
    }

    public Users(String maUsers, String hoTen, String mobile, Character gioiTinh, String email, String password) {
        this.maUsers = maUsers;
        this.hoTen = hoTen;
        this.mobile = mobile;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.password = password;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getMaUsers() {
        return maUsers;
    }

    public void setMaUsers(String maUsers) {
        this.maUsers = maUsers;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Character getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Character gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" + "ID=" + ID + ", maUsers=" + maUsers + ", hoTen=" + hoTen + ", mobile=" + mobile + ", gioiTinh=" + gioiTinh + ", email=" + email + ", password=" + password + '}';
    }
    
    public Users save() {
        String insertUsers = "INSERT INTO Users(MaUsers, HoTen, SoDienThoai, Email, Password, GioiTinh) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = new DBConnection().getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(insertUsers, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, this.maUsers);
            ps.setString(2, this.hoTen);
            ps.setString(3, this.mobile);
            ps.setString(4, this.email);
            ps.setString(5, this.password);
            ps.setString(6, String.valueOf(this.gioiTinh));
            
            int i = ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                this.ID = keys.getInt(1);
            }
            
            System.out.println("Updated Rows: " + i);
            
            return this;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static ArrayList<Users> getAll() {
        ArrayList<Users> dsUsers = new ArrayList<>();
        String listUsers = "SELECT * FROM Users";
        Connection con = new DBConnection().getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(listUsers);
            ResultSet result = ps.executeQuery();
            
            while(result.next()) {
                Users u = new Users();
                
                u.setID(result.getInt(1));
                u.setMaUsers(result.getString(2));
                u.setHoTen(result.getString(3));
                u.setMobile(result.getString(4));
                u.setEmail(result.getString(5));
                u.setPassword(result.getString(6));
                u.setGioiTinh(result.getString(7).charAt(0));
                
                dsUsers.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsUsers;
    }
    
    public boolean isExists() {
        String emailExists = "SELECT * FROM Users WHERE Email = ?";
        Connection con = new DBConnection().getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(emailExists);
            ps.setString(1, this.email);
            ResultSet result = ps.executeQuery();
            
            if(result.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
