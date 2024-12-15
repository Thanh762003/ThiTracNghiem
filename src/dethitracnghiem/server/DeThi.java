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
    private Integer maDeThi;
    private String monThi;

    public DeThi(String monThi) {
        this.monThi = monThi;
    }

    public DeThi() {}
    
    public Integer getMaDeThi() {
        return maDeThi;
    }

    public void setMaDeThi(Integer maDeThi) {
        this.maDeThi = maDeThi;
    }

    public String getMonThi() {
        return monThi;
    }

    public void setMonThi(String monThi) {
        this.monThi = monThi;
    }

    @Override
    public String toString() {
        return "CauHoi{" + "maDeThi=" + maDeThi + ", monThi=" + monThi + '}';
    }
    
    public int save() {
        String insertDeThi = "INSERT INTO Dethi (MonThi) VALUES (?)";
        
        try {
            try (Connection connection = new DBConnection().getConnection()){
                PreparedStatement ps = connection.prepareStatement(insertDeThi, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, this.monThi);
                int i = ps.executeUpdate();

                ResultSet keys = ps.getGeneratedKeys();

                if(keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
        
        return -1;
    }
    
    public boolean save(ArrayList<CauHoi> cauHoiList) {
        boolean flag = true;
        this.maDeThi = this.save();
        
        for(CauHoi q : cauHoiList) {
            flag = flag && q.save();
            System.out.println(flag);
        }
        
        return flag;
    }
    
    public static Map<DeThi, List<CauHoi>> getDSCauHoiByDeThi() {
        Map<DeThi, List<CauHoi>> quizes = new HashMap<>();
        DeThi key = null;
        List<CauHoi> questions = new ArrayList<CauHoi>();
        
        String query = "SELECT Dethi.MaDeThi, MonThi, CauHoiSo, NoiDung, A, B, C, D, DapAn \n"
                    + "FROM Dethi JOIN CauHoi CH on CH.MaDeThi = Dethi.MaDeThi";
        
        System.out.println(query);
        
        try {
            try (Connection connection = new DBConnection().getConnection()) {
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet result = ps.executeQuery();
                
                while(result.next()) {
                    DeThi temp = new DeThi();
                    temp.setMaDeThi(result.getInt(1));
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
        
        DeThi t = (DeThi) obj;
        
        if(this.maDeThi == t.maDeThi) {
            return true;
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDeThi, monThi);
    }
}
