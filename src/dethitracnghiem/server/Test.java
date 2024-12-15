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
        new Student("Thanh Long", "0966119338", 'M', "thanhlong@gmail.com", "762003").save();
        new Student("Minh Duc", "0654987956", 'F', "minhduc@gmail.com", "08097fasd").save();
    }
}
