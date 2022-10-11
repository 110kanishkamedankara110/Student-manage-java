/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.pixbin.encript.Encriptor;
import com.pixbin.encript.Decriptor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.MySQL;

/**
 *
 * @author Kanishka
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Splash
     */
    int xx, yy;
    static String user;

    public Login() {
        try {
            File f = new File("C:\\Users\\Kanishka\\Documents\\ClassManage\\Database.txt");
            if (f.exists()) {
                FileReader fr = new FileReader("C:\\Users\\Kanishka\\Documents\\ClassManage\\Database.txt");
                BufferedReader br = new BufferedReader(fr);
               
                int i;
                StringBuffer s = new StringBuffer();

                while ((i = br.read()) != -1) {
                    s.append((char) i);
                }

                String str = s.toString();
                if (!str.isBlank()) {
                    Decriptor d = new Decriptor();
                    String decripted = d.decriptString(str);
                    
                    try {
                        java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/" + decripted.split("-")[2], decripted.split("-")[0], decripted.split("-")[1]);

                        this.setUndecorated(true);
                        initComponents();
                        setup();
                    } catch (ClassNotFoundException cn) {

                    } catch (SQLException se) {
                        new DatabaseConfig(this, true).setVisible(true);
                        this.dispose();
                    }

                }else{
                new DatabaseConfig(this, true).setVisible(true);
                this.dispose();
                }

            } else {
                File fil = new File("C:\\Users\\Kanishka\\Documents\\ClassManage\\Database.txt");
                new File("C:\\Users\\Kanishka\\Documents\\ClassManage").mkdir();
                fil.createNewFile();
                new DatabaseConfig(this, true).setVisible(true);
                this.dispose();
            }

        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setup() {

        try {
            File f = new File("C:\\Users\\Kanishka\\Documents\\ClassManage\\ses.txt");
            if (f.exists()) {
                FileReader fr = new FileReader("C:\\Users\\Kanishka\\Documents\\ClassManage\\ses.txt");
                BufferedReader br = new BufferedReader(fr);
                int i;
                StringBuffer s = new StringBuffer();
              

                while ((i = br.read()) != -1) {
                    s.append((char) i);
                }

                String str = s.toString();
                if (!str.isBlank()) {
                    Decriptor d = new Decriptor();
                    String decripted = d.decriptString(str);
                    String query = "SELECT * FROM `admin` WHERE  `username`='" + decripted.split("-")[0] + "' AND `password`='" + decripted.split("-")[1] + "' AND `status`='1';";

                    ResultSet rs = MySQL.s(query);
                    if (rs.next()) {
                        user = decripted.split("-")[0];
                        jTextField1.setText(rs.getString("username"));
                        jPasswordField1.setText(rs.getString("password"));
                    }

                }

            }
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        setIconImage(new ImageIcon(getClass().getResource("/resources/logo.png")).getImage());
        jPanel4.setBackground(new Color(255, 255, 255, 150));

        jButton3.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/close.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));

        jButton2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/mini.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));

        addMouseListener(new MouseListener() {

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
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                new Thread(() -> {
                    int x = e.getXOnScreen();
                    int y = e.getYOnScreen();
                    Login.this.setLocation(x - xx, y - yy);
                }).start();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    private void loading(ResultSet rs) {
        new Thread(() -> {
            try {
                for (int v = 0; v <= 100; v++) {

                    jProgressBar1.setValue(v);
                    Thread.sleep(20);

                }

                this.dispose();
                new Home(rs).setVisible(true);
            } catch (Exception ex) {
            }
        }).start();

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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        jPanel3.setOpaque(false);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nanasa");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jProgressBar1.setBackground(new java.awt.Color(238, 238, 238));
        jProgressBar1.setForeground(new java.awt.Color(11, 245, 91));
        jProgressBar1.setBorderPainted(false);

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Institute");

        jTextField1.setBackground(new java.awt.Color(226, 225, 253));
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setSelectionColor(new java.awt.Color(204, 204, 204));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jPasswordField1.setBackground(new java.awt.Color(226, 225, 253));
        jPasswordField1.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordField1.setSelectionColor(new java.awt.Color(204, 204, 204));
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("User Name :");

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Password : ");

        jButton1.setBackground(new java.awt.Color(204, 0, 20));
        jButton1.setForeground(new java.awt.Color(238, 238, 238));
        jButton1.setText("LogIn");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(78, 78, 78))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jButton2.setBackground(new Color(0,0,0,0));
        jButton2.setToolTipText("");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setMaximumSize(new java.awt.Dimension(15, 15));
        jButton2.setMinimumSize(new java.awt.Dimension(15, 15));
        jButton2.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new Color(0,0,0,0));
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setMaximumSize(new java.awt.Dimension(15, 15));
        jButton3.setMinimumSize(new java.awt.Dimension(15, 15));
        jButton3.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setBackground(new java.awt.Color(153, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/loading bg2.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(743, 424));
        jLabel1.setMinimumSize(new java.awt.Dimension(743, 424));
        jLabel1.setPreferredSize(new java.awt.Dimension(743, 424));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Thread(() -> {
            jTextField1.setEnabled(false);
            jPasswordField1.setEnabled(false);
            jButton1.setEnabled(false);

            String name = jTextField1.getText();
            String password = jPasswordField1.getText();

            if (name.isBlank()) {
                JOptionPane.showMessageDialog(this, "Enter Your Name", "Warning", JOptionPane.WARNING_MESSAGE);

                jTextField1.setEnabled(true);
                jButton1.setEnabled(true);
                jTextField1.grabFocus();
            } else if (password.isBlank()) {
                JOptionPane.showMessageDialog(this, "Enter Your Password", "Warning", JOptionPane.WARNING_MESSAGE);

                jPasswordField1.setEnabled(true);
                jButton1.setEnabled(true);
                jPasswordField1.grabFocus();
            } else {
                jLabel6.setText("");
                String query = "SELECT * FROM `admin` WHERE  `username`='" + name + "' AND `password`='" + password + "' AND `status`='1';";

                try {
                    ResultSet rs = MySQL.s(query);
                    if (rs.next()) {
                        File f = new File("C:\\Users\\Kanishka\\Documents\\ClassManage");
                        if (!f.exists()) {
                            f.mkdir();

                        }
                        FileWriter fr = new FileWriter("C:\\Users\\Kanishka\\Documents\\ClassManage\\ses.txt");
                        Encriptor e = new Encriptor();
                        fr.write(e.encriptString(name + "-" + password));

                        fr.flush();
                        fr.close();
                        loading(rs);
                        user = name;
                        jPasswordField1.setEnabled(false);
                        jTextField1.setEnabled(false);
                        jButton1.setEnabled(false);
                    } else {

                        JOptionPane.showMessageDialog(this, "Invalid Login", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField1.setText("");
                        jPasswordField1.setText("");
                        jButton1.setEnabled(true);
                        jPasswordField1.setEnabled(true);
                        jTextField1.setEnabled(true);
                        jTextField1.grabFocus();
                    }

                } catch (Exception ex) {

                }
            }
        }).start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == 10) {
            if (jTextField1.getText().isBlank()) {
                jTextField1.grabFocus();
            } else if (jPasswordField1.getText().isBlank()) {
                jPasswordField1.grabFocus();
            } else {
                jButton1.doClick();
            }

        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        if (evt.getKeyCode() == 10) {
            if (jTextField1.getText().isBlank()) {
                jTextField1.grabFocus();
            } else if (jPasswordField1.getText().isBlank()) {
                jPasswordField1.grabFocus();
            } else {
                jButton1.doClick();
            }

        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        MyTheam.setup();
        com.formdev.flatlaf.FlatIntelliJLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Login l = new Login();

            l.setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
