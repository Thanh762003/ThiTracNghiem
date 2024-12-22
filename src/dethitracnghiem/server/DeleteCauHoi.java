/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author USER
 */
public class DeleteCauHoi {
    Connection con = new DBConnection().getConnection();
    
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
    
    public boolean deleteCauHoi(int cauHoiSo, int deThiID) {
        String delete = "DELETE FROM CauHoi WHERE CauHoiSo = ? AND DeThiID = ?";
        boolean isDeleted = false;
        
        try {
            PreparedStatement ps = con.prepareStatement(delete);
            
            ps.setInt(1, cauHoiSo);
            ps.setInt(2, deThiID);
            
            int result = ps.executeUpdate();
            
            isDeleted = result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isDeleted;
    }
}
