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
public class Student {
    private Integer maThiSinh;
    private String hoTen;
    private String soDienThoai;
    private Character gioiTinh;
    private String email;
    private String matKhau;
    private Date ngaySinh;

    public Student() {
    }

    public Student(String hoTen, String soDienThoai, char gioiTinh, String email, String matKhau, Date ngaySinh) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
    }
    
    public Student(Integer maThiSinh, String hoTen, String soDienThoai, Character gioiTinh, String email, String matKhau, Date ngaySinh) {
        this.maThiSinh = maThiSinh;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
    }

    public Integer getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(Integer maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public Student save() {
        String insertThiSinh = "INSERT INTO ThiSinh(HoTen, SoDienThoai, Email, Password, GioiTinh, NgaySinh) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            try(Connection connection = new DBConnection().getConnection()) {
               PreparedStatement ps = connection.prepareStatement(insertThiSinh, Statement.RETURN_GENERATED_KEYS);
               
               ps.setString(1, this.hoTen);
               ps.setString(2, this.soDienThoai);
               ps.setString(3, this.email);
               ps.setString(4, this.matKhau);
               ps.setString(5, String.valueOf(this.gioiTinh));
               ps.setDate(6, new java.sql.Date(this.ngaySinh.getTime()));
               
               int i = ps.executeUpdate();
               
               ResultSet keys = ps.getGeneratedKeys();
               
               if(keys.next()) {
                   this.maThiSinh = keys.getInt(1);
               }
               
               System.out.println("Updated rows: " + i);
               return this;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static ArrayList<Student> getDSThiSinh() {
        ArrayList<Student> students = new ArrayList<>();
        
        String listStudents = "SELECT * FROM ThiSinh";
        
        try {
            try(Connection connection = new DBConnection().getConnection()) {
               PreparedStatement ps = connection.prepareStatement(listStudents);
               ResultSet result = ps.executeQuery();
               
               while(result.next()) {
                   Student s = new Student();
                   
                   s.setMaThiSinh(result.getInt(1));
                   s.setHoTen(result.getString(2));
                   s.setSoDienThoai(result.getString(3));
                   s.setEmail(result.getString(4));
                   s.setMatKhau(result.getString(5));
                   s.setGioiTinh(result.getString(6).charAt(0));
                   s.setNgaySinh(result.getDate("NgaySinh"));
                   
                   students.add(s);
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return students;
    }
    
    public boolean isExists() {
        String sqlExists = "SELECT COUNT(*) FROM ThiSinh WHERE Email = ?";
        
        try {
            try(Connection connection = new DBConnection().getConnection()) {
               PreparedStatement ps = connection.prepareStatement(sqlExists);
               
               ps.setString(1, this.email);
               
               ResultSet result = ps.executeQuery();
               
               if(result.next()) {
                   int count = result.getInt(1);
                   return count > 0;
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
