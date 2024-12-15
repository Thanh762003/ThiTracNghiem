/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

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

    public Student(String hoTen, String soDienThoai, Character gioiTinh, String email, String matKhau) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.matKhau = matKhau;
    }

    public Student(Integer maThiSinh, String hoTen, String soDienThoai, Character gioiTinh, String email, String matKhau) {
        this.maThiSinh = maThiSinh;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.matKhau = matKhau;
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
    
    
}
