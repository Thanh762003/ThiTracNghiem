/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public DeThi(Integer deThiID, String maDeThi, String monThi) {
        this.deThiID = deThiID;
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
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(listDeThi);
            
            while(rs.next()) {
                DeThi deThi = new DeThi(
                        rs.getInt("ID"),
                        rs.getString("MaDeThi"),
                        rs.getString("MonThi")
                );
                
                dsDeThi.add(deThi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dsDeThi;
    }
    
    public static Map<DeThi, List<CauHoi>> getAll() {
        Map<DeThi, List<CauHoi>> quizes = new HashMap<>();
        DeThi key = null;
        List<CauHoi> cauHoi = new ArrayList<CauHoi>();
        
        String query = "SELECT MaDeThi, MonThi, CauHoiSo, NoiDung, A, B, C, D, DapAn\n"
                    + "FROM DeThi JOIN CauHoi on CauHoi.DeThiID = DeThi.ID";
        Connection connection = new DBConnection().getConnection();
            
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            
            while(result.next()) {
                DeThi temp = new DeThi();
                temp.setMaDeThi(result.getString(1));
                temp.setMonThi(result.getString(2));
                
                CauHoi tempCauHoi = new CauHoi();
                tempCauHoi.setCauHoiSo(result.getInt(3));
                tempCauHoi.setNoiDung(result.getString(4));
                tempCauHoi.setA(result.getString(5));
                tempCauHoi.setB(result.getString(6));
                tempCauHoi.setC(result.getString(7));
                tempCauHoi.setD(result.getString(8));
                tempCauHoi.setDapAn(result.getString(9));
                
                if(key != null && key.equals(temp)) {
                    quizes.get(key).add(tempCauHoi);
                } else {
                    ArrayList<CauHoi> value = new ArrayList<>();
                    value.add(tempCauHoi);
                    quizes.put(temp, value);
                }
                
                key = temp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return quizes;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        
        if(!(obj instanceof DeThi)) {
            return false;
        }
        
        DeThi test = (DeThi) obj;
        
        if(this.deThiID == test.deThiID) {
            return true;
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.maDeThi);
        hash = 53 * hash + Objects.hashCode(this.monThi);
        return hash;
    }
    
    
}
