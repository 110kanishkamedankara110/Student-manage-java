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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Kanishka
 */
public class Class extends javax.swing.JFrame {

    /**
     * Creates new form Student
     */
    int xx;
    int yy;
    String claId;
    Enroll e;
    StudentPayments sp;
    TimeTable tb;

    public Class() {
        setUndecorated(true);
        initComponents();
        load();
    }

    public Class(Enroll e) {
        this.e = e;
        setUndecorated(true);
        initComponents();
        load();
    }
    public Class(TimeTable tb) {
        this.tb = tb;
        setUndecorated(true);
        initComponents();
        load();
    }

    public Class(StudentPayments sp) {
        this.sp = sp;
        setUndecorated(true);
        initComponents();
        load();
    }

    private void load() {
        loadClass();
        loadSubjects();
        loadTeachers();
        Home.cla = true;
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
                    Class.this.setLocation(x - xx, y - yy);
                }).start();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    private void loadClass() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            ResultSet rs = MySQL.s("SELECT * FROM `class` INNER JOIN `teacher` ON `teacher`.`tno`=`class`.`teacher_tno` INNER JOIN `subject` ON `subject`.`subno`=`class`.`subject_subno` AND `teacher`.`status`='1' AND `subject`.`status`='1' ORDER BY `class`.`time_slot` DESC ");

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("class.class_no"));
                v.add(rs.getString("teacher.name"));
                v.add(rs.getString("subject.description"));
                v.add(rs.getString("class.time_slot"));

                dtm.addRow(v);
            }

        } catch (Exception e) {

        }

    }

    public void loadTeachers() {
        try {
            ResultSet rs = MySQL.s("SELECT * FROM `teacher` WHERE `status`='1'");
            Vector v = new Vector();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("name"));

            }
            jComboBox1.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
        }
    }

    public void loadSubjects() {
        try {
            ResultSet rs = MySQL.s("SELECT * FROM `subject` WHERE `status`='1'");
            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("description"));

            }
            jComboBox2.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
        }
    }

    private void clearFileds() {

        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);

