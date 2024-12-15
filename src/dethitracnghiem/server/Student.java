/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.sql.*;
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

    public Student(String hoTen, String soDienThoai, Character gioiTinh, String email, String matKhau, Date ngaySinh) {
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
    
    public boolean save() {
        String insertThiSinh = "INSERT INTO ThiSinh(HoTen, SoDienThoai, Email, Password, GioiTinh, NgaySinh) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            try(Connection connection = new DBConnection().getConnection()) {
               PreparedStatement ps = connection.prepareStatement(insertThiSinh);
               
               ps.setString(1, this.hoTen);
               ps.setString(2, this.soDienThoai);
               ps.setString(3, this.email);
               ps.setString(4, this.matKhau);
               ps.setString(5, String.valueOf(this.gioiTinh));
               ps.setDate(6, new java.sql.Date(this.ngaySinh.getTime()));
               
               int i = ps.executeUpdate();
               
               System.out.println("Updated rows: " + i);
               return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
