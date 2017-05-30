/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.view;

import com.ijse.es.connector.ServerConnector;
import com.ijse.es.controller.ExamController;
import com.ijse.es.controller.StudentController;
import com.ijse.es.dto.ExamDTO;
import com.ijse.es.dto.LecturerDTO;
import com.ijse.es.observer.Observer;
import com.ijse.es.observer.Subject;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ExamDetailForm extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form StudentForm
     */
    int xMouse;
    int yMouse;
    private LecturerDTO lecturerDTO;
    public static HomeStudentForm homeStudentForm;

    public ExamDetailForm(LecturerDTO lecturerDTO) {
        this.lecturerDTO = lecturerDTO;
        try {
            initComponents();
            enhancements();
            setTime();
            UnicastRemoteObject.exportObject(this, 0);
            ExamController controller = ServerConnector.getServerConnector().getExamController();
            Subject subject = (Subject) controller;
            subject.registerObserver(this);
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(ExamDetailForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //to enhance beauty
    public void enhancements() {
        jPanel1.setBackground(new Color(0, 0, 0, 102));
        setLocationRelativeTo(null);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel4.setVisible(false);
        jPanel1.setVisible(false);
        jLabel12.setVisible(false);
        jLabel19.setVisible(false);
        txtBatch.setVisible(false);
        lblBatch.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblCancel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblProceed = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtExamTitle = new javax.swing.JTextField();
        jCalendarCombo1 = new org.freixas.jcalendar.JCalendarCombo();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtExamID = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jlbl = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtBatch = new javax.swing.JTextField();
        lblBatch = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtSubject = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        spHard = new javax.swing.JSpinner();
        spEasy = new javax.swing.JSpinner();
        spMedium = new javax.swing.JSpinner();
        btnPublic = new javax.swing.JRadioButton();
        btnPrivate = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/home1.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 70));

        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("time");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 100, 50));

        jLabel5.setFont(new java.awt.Font("Raleway Light", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/exam1.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 80));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/circle1.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 100, 80));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("subject");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 110, -1));

        lblCancel.setBackground(new java.awt.Color(153, 153, 153));
        lblCancel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        lblCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancel.setText("cancel");
        lblCancel.setOpaque(true);
        lblCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCancelMouseExited(evt);
            }
        });
        getContentPane().add(lblCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 150, 50));

        jLabel19.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("exam added");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 190, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("exam id");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 130, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("exam title");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 170, 60));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/lec1.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 305, 80, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/progress1.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 90, 70));

        lblProceed.setBackground(new java.awt.Color(153, 153, 153));
        lblProceed.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        lblProceed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProceed.setText("proceed");
        lblProceed.setOpaque(true);
        lblProceed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProceedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProceedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblProceedMouseExited(evt);
            }
        });
        getContentPane().add(lblProceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 150, 50));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("date");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 100, 50));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/logout1.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 90, 70));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/questions1.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 90, 70));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/student1.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 226, 80, 70));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/settings1.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 90, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("exam details");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 230, 140));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 710));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/Untitled-1.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 890, 3));

        txtExamTitle.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtExamTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExamTitleActionPerformed(evt);
            }
        });
        getContentPane().add(txtExamTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 210, 40));

        jCalendarCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2016-12-30" }));
        jCalendarCombo1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        getContentPane().add(jCalendarCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 210, 40));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/minimize.png"))); // NOI18N
        jLabel22.setToolTipText("Minimize");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 40, 50));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("X");
        jLabel23.setToolTipText("Exit");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 40, 50));

        txtExamID.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtExamID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExamIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtExamID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 210, 40));

        txtTime.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        getContentPane().add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 80, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel17.setText("minutes");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 110, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel18.setText("organize audiance");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel21.setText("hard");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 37, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel24.setText("medium");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 80, 50));

        jlbl.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jlbl.setText("easy");
        getContentPane().add(jlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, 60, 50));

        jLabel26.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel26.setText("organize paper");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        txtBatch.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        getContentPane().add(txtBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 190, 40));

        lblBatch.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblBatch.setText("batch");
        getContentPane().add(lblBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 80, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setOpaque(false);

        txtSubject.setEditable(true);
        txtSubject.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtSubject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OOP", "DBMS" }));
        txtSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(txtSubject, 0, 211, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 350, 380));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setOpaque(false);

        spHard.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        spEasy.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        spMedium.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        buttonGroup1.add(btnPublic);
        btnPublic.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnPublic.setText("public");
        btnPublic.setOpaque(false);
        btnPublic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnPrivate);
        btnPrivate.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnPrivate.setText("private");
        btnPrivate.setOpaque(false);
        btnPrivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrivateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPublic, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spHard, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(spMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(spEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnPrivate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spHard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPublic)
                    .addComponent(btnPrivate))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 470, 340));

        jPanel4.setOpaque(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 170, 150));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/background-xx.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setOpaque(true);
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/exam2.png")));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/exam1.png")));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/lec2.png")));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/lec1.png")));
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/progress2.png")));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/progress1.png")));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/questions2.png")));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/questions1.png")));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/student2.png")));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/student1.png")));
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/settings2.png")));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/settings1.png")));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/logout2.png")));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/logout1.png")));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        jLabel6.setVisible(true);
        jLabel7.setVisible(true);
        jLabel8.setVisible(true);
        jLabel9.setVisible(true);
        jLabel10.setVisible(true);
        jLabel4.setVisible(true);
        jPanel1.setVisible(true);
        jLabel12.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel4.setVisible(false);
        jPanel1.setVisible(false);
        jLabel12.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/home2.png")));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/home1.png")));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.dispose();
        new HomeAdminForm(lecturerDTO).setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void lblProceedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProceedMouseEntered
        lblProceed.setBackground(Color.BLACK);
        lblProceed.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblProceedMouseEntered

    private void lblProceedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProceedMouseExited
        lblProceed.setBackground(new Color(153, 153, 153));
        lblProceed.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblProceedMouseExited

    private void lblCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelMouseEntered
        lblCancel.setBackground(Color.BLACK);
        lblCancel.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblCancelMouseEntered

    private void lblCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelMouseExited
        lblCancel.setBackground(new Color(153, 153, 153));
        lblCancel.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblCancelMouseExited

    private void lblCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelMouseClicked
        this.dispose();
        new ExamDetailForm(lecturerDTO).setVisible(true);
    }//GEN-LAST:event_lblCancelMouseClicked

    private void lblProceedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProceedMouseClicked
        addExam();
    }//GEN-LAST:event_lblProceedMouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void btnPrivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrivateActionPerformed
        txtBatch.setVisible(true);
        lblBatch.setVisible(true);
    }//GEN-LAST:event_btnPrivateActionPerformed

    private void btnPublicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicActionPerformed
        txtBatch.setVisible(false);
        lblBatch.setVisible(false);
    }//GEN-LAST:event_btnPublicActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void txtExamIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExamIDActionPerformed
        txtExamTitle.requestFocus();
    }//GEN-LAST:event_txtExamIDActionPerformed

    private void txtExamTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExamTitleActionPerformed
        txtSubject.requestFocus();// TODO add your handling code here:
    }//GEN-LAST:event_txtExamTitleActionPerformed

    private void txtSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubjectActionPerformed
     
    }//GEN-LAST:event_txtSubjectActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExamDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
          
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnPrivate;
    private javax.swing.JRadioButton btnPublic;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.freixas.jcalendar.JCalendarCombo jCalendarCombo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlbl;
    private javax.swing.JLabel lblBatch;
    private javax.swing.JLabel lblCancel;
    private javax.swing.JLabel lblProceed;
    private javax.swing.JSpinner spEasy;
    private javax.swing.JSpinner spHard;
    private javax.swing.JSpinner spMedium;
    private javax.swing.JTextField txtBatch;
    private javax.swing.JTextField txtExamID;
    private javax.swing.JTextField txtExamTitle;
    private javax.swing.JComboBox txtSubject;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables

    private void addExam() {
        try {
            String examID = txtExamID.getText().toUpperCase();
            String examTitle = txtExamTitle.getText();
            String subject = (String) txtSubject.getSelectedItem();
            String time = txtTime.getText();
            String daet = (String) jCalendarCombo1.getSelectedItem();
            int hardQ = (int) spHard.getValue();
            int medium = (int) spMedium.getValue();
            int easy = (int) spEasy.getValue();
            String batch = "";
           // LecturerDTO dTO = new LecturerDTO("895678923v", "pradeep rangana", "java");
            if (btnPublic.isSelected()) {
                batch = "ALL";
            } else {
                batch = txtBatch.getText();
            }
            ExamDTO exam = new ExamDTO(examID, lecturerDTO, examTitle, subject.toUpperCase(), time, daet, hardQ, medium, easy, batch);
            ExamController examController = ServerConnector.getServerConnector().getExamController();
            boolean add = examController.addExam(exam);
            if (add) {
                JOptionPane.showMessageDialog(this, "exam added sucessfully");
                update(exam.getExamTitle() + " Added sucessfully");
            } else {
                JOptionPane.showMessageDialog(this, "Exam Added failed");
            }
        } catch (NotBoundException | ClassNotFoundException | ParseException ex) {
            Logger.getLogger(ExamDetailForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ExamDetailForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ExamDetailForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExamDetailForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setTime() {
        ClockLabel dateLable = new ClockLabel("date");
        ClockLabel timeLable = new ClockLabel("time");
        ClockLabel dayLable = new ClockLabel("day");

        jPanel4.setLayout(new FlowLayout());
        jPanel4.add(timeLable);
        jPanel4.add(dateLable);
        jPanel4.add(dayLable);
    }

    @Override
    public void update(String message) throws RemoteException {
        //homeStudentForm.setMessage(message);
    }

    private void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
