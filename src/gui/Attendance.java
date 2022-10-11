/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kanishka
 */
public class Attendance extends javax.swing.JPanel {

    /**
     * Creates new form Attendance
     */
    String[] m = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public Attendance() {
        initComponents();
        loadStudents();
        loadAttendance();
       

    }

    
    
    private void loadStudents() {
        try {
            ResultSet rs = MySQL.s("SELECT * FROM `student` WHERE `status`='1'");
            Vector v = new Vector();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            jComboBox2.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
        }

    }

    private void loadAttendance() {
        jTextField2.grabFocus();
        try {
            String sel = jComboBox1.getSelectedItem().toString();

            String wer = "";
            if (sel.equalsIgnoreCase("today")) {
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                wer += "WHERE `attendance`.`dateTime` LIKE '" + date + "%' ";
            } else if (sel.equalsIgnoreCase("This Month")) {
                String date = new SimpleDateFormat("yyyy-MM").format(new Date());
                wer += "WHERE `attendance`.`dateTime` LIKE '" + date + "%' ";
            } else if (sel.equalsIgnoreCase("This Year")) {
                String date = new SimpleDateFormat("yyyy").format(new Date());
                wer += "WHERE `attendance`.`dateTime` LIKE '" + date + "%' ";
            } else {

            }

            ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
            ResultSet rs = MySQL.s("SELECT * FROM `attendance` \n"
                    + "INNER JOIN `student` ON `attendance`.`student_sno`=`student`.`sno` \n"
                    + "INNER JOIN `class` ON `class`.`class_no`=`attendance`.`class_class_no` \n"
                    + "INNER JOIN `teacher` ON `class`.`teacher_tno`=`teacher`.`tno` \n"
                    + "INNER JOIN `subject` ON `class`.`subject_subno`=`subject`.`subno` " + wer + " ORDER BY   `attendance`.`dateTime` DESC");
            while (rs.next()) {
                Vector at = new Vector();
                at.add(rs.getString("student.name"));
                at.add(rs.getString("subject.description"));
                at.add(rs.getString("teacher.name"));
                at.add(rs.getString("attendance.dateTime"));
                ((DefaultTableModel) jTable1.getModel()).addRow(at);
            }
        } catch (Exception e) {
        }

    }

    private void clear() {
        jLabel6.setText("None");
        jLabel7.setText("None");
        jComboBox2.setSelectedIndex(0);
        jTextField2.setText("");
        jButton3.setEnabled(false);
        jButton1.setEnabled(false);
        jTextField2.grabFocus();

    }

