/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dethitracnghiem.client;

import dethitracnghiem.server.CauHoi;
import dethitracnghiem.server.DBConnection;
import dethitracnghiem.server.DeThi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class formXoaCauHoi extends javax.swing.JFrame {
    private CauHoi cauHoi;
    /**
     * Creates new form formXoaCauHoi
     */
    public formXoaCauHoi() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jlabel = new javax.swing.JLabel();
        txtCauHoiSo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtA = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbtnA = new javax.swing.JRadioButton();
        rbtnB = new javax.swing.JRadioButton();
        rbtnC = new javax.swing.JRadioButton();
        rbtnD = new javax.swing.JRadioButton();
        btnClear = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnXoaCauHoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 51));

        jLabel7.setBackground(new java.awt.Color(153, 0, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("XÓA CÂU HỎI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1123, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jlabel.setBackground(new java.awt.Color(0, 0, 0));
        jlabel.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jlabel.setText("Câu hỏi số:");

        txtCauHoiSo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel2.setText("Nội dung:");

        txtNoiDung.setColumns(20);
        txtNoiDung.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNoiDung.setRows(5);
        jScrollPane1.setViewportView(txtNoiDung);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel3.setText("Đáp án:");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel4.setText("A");

        txtA.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel5.setText("B");

        txtB.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel6.setText("C");

        txtC.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel8.setText("D");

        txtD.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

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

        btnClear.setBackground(new java.awt.Color(153, 153, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 0, 0));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(0, 255, 255));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(0, 0, 0));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnXoaCauHoi.setBackground(new java.awt.Color(102, 0, 204));
        btnXoaCauHoi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnXoaCauHoi.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaCauHoi.setText("Delete");
        btnXoaCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCauHoiActionPerformed(evt);
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
                                .addComponent(txtCauHoiSo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiem)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnXoaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel)
                    .addComponent(txtCauHoiSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(11, 11, 11)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnXoaCauHoi))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void timKiemCauHoiSo(int cauHoiSo) {
        String query = "SELECT * FROM CauHoi WHERE CauHoiSo = ?";
        Connection con = new DBConnection().getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cauHoiSo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                DeThi deThi = new DeThi();
                cauHoi = new CauHoi(
                        deThi, 
                        rs.getString("NoiDung"), 
                        rs.getString("A"), 
                        rs.getString("B"), 
                        rs.getString("C"), 
                        rs.getString("D"), 
                        rs.getString("DapAn")
                );
                
                loadCauHoi();
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy câu hỏi với số: " + cauHoiSo, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadCauHoi() {
        txtNoiDung.setText(cauHoi.getNoiDung());
        txtA.setText(cauHoi.getA());
        txtB.setText(cauHoi.getB());
        txtC.setText(cauHoi.getC());
        txtD.setText(cauHoi.getD());
        
        switch(cauHoi.getDapAn()) {
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
    
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtCauHoiSo.setText("");
        txtNoiDung.setText("");
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtD.setText("");
        groupChonDapAn.clearSelection();
        txtCauHoiSo.setEditable(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        int cauHoiSo = Integer.parseInt(txtCauHoiSo.getText());
        timKiemCauHoiSo(cauHoiSo);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCauHoiActionPerformed
        // TODO add your handling code here:
        if(cauHoi == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng tìm kiếm câu hỏi trước khi xóa", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
    }//GEN-LAST:event_btnXoaCauHoiActionPerformed

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
            java.util.logging.Logger.getLogger(formXoaCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formXoaCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formXoaCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formXoaCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formXoaCauHoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaCauHoi;
    private javax.swing.ButtonGroup groupChonDapAn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel;
    private javax.swing.JRadioButton rbtnA;
    private javax.swing.JRadioButton rbtnB;
    private javax.swing.JRadioButton rbtnC;
    private javax.swing.JRadioButton rbtnD;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtCauHoiSo;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextArea txtNoiDung;
    // End of variables declaration//GEN-END:variables
}