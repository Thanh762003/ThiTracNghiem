/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author USER
 */
public class Test {
    public static void main(String[] args) {
        DeThi deThi = new DeThi("President of World");
        CauHoi cauHoi = new CauHoi(deThi, "Vladimir Putin is the president of", "Russia", "Spain", "China", "Japan", "A");
        
        ArrayList<CauHoi> arr = new ArrayList<>();
        
        arr.add(cauHoi);
        arr.add(cauHoi);
        arr.add(cauHoi);
        arr.add(cauHoi);
        arr.add(cauHoi);
        arr.add(cauHoi); 
        arr.add(cauHoi);
        arr.add(cauHoi);
        arr.add(cauHoi);
        arr.add(cauHoi);
        
        cauHoi.setDeThi(deThi);
        deThi.save(arr);
    }
}
