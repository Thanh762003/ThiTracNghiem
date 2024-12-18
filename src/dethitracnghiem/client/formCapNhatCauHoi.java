/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dethitracnghiem.client;

import dethitracnghiem.server.CauHoi;
import dethitracnghiem.server.DBConnection;
import dethitracnghiem.server.DeThi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class formCapNhatCauHoi extends javax.swing.JFrame {
    /**
     * Creates new form formCapNhatCauHoi
     */
    public formCapNhatCauHoi() {
        initComponents();
        loadMonThi();
        
        
    }

    private void loadMonThi() {
        Connection con = new DBConnection().getConnection();
        String listMonThi = "SELECT DISTINCT MonThi FROM DeThi";
        
        try {
            PreparedStatement ps = con.prepareStatement(listMonThi);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                cboxMonThi.addItem(rs.getString("MonThi"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải danh sách môn thi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadMaDeThi(String monThi) {
        cboxMaDeThi.removeAllItems();
        Connection conn = new DBConnection().getConnection();
        String listMaDeThi = "SELECT MaDeThi FROM DeThi WHERE MonThi = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(listMaDeThi);
            ps.setString(1, monThi);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                cboxMaDeThi.addItem(rs.getString("MaDeThi"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải danh sách mã đề thi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int getDeThiID(String maDeThi) {
        int deThiID = -1;
        Connection conn = new DBConnection().getConnection();
        String query = "SELECT ID FROM DeThi WHERE MaDeThi = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maDeThi);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                deThiID = rs.getInt("ID");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi lấy DeThiID: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
        return deThiID;
    }
    
    private void loadCauHoiSo(int deThiID) {
        cboxCauHoiSo.removeAllItems();
        Connection conn = new DBConnection().getConnection();
        
        try {
            String numberQuestion = "SELECT CauhoiSo FROM CauHoi WHERE DeThiID = ?";
            PreparedStatement ps = conn.prepareStatement(numberQuestion);
            ps.setInt(1, deThiID);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                cboxCauHoiSo.addItem(String.valueOf(rs.getInt("CauHoiSo")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải danh sách câu hỏi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadCauHoiDetails(int cauHoiSo, int deThiID) {
        Connection conn = new DBConnection().getConnection();
        String detailsQuestion = "SELECT * FROM CauHoi WHERE CauHoiSo = ? AND DeThiID = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(detailsQuestion);
            
            ps.setInt(1, cauHoiSo);
            ps.setInt(2, deThiID);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                txtNoiDung.setText(rs.getString("NoiDung"));
                txtA.setText(rs.getString("A"));
                txtB.setText(rs.getString("B"));
                txtC.setText(rs.getString("C"));
                txtD.setText(rs.getString("D"));
                
                String dapAn = rs.getString("DapAn");
                
                switch(dapAn) {
                    case "A":
                        rbtnA.setSelected(true);
                        break;
                    case "B":
                        rbtnB.setSelected(true);
                        break;
                    case "C":
                        rbtnC.setSelected(true);
                        break;
                    case "D":
                        rbtnD.setSelected(true);
                        break;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải thông tin câu hỏi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateCauHoi(int cauHoiSo, int deThiID) {
        String noiDung = txtNoiDung.getText();
        String A = txtA.getText();
        String B = txtB.getText();
        String C = txtC.getText();
        String D = txtD.getText();
        
        if(noiDung.isEmpty() || A.isEmpty() || B.isEmpty() || C.isEmpty() || D.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ nội dung và 4 đáp án", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String dapAn = rbtnA.isSelected() ? "A" : rbtnB.isSelected() ? "B" : rbtnC.isSelected() ? "C" : "D";
        
        if(dapAn == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đáp án đúng!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Connection conn = new DBConnection().getConnection();
        String update = "UPDATE CauHoi SET NoiDung = ?, A = ?, B = ?, C = ?, D = ?, DapAn = ? \n"
                        + "WHERE CauHoiSo = ? AND DeThiID = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(update);
            
            ps.setString(1, noiDung);
            ps.setString(2, A);
            ps.setString(3, B);
            ps.setString(4, C);
            ps.setString(5, D);
            ps.setString(6, dapAn);
            ps.setInt(7, cauHoiSo);
            ps.setInt(8, deThiID);
            
            int rows = ps.executeUpdate();
            
            if(rows > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật câu hỏi đã Thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy câu hỏi để cập nhật", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi cập nhật câu hỏi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupChonDapAn = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnQuanLyDeThi = new javax.swing.JButton();
        jlabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbtnA = new javax.swing.JRadioButton();
        rbtnB = new javax.swing.JRadioButton();
        rbtnC = new javax.swing.JRadioButton();
        rbtnD = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        txtA = new javax.swing.JTextField();
        txtB = new javax.swing.JTextField();
        txtC = new javax.swing.JTextField();
        txtD = new javax.swing.JTextField();
        btnTimKiemCauHoi = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboxMonThi = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboxMaDeThi = new javax.swing.JComboBox<>();
        btnTimKiemDeThi = new javax.swing.JButton();
        cboxCauHoiSo = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CẬP NHẬT ĐỀ THI");

        btnQuanLyDeThi.setBackground(new java.awt.Color(102, 0, 102));
        btnQuanLyDeThi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnQuanLyDeThi.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyDeThi.setText("Quản lý đề thi");
        btnQuanLyDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyDeThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuanLyDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnQuanLyDeThi)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jlabel.setBackground(new java.awt.Color(0, 0, 0));
        jlabel.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jlabel.setText("Câu hỏi số:");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel2.setText("Nội dung:");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel3.setText("Đáp án:");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel4.setText("A");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel5.setText("B");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel6.setText("C");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel8.setText("D");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel9.setText("Đáp án đúng:");

        groupChonDapAn.add(rbtnA);
        rbtnA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtnA.setText("A");

        groupChonDapAn.add(rbtnB);
        rbtnB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtnB.setText("B");

        groupChonDapAn.add(rbtnC);
        rbtnC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtnC.setText("C");

        groupChonDapAn.add(rbtnD);
        rbtnD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtnD.setText("D");

        txtNoiDung.setBackground(new java.awt.Color(255, 255, 255));
        txtNoiDung.setColumns(20);
        txtNoiDung.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNoiDung.setRows(5);
        jScrollPane1.setViewportView(txtNoiDung);

        txtA.setBackground(new java.awt.Color(255, 255, 255));
        txtA.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtB.setBackground(new java.awt.Color(255, 255, 255));
        txtB.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtC.setBackground(new java.awt.Color(255, 255, 255));
        txtC.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtD.setBackground(new java.awt.Color(255, 255, 255));
        txtD.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        btnTimKiemCauHoi.setBackground(new java.awt.Color(153, 153, 0));
        btnTimKiemCauHoi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnTimKiemCauHoi.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemCauHoi.setText("Tìm kiếm câu hỏi");
        btnTimKiemCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemCauHoiActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 102, 0));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(102, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Môn thi:");

        cboxMonThi.setBackground(new java.awt.Color(255, 255, 255));
        cboxMonThi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxMonThi.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Mã đề thi:");

        cboxMaDeThi.setBackground(new java.awt.Color(255, 255, 255));
        cboxMaDeThi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxMaDeThi.setForeground(new java.awt.Color(0, 0, 0));
        cboxMaDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMaDeThiActionPerformed(evt);
            }
        });

        btnTimKiemDeThi.setBackground(new java.awt.Color(0, 102, 153));
        btnTimKiemDeThi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnTimKiemDeThi.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemDeThi.setText("Tìm kiếm đề thi");
        btnTimKiemDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDeThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(cboxMaDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxMonThi, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnTimKiemDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboxMonThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnTimKiemDeThi)
                    .addComponent(cboxMaDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        cboxCauHoiSo.setBackground(new java.awt.Color(255, 255, 255));
        cboxCauHoiSo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxCauHoiSo.setForeground(new java.awt.Color(0, 0, 0));
        cboxCauHoiSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCauHoiSoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(txtB)
                            .addComponent(txtC)
                            .addComponent(txtA)
                            .addComponent(txtD)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(40, 40, 40)
                                .addComponent(rbtnA)
                                .addGap(54, 54, 54)
                                .addComponent(rbtnB)
                                .addGap(63, 63, 63)
                                .addComponent(rbtnC)
                                .addGap(67, 67, 67)
                                .addComponent(rbtnD))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlabel)
                                .addGap(18, 18, 18)
                                .addComponent(cboxCauHoiSo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(btnTimKiemCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlabel)
                        .addComponent(cboxCauHoiSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiemCauHoi))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(65, 65, 65))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(rbtnA)
                            .addComponent(rbtnB)
                            .addComponent(rbtnC)
                            .addComponent(rbtnD)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnTimKiemCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemCauHoiActionPerformed
        // TODO add your handling code here:
        String selectedMaDeThi = (String) cboxMaDeThi.getSelectedItem();
        
        if(selectedMaDeThi == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mã đề thi!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int deThiID = getDeThiID(selectedMaDeThi);
        
        if(deThiID == -1) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy DeThiID!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String selectedCauHoiSo = (String) cboxCauHoiSo.getSelectedItem();
        
        if(selectedCauHoiSo == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn câu hỏi!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int cauHoiSo = Integer.parseInt(selectedCauHoiSo);
        
        loadCauHoiDetails(cauHoiSo, deThiID);
    }//GEN-LAST:event_btnTimKiemCauHoiActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here
        String selectedMaDeThi = (String) cboxMaDeThi.getSelectedItem();
        
        if(selectedMaDeThi == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mã đề thi!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int deThiID = getDeThiID(selectedMaDeThi);
        
        if(deThiID == -1) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy DeThiID!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String selectedCauHoiSo = (String) cboxCauHoiSo.getSelectedItem();
        
        if(selectedCauHoiSo == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn câu hỏi!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int cauHoiSo = Integer.parseInt(selectedCauHoiSo);
        
        updateCauHoi(cauHoiSo, deThiID);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtNoiDung.setText("");
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtD.setText("");
        
        groupChonDapAn.clearSelection();
        
        cboxMonThi.setSelectedIndex(-1);
        cboxMaDeThi.setSelectedItem(-1);
        cboxCauHoiSo.setSelectedIndex(-1);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnTimKiemDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDeThiActionPerformed
        // TODO add your handling code here:
        String monThi = (String) cboxMonThi.getSelectedItem();
        
        if(monThi != null) {
            loadMaDeThi(monThi);
        }
    }//GEN-LAST:event_btnTimKiemDeThiActionPerformed

    private void cboxCauHoiSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCauHoiSoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cboxCauHoiSoActionPerformed

    private void cboxMaDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMaDeThiActionPerformed
        // TODO add your handling code here:
        String selectedMaDeThi = (String) cboxMaDeThi.getSelectedItem();
        
        if(selectedMaDeThi != null) {
            int deThiID = getDeThiID(selectedMaDeThi);
            
            if(deThiID != -1) {
                loadCauHoiSo(deThiID);;
            }
        }
    }//GEN-LAST:event_cboxMaDeThiActionPerformed

    private void btnQuanLyDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyDeThiActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new formQuanLyDeThi().setVisible(true);
    }//GEN-LAST:event_btnQuanLyDeThiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formCapNhatCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCapNhatCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCapNhatCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCapNhatCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCapNhatCauHoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnQuanLyDeThi;
    private javax.swing.JButton btnTimKiemCauHoi;
    private javax.swing.JButton btnTimKiemDeThi;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboxCauHoiSo;
    private javax.swing.JComboBox<String> cboxMaDeThi;
    private javax.swing.JComboBox<String> cboxMonThi;
    private javax.swing.ButtonGroup groupChonDapAn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel;
    private javax.swing.JRadioButton rbtnA;
    private javax.swing.JRadioButton rbtnB;
    private javax.swing.JRadioButton rbtnC;
    private javax.swing.JRadioButton rbtnD;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextArea txtNoiDung;
    // End of variables declaration//GEN-END:variables
}
