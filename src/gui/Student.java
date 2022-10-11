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
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Kanishka
 */
public class Student extends javax.swing.JFrame {

    /**
     * Creates new form Student
     */
    int xx;
    int yy;
    String stuId;
    Enroll e;

    public Student() {
        setUndecorated(true);
        initComponents();
        load();
    }

    public Student(Enroll e) {
        this.e = e;
        setUndecorated(true);
        initComponents();
        load();
    }

    private void load() {
        loadStudents();
        Home.student=true;
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
                    Student.this.setLocation(x - xx, y - yy);
                }).start();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    private void loadStudents() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            ResultSet rs = MySQL.s("SELECT * FROM `student` WHERE `status`='1'");
            JButton del = new JButton();
            del.setText("Delete");
            del.setSize(100, 20);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add("Delete");

                dtm.addRow(v);
                if (e != null) {
                    e.loadStudents();
                }
            }

        } catch (Exception e) {
           
        }

    }

    private void clearFileds() {

        jTextField1.setText("");
        jTextField2.setText("");
        jDateChooser1.setDate(null);

    }

    private void loadStudents(String keyword) {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            ResultSet rs = MySQL.s("SELECT * FROM `student` WHERE `student`.`name` LIKE '%" + keyword + "%' AND  `status`='1';");

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add("Delete");

                dtm.addRow(v);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 250));

        jTable1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Address", "Dob", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jLabel1.setText("Name : ");

        jLabel2.setText("Address : ");

        jLabel3.setText("Date Of birth : ");

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
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

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Student Register");

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Update");
        jButton2.setBorderPainted(false);
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(681, 681, 681)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(37, 37, 37)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(11, 11, 11)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(47, 47, 47)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (e != null) {
            e.loadStudents();
            e.jToggleButton2.setEnabled(true);
        }
        Home.student=false;
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = jTextField1.getText();
        String address = jTextField2.getText();

        if (name.isBlank()) {
            JOptionPane.showMessageDialog(this, "Enter Student Name", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField1.grabFocus();
        } else if (address.isBlank()) {
            JOptionPane.showMessageDialog(this, "Enter Student Address", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField2.grabFocus();
        } else if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Enter Student Date Of Birth", "Warning", JOptionPane.WARNING_MESSAGE);
            jDateChooser1.grabFocus();
        } else {
            String date = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
            String id = "STU : " + String.valueOf(System.currentTimeMillis());

            try {
                ResultSet rrs = MySQL.s("SELECT * FROM `student` WHERE `student`.`name`='" + name + "' AND `status`='1' ;");

                if (rrs.next()) {
                    JOptionPane.showMessageDialog(this, "Student Alredy Exsist", "Warning", JOptionPane.WARNING_MESSAGE);
                    clearFileds();
                } else {
                    MySQL.iud("INSERT INTO `student` (`sno`,`name`,`address`,`dob`) VALUES('" + id + "','" + name + "','" + address + "','" + date + "') ");

                    clearFileds();

                    JOptionPane.showMessageDialog(this, "Student Added", "Sucess", JOptionPane.INFORMATION_MESSAGE);

                    loadStudents();
                   
                }
            } catch (Exception ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped

    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            if (evt.getClickCount() == 2) {
                String name = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                String address = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                String dob = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
                stuId = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                jButton2.setEnabled(true);
                jButton1.setEnabled(false);
                jTextField1.setText(name);
                jTextField2.setText(address);
                try {
                    jDateChooser1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(dob));

                } catch (ParseException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (jTable1.getSelectedColumn() == 4) {
                int j = JOptionPane.showConfirmDialog(this, "You Wish To Delete " + jTable1.getValueAt(jTable1.getSelectedRow(), 1), "Warning", JOptionPane.YES_NO_OPTION);
                if (j == JOptionPane.YES_OPTION) {
                    MySQL.iud("UPDATE `student` SET `status`='2' WHERE `student`.`sno`='"+jTable1.getValueAt(jTable1.getSelectedRow(),0)+"'");
                    loadStudents();
                }
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String q = "UPDATE `student`";
        Vector v = new Vector();
        String name = jTextField1.getText();
        String address = jTextField2.getText();

        if (!name.isBlank()) {
            v.add("`student`.`name`='" + name + "'");
        }
        if (!address.isBlank()) {
            v.add("`student`.`address`='" + address + "'");
        }
        if (jDateChooser1.getDate() != null) {
            String dob = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
            v.add("`student`.`dob`='" + dob + "'");
        }
        for (int i = 0; i < v.size(); i++) {
            if (i == 0) {
                q += "SET " + v.get(i);
            } else {
                q += "," + v.get(i);

            }
            if (i == v.size() - 1) {
                q += "," + v.get(i) + " WHERE `student`.`sno`='" + stuId + "'";
            } else {
                q += "," + v.get(i);
            }

        }
        if (q.equals("UPDATE `student`")) {
            jButton2.setEnabled(false);
            jButton1.setEnabled(true);
        } else {
            MySQL.iud(q);
            jButton2.setEnabled(false);
            jButton1.setEnabled(true);
            loadStudents();
            clearFileds();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (evt.getClickCount() == 2) {
            if (!jButton1.isEnabled()) {
                jButton1.setEnabled(true);
                jButton2.setEnabled(false);
                clearFileds();
            }

        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        loadStudents(jTextField3.getText());
    }//GEN-LAST:event_jTextField3KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        MyTheam.setup();
        com.formdev.flatlaf.FlatIntelliJLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Student().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}