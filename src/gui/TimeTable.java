/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TimeTable extends javax.swing.JPanel {

    /**
     * Creates new form TimeTable
     */
    public static double duration;

    public TimeTable() {
        initComponents();

    }

    private void loadTimeTable() {
        try {

            String sel = jComboBox1.getSelectedItem().toString();

            String wer = "";
            if (sel.equalsIgnoreCase("today")) {
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                wer += "WHERE `shedule`.`status_id`='1' AND `shedule`.`date` LIKE '" + date + "%' ";
            } else if (sel.equalsIgnoreCase("This Month")) {
                String date = new SimpleDateFormat("yyyy-MM").format(new Date());
                wer += " WHERE `shedule`.`status_id`='1' AND `shedule`.`date` LIKE '" + date + "%' ";
            } else if (sel.equalsIgnoreCase("This Year")) {
                String date = new SimpleDateFormat("yyyy").format(new Date());
                wer += "WHERE `shedule`.`status_id`='1' AND `shedule`.`date` LIKE '" + date + "%' ";
            } else {
                wer += "WHERE `shedule`.`status_id`='1'";
            }

            ResultSet rs = MySQL.s("SELECT * FROM `shedule` \n"
                    + "INNER JOIN `class` ON `class`.`class_no`=`shedule`.`class_class_no`\n"
                    + "INNER JOIN `teacher` ON `class`.`teacher_tno`=`teacher`.`tno`\n"
                    + "INNER JOIN `subject` ON `class`.`subject_subno`=`subject`.`subno` " + wer + "ORDER BY   `shedule`.`date` DESC ");
            ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("shedule.id"));
                v.add(rs.getString("subject.description"));
                v.add(rs.getString("teacher.name"));
                v.add(rs.getString("shedule.date"));
                ((DefaultTableModel) jTable1.getModel()).addRow(v);

            }

        } catch (Exception e) {
        }

    }

    private void loadTimeTable(String condition) {

        try {

            String sel = jComboBox1.getSelectedItem().toString();

            String wer = "";
            if (sel.equalsIgnoreCase("today")) {
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                wer += "WHERE (`shedule`.`status_id`='1' AND `shedule`.`date` LIKE '" + date + "%') AND (`subject`.`description` LIKE '" + condition + "%' OR `teacher`.`name` LIKE '" + condition + "%' OR `shedule`.`date` LIKE '%" + condition + "%' )";
            } else if (sel.equalsIgnoreCase("This Month")) {
                String date = new SimpleDateFormat("yyyy-MM").format(new Date());
                wer += "WHERE (`shedule`.`status_id`='1' AND`shedule`.`date` LIKE '" + date + "%') AND (`subject`.`description` LIKE '" + condition + "%' OR `teacher`.`name` LIKE '" + condition + "%' OR `shedule`.`date` LIKE '%" + condition + "%' )";
            } else if (sel.equalsIgnoreCase("This Year")) {
                String date = new SimpleDateFormat("yyyy").format(new Date());
                wer += "WHERE (`shedule`.`status_id`='1' AND `shedule`.`date` LIKE '" + date + "%') AND (`subject`.`description` LIKE '" + condition + "%' OR `teacher`.`name` LIKE '" + condition + "%' OR `shedule`.`date` LIKE '%" + condition + "%' )";
            } else {
                wer += "WHERE (`shedule`.`status_id`='1') AND (`subject`.`description` LIKE '" + condition + "%' OR `teacher`.`name` LIKE '" + condition + "%' OR `shedule`.`date` LIKE '%" + condition + "%') ";
            }

            ResultSet rs = MySQL.s("SELECT * FROM `shedule` \n"
                    + "INNER JOIN `class` ON `class`.`class_no`=`shedule`.`class_class_no`\n"
                    + "INNER JOIN `teacher` ON `class`.`teacher_tno`=`teacher`.`tno`\n"
                    + "INNER JOIN `subject` ON `class`.`subject_subno`=`subject`.`subno` " + wer + " ORDER BY   `shedule`.`date` DESC");
            ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("shedule.id"));
                v.add(rs.getString("subject.description"));
                v.add(rs.getString("teacher.name"));
                v.add(rs.getString("shedule.date"));
                ((DefaultTableModel) jTable1.getModel()).addRow(v);

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jTimeChooser1 = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jTable1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Subject", "Teacher", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Today", "This Month", "This Year" }));
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
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        jLabel2.setText("Class : ");

        jButton3.setText("Class");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Class Id : ");

        jLabel7.setText("None");

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(238, 238, 238));
        jButton1.setText("Shedule");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(238, 238, 238));
        jButton2.setText("Print Shedule");
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

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel3.setText("Date : ");

        jTimeChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTimeChooser1PropertyChange(evt);
            }
        });
        jTimeChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTimeChooser1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTimeChooser1KeyReleased(evt);
            }
        });

        jLabel4.setText("Time : ");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ref.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTimeChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                .addGap(351, 351, 351))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7))
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButton3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTimeChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        loadTimeTable(jTextField1.getText());
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Class(this).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            String c = jLabel7.getText();
            Date d = jDateChooser1.getDate();
            String t = jTimeChooser1.getTimeField().getText();
            if (c.equalsIgnoreCase("None")) {
                JOptionPane.showMessageDialog(this, "Plese Select The Class", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (d == null) {
                JOptionPane.showMessageDialog(this, "Plese Select The Date", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (new Date().after(d)) {
                JOptionPane.showMessageDialog(this, "Invalid Date", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (t.equals("00:00:00")) {
                JOptionPane.showMessageDialog(this, "Plese Select The Time", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                String dur = new DecimalFormat("0.00").format(duration);
                String endTIme = (new SimpleDateFormat("HH:mm:ss").format((new SimpleDateFormat("HH:mm:ss").parse(t).getTime()) + (Integer.parseInt(dur.split("[.]")[0]) * 60 * 60 * 1000) + (Integer.parseInt(dur.split("[.]")[1]) * 60 * 1000)));
                String dtime = new SimpleDateFormat("yyyy-MM-dd").format(d) + " " + jTimeChooser1.getTimeField().getText() + " - " + endTIme;

                ResultSet rs = MySQL.s("SELECT * FROM `shedule` WHERE  `class_class_no`='" + jLabel7.getText() + "' AND `date`='" + dtime + "' AND `shedule`.`status_id`='1';");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "This This Class Alredy Sheduled This Day", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    MySQL.iud("INSERT INTO `shedule` (`date`,`class_class_no`,`status_id`) VALUES ('" + dtime + "','" + jLabel7.getText() + "','1')");
                }
                clear();
                loadTimeTable();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void clear() {
        try {
            jLabel7.setText("None");
            jDateChooser1.setDate(null);
            jTimeChooser1.setTime(new SimpleDateFormat("HH:mm:ss").parse("00:00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {

            HashMap hm = new HashMap();
            JRTableModelDataSource jt = new JRTableModelDataSource(jTable1.getModel());
//            JasperReport jc=JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/Time.jrxml"));
            InputStream is = getClass().getResourceAsStream("/reports/Time.jasper");
            JasperPrint jp = JasperFillManager.fillReport(is, hm, jt);
            JasperViewer.viewReport(jp, false);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTimeChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTimeChooser1KeyReleased


    }//GEN-LAST:event_jTimeChooser1KeyReleased

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange


    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jTimeChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTimeChooser1PropertyChange

    }//GEN-LAST:event_jTimeChooser1PropertyChange

    private void jTimeChooser1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTimeChooser1KeyPressed

    }//GEN-LAST:event_jTimeChooser1KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            jLabel7.setText("None");
            jDateChooser1.setDate(null);
            jTimeChooser1.setTime(new SimpleDateFormat("HH:mm:ss").parse("00:00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
        loadTimeTable(jTextField1.getText());
    }//GEN-LAST:event_jComboBox1PropertyChange

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        loadTimeTable(jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            if (evt.getClickCount() == 2) {
                if (JOptionPane.showConfirmDialog(this, "You Wish To Cancel This Class", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {

                        MySQL.iud("UPDATE `shedule` SET `status_id`='2' WHERE `shedule`.`id`='" + jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "'");

                        jTextField1.setText("");
                        loadTimeTable();
                    } catch (Exception ex) {
                        Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    public lu.tudor.santec.jtimechooser.JTimeChooser jTimeChooser1;
    // End of variables declaration//GEN-END:variables
}
