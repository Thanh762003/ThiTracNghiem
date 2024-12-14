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
}
