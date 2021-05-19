/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sams;

import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Sumukha B S
 */
public class Student extends javax.swing.JFrame {

    int bl1, bl2;
    String sem, sec, year, course;
    ArrayList<String> Name = new ArrayList<String>();
    ArrayList<String> USN = new ArrayList<String>();
    JLabel l4, l5, l6;
    JRadioButton r1, r2;
    JLabel bu;
    Font f0 = new Font("Arial", Font.BOLD, 22);
    Font f5 = new Font("Arial", Font.BOLD, 24);
    ArrayList<JRadioButton> buttonList = new ArrayList<JRadioButton>();
    ArrayList<JRadioButton> buttonList2 = new ArrayList<JRadioButton>();
    ArrayList<String> usnarray = new ArrayList<String>();

    JLabel bn;
    Font f3 = new Font("Arial", Font.BOLD, 18);

    /**
     * Creates new form Student
     */
    public Student(String sem, String sec, String year, String course) {
        this.sem = sem;
        this.sec = sec;
        this.year = year;
        this.course = course;

        initComponents();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sumukha", "2858");
            String sql = "select USN,name from student where sem='" + this.sem + "' and course_id='" + this.course + "' and sec='" + this.sec + "' order by USN";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Name.add(rs.getString("name"));
                USN.add(rs.getString("USN"));
            }
            l4 = new JLabel("NAME");
            l4.setForeground(Color.BLACK);
            l4.setBounds(350, 200, 300, 100);
            l4.setFont(f5);
            add(l4);
            l5 = new JLabel("USN");
            l5.setForeground(Color.BLACK);
            l5.setBounds(600, 200, 300, 100);
            l5.setFont(f5);
            add(l5);
            l6 = new JLabel("ATTANDANCE STATUS");
            l6.setForeground(Color.BLACK);
            l6.setBounds(850, 200, 300, 100);
            l6.setFont(f5);
            add(l6);

            int Nsize = Name.size();
            int b = 300;

            for (int i = 0; i < Nsize; i++) {

                ButtonGroup bg = new ButtonGroup();
                bn = new JLabel("" + Name.get(i) + "");
                bn.setFont(f3);
                bn.setBounds(350, b, 300, 50);
                add(bn);
                r1 = new JRadioButton("P");
                r2 = new JRadioButton("A");
                Font f4 = new Font("Arial", Font.BOLD, 20);
                bg.add(r1);
                bg.add(r2);
                r1.setFont(f4);
                r2.setFont(f4);
                r1.setBounds(900, b, 50, 40);
                r2.setBounds(950, b, 50, 40);
                add(r1);
                add(r2);
                // r1.setBackground(Color.YELLOW);
                // r2.setBackground(Color.YELLOW);

                //Font f5=new Font("Arial",Font.BOLD,18);
                bu = new JLabel("" + USN.get(i) + "");
                bu.setFont(f3);
                bu.setBounds(600, b, 300, 50);
                //c=c+50;
                add(bu);

                usnarray.add("" + USN.get(i) + "");

                buttonList.add(r1);
                buttonList2.add(r2);

                b = b + 50;
            }
            this.bl1 = buttonList.size();
            this.bl2 = buttonList2.size();

        } catch (Exception e) {
            System.out.println(e);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));

        jLabel1.setText("Section :"+this.sec);

        jLabel2.setText("Subject :"+this.course);

        jLabel3.setText(this.sem);

        jLabel4.setText("Academic Year :"+this.year);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jButton1.setText("click here");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("click here");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("To add Students :");

        jLabel6.setText("To remove Students :");

        jButton3.setText("submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel5)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            new RemoveStudent(this.sem, this.sec, this.year, this.course).setVisible(true);
            setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            new AddStudent(this.sem, this.sec, this.year, this.course).setVisible(true);
            setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sumukha", "2858");

            if (!r1.isSelected() && !r2.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please Update all Students Details");
            } else {
                for (int i = 0; i < bl1; i++) {
                    if (buttonList.get(i).isSelected()) {

                        String sql = "update attendance set no_of_attended_classes=no_of_attended_classes+1 where USN='" + usnarray.get(i) + "' and course_id='" + this.course + "' and year='" +this.year + "' and sem='" + this.sem + "'";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                    } else {
                        String sql2 = "update attendance set no_of_classes_absent=no_of_classes_absent+1 where USN='" + usnarray.get(i) + "' and course_id='" +this.course + "' and year='" + this.year + "' and sem='" + this.sem + "'";
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        ResultSet rs2 = ps2.executeQuery();
                    }
                }
                try {
                    CallableStatement storedProc = conn.prepareCall("{call cpr}");

                    storedProc.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Attendance Updated");
                setVisible(false);
               // hh.h1.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);

            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
    // End of variables declaration//GEN-END:variables
}
