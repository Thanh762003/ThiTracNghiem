/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class UpdateCauHoi {
    private Connection con = new DBConnection().getConnection();

    public UpdateCauHoi() {
    }
    
    public UpdateCauHoi(Connection con) {
        this.con = con;
    }
    
    public List<DeThi> loadDeThi() {
        List<DeThi> dsDeThi = new ArrayList<>();
        String listDeThi = "SELECT * FROM DeThi";
        
        try {
            PreparedStatement ps = con.prepareStatement(listDeThi);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                DeThi deThi = new DeThi(
                        rs.getString("MaDeThi"), 
                        rs.getString("MonThi")
                );
                
                deThi.setDeThiID(rs.getInt("ID"));
                dsDeThi.add(deThi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsDeThi;
    }
    
    public List<String> loadMaDeThi(String monThi) {
        List<String> dsMaDeThi = new ArrayList<>();
        String listMaDeThi = "SELECT MaDeThi FROM DeThi WHERE MonThi = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(listMaDeThi);
            ps.setString(1, monThi);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                dsMaDeThi.add(rs.getString("MaDeThi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dsMaDeThi;
    }
    
    public int getDeThiID(String maDeThi) {
        int deThiID = -1;
        String sql = "SELECT ID FROM DeThi WHERE MaDeThi = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDeThi);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                deThiID = rs.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return deThiID;
    }
    
    public List<Integer> loadCauHoiSo(int deThiID) {
        List<Integer> dsCauHoiSo = new ArrayList<>();
        String listNumberQuestion = "SELECT CauHoiSo FROM CauHoi WHERE DeThiID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(listNumberQuestion);
            ps.setInt(1, deThiID);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                dsCauHoiSo.add(rs.getInt("CauHoiSo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsCauHoiSo;
    }
    
    public CauHoi loadDanhSachCauHoi(int cauHoiSo, int deThiID) {
        CauHoi cauHoi = null;
        String listCauHoi = "SELECT * FROM CauHoi WHERE CauHoiSo = ? AND DeThiID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(listCauHoi);
            
            ps.setInt(1, cauHoiSo);
            ps.setInt(2, deThiID);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                DeThi deThi = new DeThi(deThiID);
                
                cauHoi = new CauHoi(
                        deThi, 
                        rs.getInt("CauHoiSo"), 
                        rs.getString("NoiDung"), 
                        rs.getString("A"), 
                        rs.getString("B"), 
                        rs.getString("C"), 
                        rs.getString("D"), 
                        rs.getString("DapAn")
                );
                
                cauHoi.setQuestionID(rs.getInt("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cauHoi;
    }
    
    public boolean updateCauHoi(int cauHoiSo, int deThiID, String noiDung, String A, String B, String C, String D, String dapAn) {
        String update = "UPDATE CauHoi SET NoiDung = ?, A = ?, B = ?, C = ?, D = ?, DapAn = ?\n"
                    + "WHERE CauHoiSo = ? AND DeThiID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(update);
            
            ps.setString(1, noiDung);
            ps.setString(2, A);
            ps.setString(3, B);
            ps.setString(4, C);
            ps.setString(5, D);
            ps.setString(6, dapAn);
            ps.setInt(7, cauHoiSo);
            ps.setInt(8, deThiID);
            
            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật câu hỏi: " + e.getMessage(), "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            
            return false;
        } 
    }
}