    private void loadAttendance(String condition) {

        try {
            String sel = jComboBox1.getSelectedItem().toString();

            String wer = "";
            if (sel.equalsIgnoreCase("today")) {
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                wer += "WHERE `attendance`.`dateTime` LIKE '" + date + "%'  AND (`student`.`name` LIKE '" + condition + "%' OR `teacher`.`name` LIKE '" + condition + "%' OR `subject`.`description` LIKE '" + condition + "%' OR `attendance`.`dateTime` LIKE '%" + condition + "%')";
            } else if (sel.equalsIgnoreCase("This Month")) {
                String date = new SimpleDateFormat("yyyy-MM").format(new Date());
                wer += "WHERE `attendance`.`dateTime` LIKE '" + date + "%' AND (`student`.`name` LIKE '" + condition + "%' OR `teacher`.`name` LIKE '" + condition + "%' OR `subject`.`description` LIKE '" + condition + "%' OR `attendance`.`dateTime` LIKE '%" + condition + "%')";
            } else if (sel.equalsIgnoreCase("This Year")) {
                String date = new SimpleDateFormat("yyyy").format(new Date());
                wer += "WHERE `attendance`.`dateTime` LIKE '" + date + "%' AND (`student`.`name` LIKE '" + condition + "%' OR `teacher`.`name` LIKE '" + condition + "%' OR `subject`.`description` LIKE '" + condition + "%' OR `attendance`.`dateTime` LIKE '%" + condition + "%')";
            } else {
                wer += "WHERE  `student`.`name` LIKE '" + condition + "%' OR (`teacher`.`name` LIKE '" + condition + "%' OR `subject`.`description` LIKE '" + condition + "%' OR `attendance`.`dateTime` LIKE '%" + condition + "%')";
            }

            ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
            ResultSet rs = MySQL.s("SELECT * FROM `attendance` \n"
                    + "INNER JOIN `student` ON `attendance`.`student_sno`=`student`.`sno` \n"
                    + "INNER JOIN `class` ON `class`.`class_no`=`attendance`.`class_class_no` \n"
                    + "INNER JOIN `teacher` ON `class`.`teacher_tno`=`teacher`.`tno` \n"
                    + "INNER JOIN `subject` ON `class`.`subject_subno`=`subject`.`subno` " + wer + " ORDER BY   `attendance`.`dateTime` DESC");
            while (rs.next()) {
                Vector at = new Vector();
                at.add(rs.getString("student.name"));
                at.add(rs.getString("subject.description"));
                at.add(rs.getString("teacher.name"));
                at.add(rs.getString("attendance.dateTime"));
                ((DefaultTableModel) jTable1.getModel()).addRow(at);
            }
        } catch (Exception e) {
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

        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jLabel3.setText("Class : ");

        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setOpaque(false);

        jTable1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student", "Subject", "Teacher", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Today", "This Month", "This Year", "All" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel1.setText("Student : ");

        jLabel2.setText("Class : ");

        jButton3.setText("Class");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Student Id : ");

        jLabel5.setText("Class Id : ");

        jLabel6.setText("None");

        jLabel7.setText("None");

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(238, 238, 238));
        jButton1.setText("Mark ");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(238, 238, 238));
        jButton2.setText("Print Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField2PropertyChange(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel8.setText("Scan Barcoade : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, 101, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setEnabled(false);
        try {
            int mon = (Integer.parseInt(new SimpleDateFormat("MM").format(new Date()))) - 1;

            ResultSet rs = MySQL.s("SELECT * FROM `student_subject` INNER JOIN `student` ON `student_subject`.`student_sno`=`student`.`sno` WHERE `student`.`sno`='" + jLabel6.getText() + "' AND `student_subject`.`month`='" + m[mon] + "' ;");
            if (rs.next()) {
                new StudentPayments(this).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "This Student Dont Have Clases Plese Enroll Student to a Class", "Warning", JOptionPane.ERROR_MESSAGE);

                new Enroll().setVisible(true);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        String stu = jComboBox2.getSelectedItem().toString();
        if (stu.equalsIgnoreCase("Select")) {
            jLabel6.setText("None");
            jButton3.setEnabled(false);
            jButton1.setEnabled(false);
            jLabel7.setText("None");
        } else {
            try {

                jButton1.setEnabled(false);
                jLabel7.setText("None");
                jButton3.setEnabled(true);
                ResultSet rs = MySQL.s("SELECT * FROM `student` WHERE `status`='1' AND `name`='" + stu + "'");
                rs.next();
                jLabel6.setText(rs.getString("sno"));

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            HashMap hm = new HashMap();
            InputStream is = getClass().getResourceAsStream("/reports/Attendance.jasper");
//            JasperReport jr=JasperCompileManager.compileReport(is);
            JRTableModelDataSource tm = new JRTableModelDataSource(jTable1.getModel());

            JasperPrint jp = JasperFillManager.fillReport(is, hm, tm);

            JasperViewer.viewReport(jp, false);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ResultSet rs = MySQL.s("SELECT * FROM `attendance` WHERE `student_sno`='" + jLabel6.getText() + "' AND `class_class_no`='" + jLabel7.getText() + "' AND `dateTime` LIKE '" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "%' ;");

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "This Student Alredy Marked Attendance", "Warning", JOptionPane.WARNING_MESSAGE);
                jTextField2.grabFocus();
            } else {
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                MySQL.iud("INSERT INTO `attendance` (`student_sno`,`dateTime`,`class_class_no`) VALUES ('" + jLabel6.getText() + "','" + date + "','" + jLabel7.getText() + "')");
            }
            jTextField2.grabFocus();
            clear();
            loadAttendance();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        loadAttendance(jTextField1.getText());
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        loadAttendance(jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

        try {
            ResultSet rs = MySQL.s("SELECT * FROM `student` WHERE `status`='1' AND `sno`='" + jTextField2.getText() + "'");

            if (rs.next()) {
                jLabel6.setText(rs.getString("sno"));
                jButton3.setEnabled(true);
            } else {
//                    JOptionPane.showMessageDialog(this, "Sorry I Cannot Find This Student", "Warning", JOptionPane.WARNING_MESSAGE);
                jLabel6.setText("None");
                jButton3.setEnabled(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField2PropertyChange

        try {
            ResultSet rs = MySQL.s("SELECT * FROM `student` WHERE `status`='1' AND `sno`='" + jTextField2.getText() + "'");

            if (rs.next()) {
                jLabel6.setText(rs.getString("sno"));
                jButton3.setEnabled(true);
            } else {
//                    JOptionPane.showMessageDialog(this, "Sorry I Cannot Find This Student", "Warning", JOptionPane.WARNING_MESSAGE);
                jLabel6.setText("None");
                jButton3.setEnabled(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTextField2PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
