/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class CauHoi {
    private DeThi deThi;
    private Integer questionID;
    private Integer cauHoiSo;
    private String noiDung;
    private String A;
    private String B;
    private String C;
    private String D;
    private String dapAn;

    public CauHoi() {
    }
    
    public CauHoi(DeThi deThi, Integer cauHoiSo, String noiDung, String A, String B, String C, String D, String dapAn) {
        this.deThi = deThi;
        this.cauHoiSo = cauHoiSo;
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

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }

    public Integer getCauHoiSo() {
        return cauHoiSo;
    }

    public void setCauHoiSo(Integer cauHoiSo) {
        this.cauHoiSo = cauHoiSo;
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
        String insertDeThi = "INSERT INTO CauHoi(CauHoiSo, NoiDung, A, B, C, D, DapAn, DeThiID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            try {
                Connection connection = new DBConnection().getConnection();
                PreparedStatement ps = connection.prepareStatement(insertDeThi, Statement.RETURN_GENERATED_KEYS);

                ps.setInt(1, this.cauHoiSo);
                ps.setString(2, this.noiDung);
                ps.setString(3, this.A);
                ps.setString(4, this.B);
                ps.setString(5, this.C);
                ps.setString(6, this.D);
                ps.setString(7, this.dapAn);
                ps.setInt(8, this.deThi.getDeThiID());

                int i = ps.executeUpdate();
                
                System.out.println("Updated Rows: " + i);
                
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return flag;
    }
    
    public List<CauHoi> getDSCauHoi() {
        List<CauHoi> dsCauHoi = new ArrayList<>();
        String listCauHoi = "SELECT * FROM CauHoi";
        Connection conn = new DBConnection().getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(listCauHoi);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                CauHoi cauHoi = new CauHoi();
                
                cauHoi.setQuestionID(rs.getInt("ID"));
                cauHoi.setCauHoiSo(rs.getInt("CauHoiSo"));
                cauHoi.setNoiDung(rs.getString("NoiDung"));
                cauHoi.setA(rs.getString("A"));
                cauHoi.setB(rs.getString("B"));
                cauHoi.setC(rs.getString("C"));
                cauHoi.setD(rs.getString("D"));
                cauHoi.setDapAn(rs.getString("DapAn"));
                
                DeThi deThi = new DeThi();
                deThi.setDeThiID(rs.getInt("DeThiID"));
                cauHoi.setDeThi(deThi);
                
                dsCauHoi.add(cauHoi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsCauHoi;
    }
    
    public List<CauHoi> getDSCauHoiByDeThi(int maDeThi) {
        List<CauHoi> dsCauHoi = new ArrayList<>();
        String sql = "SELECT * FROM CauHoi WHERE DeThiID = ?";
        
        Connection conn = new DBConnection().getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maDeThi);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                CauHoi cauHoi = new CauHoi();
                
                cauHoi.setQuestionID(rs.getInt("ID"));
                cauHoi.setCauHoiSo(rs.getInt("CauHoiSo"));
                cauHoi.setNoiDung(rs.getString("NoiDung"));
                cauHoi.setA(rs.getString("A"));
                cauHoi.setB(rs.getString("B"));
                cauHoi.setC(rs.getString("C"));
                cauHoi.setD(rs.getString("D"));
                cauHoi.setDapAn(rs.getString("DapAn"));
                cauHoi.setDeThi(new DeThi(rs.getInt("DeThiID")));
                
                dsCauHoi.add(cauHoi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsCauHoi;
    }
}