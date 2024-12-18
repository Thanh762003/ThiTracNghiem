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
public class DeThi {
    private Integer deThiID;
    private String maDeThi;
    private String monThi;

    public DeThi() {
    }

    public DeThi(Integer deThiID) {
        this.deThiID = deThiID;
    }

    public DeThi(String maDeThi, String monThi) {
        this.maDeThi = maDeThi;
        this.monThi = monThi;
    }
    
    public Integer getDeThiID() {
        return deThiID;
    }

    public void setDeThiID(Integer deThiID) {
        this.deThiID = deThiID;
    }

    public String getMaDeThi() {
        return maDeThi;
    }

    public void setMaDeThi(String maDeThi) {
        this.maDeThi = maDeThi;
    }

    public String getMonThi() {
        return monThi;
    }

    public void setMonThi(String monThi) {
        this.monThi = monThi;
    }
    
    public int save() {
        try {
            String insertDeThi = "INSERT INTO DeThi(MaDeThi, MonThi) VALUES (?, ?)";
            Connection connection = new DBConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement(insertDeThi, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, this.maDeThi);
            ps.setString(2, this.monThi);
            
            int i = ps.executeUpdate();
            
            ResultSet keys = ps.getGeneratedKeys();
            
            if(keys.next()) {
                return keys.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        
        return -1;
    }
    
    
    public boolean save(ArrayList<CauHoi> cacCauHoi) {
        boolean flag = true;
        this.deThiID = this.save();
        
        for(CauHoi ch : cacCauHoi) {
            flag = flag && ch.save();
        }
        
        return flag;
    }
    
    public List<DeThi> getDSDeThi() {
        List<DeThi> dsDeThi = new ArrayList<>();
        String listDeThi = "SELECT * FROM DeThi";
        Connection conn = new DBConnection().getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(listDeThi);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                DeThi deThi = new DeThi();
                
                deThi.setDeThiID(rs.getInt("ID"));
                deThi.setMaDeThi(rs.getString("MaDeThi"));
                deThi.setMonThi(rs.getString("MonThi"));
                
                dsDeThi.add(deThi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsDeThi;
    }
}
