/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dethitracnghiem.client;

import dethitracnghiem.server.Student;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class formAdminStudent extends javax.swing.JFrame {

    /**
     * Creates new form formAdminStudent
     */
    public formAdminStudent() {
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

        gruopGioiTinh = new javax.swing.ButtonGroup();
        panelContainer = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        dateChooserDOB = new com.toedter.calendar.JDateChooser();
        btnSaveStudent = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnTroVe = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDSThiSinh = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTroVe1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ĐĂNG KÝ THI TRẮC NGHIỆM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Họ và tên:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email:");

        txtHoTen.setBackground(new java.awt.Color(255, 255, 255));
        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(0, 0, 0));

        txtSoDienThoai.setBackground(new java.awt.Color(255, 255, 255));
        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoDienThoai.setForeground(new java.awt.Color(0, 0, 0));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Giới tính:");

        gruopGioiTinh.add(rbtnNam);
        rbtnNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnNam.setForeground(new java.awt.Color(0, 0, 0));
        rbtnNam.setText("Nam");

        gruopGioiTinh.add(rbtnNu);
        rbtnNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnNu.setForeground(new java.awt.Color(0, 0, 0));
        rbtnNu.setText("Nữ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ngày sinh:");

        dateChooserDOB.setBackground(new java.awt.Color(255, 255, 255));
        dateChooserDOB.setForeground(new java.awt.Color(0, 0, 0));
        dateChooserDOB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSaveStudent.setBackground(new java.awt.Color(51, 153, 0));
        btnSaveStudent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSaveStudent.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveStudent.setText("Thêm thí sinh");
        btnSaveStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveStudentActionPerformed(evt);
            }
        });

        btnTroVe.setBackground(new java.awt.Color(255, 153, 153));
        btnTroVe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTroVe.setForeground(new java.awt.Color(0, 0, 0));
        btnTroVe.setText("Trở về");
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Password:");

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(41, 41, 41)
                        .addComponent(rbtnNam)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnNu))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSaveStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(36, 36, 36)
                                .addComponent(txtPassword))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(31, 31, 31)
                                .addComponent(dateChooserDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(txtEmail))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(33, 33, 33)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                    .addComponent(txtSoDienThoai))))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6))
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(rbtnNam)
                    .addComponent(rbtnNu))
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        tableDSThiSinh.setBackground(new java.awt.Color(153, 153, 153));
        tableDSThiSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thí sinh", "Họ và tên", "Số điện thoại", "Email", "Giới tính", "Ngày sinh"
            }
        ));
        jScrollPane1.setViewportView(tableDSThiSinh);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN THÍ SINH THI TRẮC NGHIỆM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
        );

        btnTroVe1.setBackground(new java.awt.Color(51, 153, 255));
        btnTroVe1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTroVe1.setForeground(new java.awt.Color(255, 255, 255));
        btnTroVe1.setText("Danh sách thí sinh");
        btnTroVe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVe1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(btnTroVe1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 444, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTroVe1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resetThiSinh() {
        this.txtHoTen.setText("");
        this.txtPassword.setText("");
        this.txtSoDienThoai.setText("");
        this.txtEmail.setText("");
        this.gruopGioiTinh.clearSelection();
        this.dateChooserDOB.setDate(null);
    }
    
    private void btnSaveStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveStudentActionPerformed
        // TODO add your handling code here:
        System.out.println("Save Button Clicked...");
        
        String hoTen = this.txtHoTen.getText().trim();
        String soDienThoai = this.txtSoDienThoai.getText().trim();
        String email = this.txtEmail.getText().trim();
        String password = new String(this.txtPassword.getText().trim());
        
        Character gioiTinh = null;
        
        Date ngaySinh = dateChooserDOB.getDate();
        
        if(ngaySinh == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(rbtnNam.isSelected()) {
            gioiTinh = 'M';
        } else if(rbtnNu.isSelected()) {
            gioiTinh = 'F';
        }
        
        Pattern p = Pattern.compile("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.(([0-9]{1,3})|([a-zA-Z]{2,3})|(aero|coop|info|museum|name))$");
        
        if(hoTen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if(soDienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if(soDienThoai.length() < 10) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại đúng 10 chữ số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if(!p.matcher(email).matches()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng email", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if(password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if(password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu ít nhất 6 ký tự", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        
        java.sql.Date date = new java.sql.Date(ngaySinh.getTime());
        
        Student student = new Student(hoTen, soDienThoai, gioiTinh, email, password, date);
        
        boolean result = student.save();
        
        if(result) {
            JOptionPane.showMessageDialog(this, "Thí sinh đã đăng ký Thành công");
            resetThiSinh();
        } else {
            JOptionPane.showMessageDialog(this, "Thí sinh đã đăng ký Thất bại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveStudentActionPerformed

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new formAdminHomeScreen().setVisible(true);
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void btnTroVe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVe1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTroVe1ActionPerformed

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
            java.util.logging.Logger.getLogger(formAdminStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formAdminStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formAdminStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formAdminStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formAdminStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveStudent;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JButton btnTroVe1;
    private com.toedter.calendar.JDateChooser dateChooserDOB;
    private javax.swing.ButtonGroup gruopGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.JTable tableDSThiSinh;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
