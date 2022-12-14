/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kanishka
 */
public class Enroll extends javax.swing.JFrame {

    /**
     * Creates new form Student
     */
    int xx;
    int yy;
    String claId;
    String[] m = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public Enroll() {
        setUndecorated(true);
        initComponents();
        load();
    }

    private void load() {

        loadStudents();
        Home.enroll = true;
        this.jMonthChooser1.setMonth(Integer.parseInt(new SimpleDateFormat("MM").format(new Date())) - 1);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        this.setOpacity(0.95f);
        jButton6.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/close.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));

        jButton5.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/mini.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                yy = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                new Thread(() -> {
                    int x = e.getXOnScreen();
                    int y = e.getYOnScreen();
                    Enroll.this.setLocation(x - xx, y - yy);
                }).start();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    public void loadStudents() {
        try {
            ResultSet rs = MySQL.s("SELECT * FROM `student` WHERE `status`='1'");
            Vector v = new Vector();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("name"));

            }
            jComboBox1.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
        }
    }

    private void clearFileds() {

        jLabel6.setText("None");
        jLabel8.setText("None");

        jLabel10.setText("None");

        jLabel15.setText("None");
        jLabel16.setText(String.valueOf(m[jMonthChooser1.getMonth()]));

        jMonthChooser1.setMonth(Integer.parseInt(new SimpleDateFormat("MM").format(new Date())) - 1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jToggleButton2 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 250));

        jTable1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Student", "Teacher", "Subject", "Time Slot", "Month", "Fee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jLabel1.setText("Student : ");

        jLabel2.setText("Class : ");

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print Invoice");
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new Color(0,0,0,0));
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setMaximumSize(new java.awt.Dimension(15, 15));
        jButton6.setMinimumSize(new java.awt.Dimension(15, 15));
        jButton6.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new Color(0,0,0,0));
        jButton5.setToolTipText("");
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setMaximumSize(new java.awt.Dimension(15, 15));
        jButton5.setMinimumSize(new java.awt.Dimension(15, 15));
        jButton5.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Enroll Student");

        jLabel5.setText("Teacher : ");

        jLabel6.setText("None");

        jLabel7.setText("Subject  : ");

        jLabel8.setText("None");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        jToggleButton2.setText("+");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Class");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Fee : ");

        jLabel10.setText("None");

        jLabel11.setText("Student  :");

        jLabel12.setText("None");

        jMonthChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMonthChooser1PropertyChange(evt);
            }
        });

        jLabel3.setText("Month : ");

        jLabel13.setText("Month : ");

        jLabel14.setText("Time Slot : ");

        jLabel15.setText("None");

        jLabel16.setText("None");

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel17.setText("0.00");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel18.setText("Total : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addComponent(jToggleButton2)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel13))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel15)))
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(76, 76, 76)))))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel18)
                    .addContainerGap(729, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel16))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jButton4))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jToggleButton2)
                                    .addComponent(jLabel1))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(466, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGap(96, 96, 96)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Home.enroll = false;
        this.dispose();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String invoiceId = "INV :" + System.currentTimeMillis();
        String total = jLabel17.getText();
        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        MySQL.iud("INSERT INTO  `invoice` (`invno`,`date`,`value`) VALUES ('" + invoiceId + "','" + dateTime + "','" + total + "') ");
        String stid = "";
        if (jTable1.getRowCount() != 0) {

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                try {
                    ResultSet stu = MySQL.s("SELECT * FROM `student` WHERE `name`='" + jTable1.getValueAt(i, 1) + "'");
                    stu.next();
                    stid = stu.getString("sno");
                    ResultSet tea = MySQL.s("SELECT * FROM `teacher` WHERE `name`='" + jTable1.getValueAt(i, 2) + "'");
                    tea.next();

                    ResultSet sub = MySQL.s("SELECT * FROM `subject` WHERE `description`='" + jTable1.getValueAt(i, 3) + "'");
                    sub.next();

                    String teano = tea.getString("tno");
                    String subno = sub.getString("subno");

                    ResultSet cla = MySQL.s("SELECT * FROM `class` WHERE `teacher_tno`='" + teano + "' AND `subject_subno`='" + subno + "' AND `time_slot`='" + jTable1.getValueAt(i, 4) + "';");
                    cla.next();


                    String stuno = stu.getString("sno");
                    String clano = cla.getString("class_no");
                    Double fee = Double.parseDouble(jTable1.getValueAt(i, 6).toString());
                    String month = jTable1.getValueAt(i, 5).toString();
                    String id = "STUCLA : " + System.currentTimeMillis();

                    MySQL.iud("INSERT INTO `student_subject` (`id`,`student_sno`,`class_class_no`,`invoice_invno`,`fee`,`month`) VALUES('" + id + "','" + stuno + "','" + clano + "','" + invoiceId + "','" + fee + "','" + month + "')");

                } catch (Exception ex) {
                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            try {
                String student = jLabel12.getText();
                InputStream is=getClass().getResourceAsStream("/reports/Invoice.jasper");
//                JasperReport jr = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/Invoice.jrxml"));
                HashMap hm = new HashMap();
                hm.put("Parameter1", invoiceId);
                hm.put("Parameter2", student);
                hm.put("Parameter3", total);
                hm.put("Parameter4", stid);

                JRTableModelDataSource tmd = new JRTableModelDataSource(jTable1.getModel());

                JasperPrint jp = JasperFillManager.fillReport(is, hm, tmd);

                JasperViewer.viewReport(jp,false);
            } catch (JRException ex) {
                Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Plese Enter Data", "Warning", JOptionPane.ERROR_MESSAGE);

        }
        clearFileds();

        jLabel12.setText("None");
        jComboBox1.setEnabled(true);
        jToggleButton2.setEnabled(true);
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        refreshTotal();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            if (evt.getClickCount() == 2) {

                ((DefaultTableModel) jTable1.getModel()).removeRow(jTable1.getSelectedRow());
                refreshTotal();
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
        if (jComboBox1.getSelectedItem() != null) {
            String stu = jComboBox1.getSelectedItem().toString();
            if (stu.equalsIgnoreCase("select")) {
                jLabel12.setText("None");
            } else {
                jLabel12.setText(jComboBox1.getSelectedItem().toString());
            }
        }


    }//GEN-LAST:event_jComboBox1PropertyChange

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        String stu = jComboBox1.getSelectedItem().toString();
        if (stu.equalsIgnoreCase("select")) {
            jLabel12.setText("None");
        } else {
            jLabel12.setText(jComboBox1.getSelectedItem().toString());
        }

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed

        new Student(this).setVisible(true);
        Home.student = true;
        this.jToggleButton2.setEnabled(false);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setEnabled(false);
        new Class(this).setVisible(true);
        Home.cla = true;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMonthChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthChooser1PropertyChange
        jLabel16.setText(String.valueOf(m[jMonthChooser1.getMonth()]));
    }//GEN-LAST:event_jMonthChooser1PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String student = jLabel12.getText();
        String subject = jLabel8.getText();
        String teacher = jLabel6.getText();
        String month = jLabel16.getText();
        String time = jLabel15.getText();
        String fee = jLabel10.getText();

        if (student.equalsIgnoreCase("None")) {
            JOptionPane.showMessageDialog(this, "Select Student", "Warning", JOptionPane.ERROR_MESSAGE);
            jComboBox1.grabFocus();
        } else if (teacher.equalsIgnoreCase("None")) {

            JOptionPane.showMessageDialog(this, "Select Class", "Warning", JOptionPane.ERROR_MESSAGE);

            jButton3.setEnabled(false);
            new Class(this).setVisible(true);
            Home.cla = true;

        } else if (month.equalsIgnoreCase("None")) {
            JOptionPane.showMessageDialog(this, "Select Month", "Warning", JOptionPane.ERROR_MESSAGE);

            jMonthChooser1.grabFocus();
        } else {
            boolean find = false;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (jTable1.getValueAt(i, 3).toString().equals(subject) && jTable1.getValueAt(i, 2).toString().equals(teacher) && jTable1.getValueAt(i, 5).toString().equals(month)) {
                    find = true;
                    break;
                }
            }
            if (find) {
                JOptionPane.showMessageDialog(this, "class Alredy Added", "Warning", JOptionPane.ERROR_MESSAGE);
                clearFileds();
            } else {

                try {

                    ResultSet st = MySQL.s("SELECT * FROM `student` WHERE `name`='" + student + "'");
                    st.next();

                    ResultSet classStu = MySQL.s("SELECT * FROM `student_subject`  WHERE `student_sno`='" + st.getString("sno") + "' AND `class_class_no`='" + claId + "' AND `month`='" + month + "' ");

                    if (classStu.next()) {
                        JOptionPane.showMessageDialog(this, "Student Alredy Paid This Class For This Month", "Warning", JOptionPane.ERROR_MESSAGE);

                    } else {

                        String id = "ENR : " + System.currentTimeMillis();
                        Vector v = new Vector();
                        v.add(id);
                        v.add(student);
                        v.add(teacher);
                        v.add(subject);
                        v.add(time);
                        v.add(month);
                        v.add(fee);
                        ((DefaultTableModel) jTable1.getModel()).addRow(v);
                        clearFileds();
                        refreshTotal();

                        jComboBox1.setEnabled(false);
                        jToggleButton2.setEnabled(false);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        if (evt.getClickCount() == 2) {
            if (!jComboBox1.isEnabled()) {
                clearFileds();

                jLabel12.setText("None");
                jComboBox1.setEnabled(true);
                jToggleButton2.setEnabled(true);
                ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
                refreshTotal();
            }
        }
    }//GEN-LAST:event_jComboBox1MouseClicked

    public void refreshTotal() {
        Double fee = 0d;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            fee += Double.parseDouble(String.valueOf(jTable1.getValueAt(i, 6)));
        }
        jLabel17.setText(String.valueOf(fee));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        MyTheam.setup();
        com.formdev.flatlaf.FlatIntelliJLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Enroll().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