//        try {
//            jTimeChooser1.setTime(new SimpleDateFormat("HH:mm:ss").parse("00:00:00"));
//        } catch (ParseException ex) {
//            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
//        }
        jLabel6.setText("None");
        jLabel8.setText("None");
        jTextField2.setText("");

    }

    private void loadClass(String keyword) {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            ResultSet rs = MySQL.s("SELECT * FROM `class` INNER JOIN `subject` ON `class`.`subject_subno`=`subject`.`subno` INNER JOIN `teacher` ON `class`.`teacher_tno`=`teacher`.`tno` WHERE `subject`.`description` LIKE '%" + keyword + "%' OR `teacher`.`name` LIKE '%" + keyword + "%' AND `teacher`.`status`='1' AND `subject`.`status`='1';");

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("class.class_no"));
                v.add(rs.getString("teacher.name"));
                v.add(rs.getString("subject.description"));
                v.add(rs.getString("class.time_slot"));

                dtm.addRow(v);
            }

        } catch (Exception e) {

        }
    }

    private void refresh() {

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
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 250));

        jScrollPane1.setBackground(new java.awt.Color(250, 250, 250));

        jTable1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Teacher", "Subject", "Duration"
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

        jLabel1.setText("Teacher : ");

        jLabel2.setText("Subject : ");

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Class Register");

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

        jLabel5.setText("Teacher Id :");

        jLabel6.setText("None");

        jLabel7.setText("Subject Id : ");

        jLabel8.setText("None");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jToggleButton1.setText("+");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("+");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel3.setText("Duration :");

        jLabel9.setText("h");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, 188, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jToggleButton2)
                                    .addComponent(jToggleButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToggleButton2)
                                .addComponent(jLabel1)))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToggleButton1)
                                .addComponent(jLabel2))))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (e != null) {
            e.jButton3.setEnabled(true);
        }
        if (sp != null) {
            sp.jButton3.setEnabled(true);
        }
        Home.cla = false;
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String teacher = jLabel6.getText();
        String subject = jLabel8.getText();

        if (teacher.equalsIgnoreCase("None")) {
            JOptionPane.showMessageDialog(this, "Select Teacher", "Warning", JOptionPane.WARNING_MESSAGE);
            jComboBox1.grabFocus();
        } else if (subject.equalsIgnoreCase("None")) {
            JOptionPane.showMessageDialog(this, "Select Subject", "Warning", JOptionPane.WARNING_MESSAGE);
            jComboBox2.grabFocus();
        } 

        else if (jTextField2.getText().equals("0") || jTextField2.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Select Duration", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField2.grabFocus();

        } else {

            if (Pattern.compile("[1-5][.]").matcher(jTextField2.getText()).matches()) {
                jTextField2.setText(jTextField2.getText() + "00");
            }
            if (Pattern.compile("[1-5]").matcher(jTextField2.getText()).matches()) {
                jTextField2.setText(jTextField2.getText() + ".00");
            }

            String id = "CLA : " + String.valueOf(System.currentTimeMillis());
            String duration = jTextField2.getText();



            try {

                ResultSet rrs = MySQL.s("SELECT * FROM `Class` WHERE  `class`.`teacher_tno`='" + teacher + "' ;");

                if (rrs.next()) {
                    JOptionPane.showMessageDialog(this, "This Teacher Aledy Registred To This Class", "Warning", JOptionPane.WARNING_MESSAGE);
                    clearFileds();
                } else {
                    MySQL.iud("INSERT INTO `class` (`class_no`,`time_slot`,`teacher_tno`,`subject_subno`) VALUES('" + id + "','" + duration + "','" + teacher + "','" + subject + "') ");

                    clearFileds();

                    JOptionPane.showMessageDialog(this, "Class Added", "Sucess", JOptionPane.INFORMATION_MESSAGE);

                    loadClass();
                }
            } catch (Exception ex) {
                Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            if (evt.getClickCount() == 2) {

                String teacher = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                String subject = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();

                claId = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                jButton2.setEnabled(true);
                jButton1.setEnabled(false);
                jComboBox1.setSelectedItem(teacher);
                jComboBox2.setSelectedItem(subject);
                jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());


                if (e != null) {
                    e.jLabel6.setText(teacher);
                    e.jLabel8.setText(subject);
                    try {
                        ResultSet rs = MySQL.s("SELECT * FROM `subject` WHERE `description`='" + subject + "';");
                        rs.next();
                        e.jLabel10.setText(rs.getString("price"));
                    } catch (Exception ex) {
                        Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    e.jLabel15.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                    e.jButton3.setEnabled(true);
                    e.claId = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    Home.cla = false;
                    this.dispose();
                }
                if (sp != null) {

                    sp.jLabel3.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    sp.jButton3.setEnabled(true);
                    sp.search();
                    Home.cla = false;
                    this.dispose();
                }
                if(tb!=null){
                    TimeTable.duration=Double.parseDouble(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                    tb.jLabel7.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    this.dispose();
                }

            }
            
            

        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String q = "UPDATE `Class`";
        Vector v = new Vector();
        String teacher = jLabel6.getText();
        String subject = jLabel8.getText();

        if (!teacher.equalsIgnoreCase("None")) {
            v.add("`class`.`teacher_tno`='" + teacher + "'");
        }
        if (!subject.equalsIgnoreCase("None")) {
            v.add("`class`.`subject_subno`='" + subject + "'");
        }


            if (jTextField2.getText().equals("0") || jTextField2.getText().isBlank()) {

            } else {
                if (Pattern.compile("[1-5][.]").matcher(jTextField2.getText()).matches()) {
                    jTextField2.setText(jTextField2.getText() + "00");
                }
                if (Pattern.compile("[1-5]").matcher(jTextField2.getText()).matches()) {
                    jTextField2.setText(jTextField2.getText() + ".00");
                }

                String duration = jTextField2.getText();



                v.add("`class`.`time_slot`='" + duration + "'");
            }

        for (int i = 0; i < v.size(); i++) {
            if (i == 0) {
                q += "SET " + v.get(i);
            } else {
                q += "," + v.get(i);

            }
            if (i == v.size() - 1) {
                q += "," + v.get(i) + " WHERE `class`.`class_no`='" + claId + "'";
            } else {
                q += "," + v.get(i);
            }

        }

        if (q.equals("UPDATE `class`")) {
            jButton2.setEnabled(false);
            jButton1.setEnabled(true);
        } else {
            MySQL.iud(q);
            jButton2.setEnabled(false);
            jButton1.setEnabled(true);
            loadClass();
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

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange


    }//GEN-LAST:event_jComboBox1PropertyChange

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        try {

            String teacher = jComboBox1.getSelectedItem().toString();
            if (!teacher.equalsIgnoreCase("Select")) {
                ResultSet rs = MySQL.s("SELECT * FROM `teacher` WHERE `name`='" + teacher + "'");
                rs.next();
                jLabel6.setText(rs.getString("tno"));
            } else {
                jLabel6.setText("None");
            }
        } catch (Exception ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        try {

            String subject = jComboBox2.getSelectedItem().toString();
            if (!subject.equalsIgnoreCase("Select")) {
                ResultSet rs = MySQL.s("SELECT * FROM `subject` WHERE `description`='" + subject + "'");
                rs.next();
                jLabel8.setText(rs.getString("subno"));
            } else {
                jLabel8.setText("None");
            }
        } catch (Exception ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed

        new Teacher(this).setVisible(true);
        Home.teacher=true;
        this.jToggleButton2.setEnabled(false);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        new Subject(this).setVisible(true);
        Home.subject=true;
        this.jToggleButton1.setEnabled(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        loadClass(jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        if(evt.isControlDown()){
            jTextField2.setText("");
        }
        
        if (!Pattern.compile("([1-5])|([1-4]|[1-4][.]|[1-4][.][0-6]|[1-4][.][0-6][0-9])").matcher(jTextField2.getText() + evt.getKeyChar()).matches()) {
            evt.consume();

        }
    }//GEN-LAST:event_jTextField2KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        MyTheam.setup();
        com.formdev.flatlaf.FlatIntelliJLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Class().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}