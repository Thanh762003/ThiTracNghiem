/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class CauHoi {
    private DeThi deThi;
    private Integer cauHoiSo;
    private String noiDung;
    private String A;
    private String B;
    private String C;
    private String D;
    private String dapAn;

    public CauHoi() {
    }
    
    public CauHoi(DeThi deThi, String noiDung, String A, String B, String C, String D, String dapAn) {
        this.deThi = deThi;
        this.noiDung = noiDung;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.dapAn = dapAn;
    }

    public DeThi getDeThi() {
        return deThi;
    }

    public void setDeThi(DeThi deThi) {
        this.deThi = deThi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }
    
    public boolean save() {
        boolean flag = false;
        String insertCauHoi = "INSERT INTO CauHoi(NoiDung, A, B, C, D, DapAn, MaDeThi) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        System.err.println("Actual query = " + insertCauHoi);
        
        try {
            try (Connection connection = new DBConnection().getConnection()) {
                PreparedStatement ps = connection.prepareStatement(insertCauHoi);

                ps.setString(1, this.noiDung);
                ps.setString(2, this.A);
                ps.setString(3, this.B);
                ps.setString(4, this.C);
                ps.setString(5, this.D);
                ps.setString(6, this.dapAn);
                ps.setInt(7, this.deThi.getMaDeThi());


                int i = ps.executeUpdate();
                
                System.out.println("Updated Rows: " + i);    
            }
            
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return flag;
    }
}