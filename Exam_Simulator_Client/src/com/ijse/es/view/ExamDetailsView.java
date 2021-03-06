/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.view;

import com.ijse.es.dto.ExamDTO;
import com.ijse.es.dto.StudentDTO;
import java.awt.Color;

/**
 *
 * @author User
 */
public class ExamDetailsView extends javax.swing.JFrame {

    /**
     * Creates new form FinalMarksForm
     */
   private ExamDTO examDTO;
   private StudentDTO studentDTO;
    public ExamDetailsView(ExamDTO examDTO,StudentDTO studentDTO) {
        initComponents();
        this.examDTO=examDTO;
        this.studentDTO=studentDTO;
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0,102)); 
        set();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSubject = new javax.swing.JLabel();
        lblNumOfQ = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblLecturer = new javax.swing.JLabel();
        lblExamTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(232, 232, 232));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setText(" about exam");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 146, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel3.setText("subject");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 191, 278, 29));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel4.setText("number of question");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 266, 278, 29));

        lblSubject.setBackground(new java.awt.Color(0, 0, 0));
        lblSubject.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblSubject.setForeground(new java.awt.Color(51, 51, 51));
        lblSubject.setText("jLabel6");
        jPanel2.add(lblSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 260, 29));

        lblNumOfQ.setBackground(new java.awt.Color(0, 0, 0));
        lblNumOfQ.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblNumOfQ.setForeground(new java.awt.Color(51, 51, 51));
        lblNumOfQ.setText("jLabel6");
        jPanel2.add(lblNumOfQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 266, 260, 29));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel9.setText("      get");
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 311, 140, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel5.setText("time");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 231, 278, 29));

        lblTime.setBackground(new java.awt.Color(0, 0, 0));
        lblTime.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(51, 51, 51));
        lblTime.setText("jLabel6");
        jPanel2.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 231, 260, 29));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel11.setText("     cancel");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 311, 130, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel6.setText("lecturer");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 151, 278, 29));

        lblLecturer.setBackground(new java.awt.Color(0, 0, 0));
        lblLecturer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblLecturer.setForeground(new java.awt.Color(51, 51, 51));
        lblLecturer.setText("jLabel6");
        jPanel2.add(lblLecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 151, 260, 29));

        lblExamTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        jPanel2.add(lblExamTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 11, 460, 60));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/es/images/questions1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.dispose();
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        new ExamPaperForm(examDTO,studentDTO).setVisible(true);
        this.dispose();
      
        
       

    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(ExamDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblExamTitle;
    private javax.swing.JLabel lblLecturer;
    private javax.swing.JLabel lblNumOfQ;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables

    private void set() {
       // jPanel1.setBackground(new Color(0, 0, 0, 0));
        lblLecturer.setText(examDTO.getLecturerDTO().getName());
        lblSubject.setText(examDTO.getSubject());
        lblTime.setText(examDTO.getTime()+" min");
        lblNumOfQ.setText(examDTO.getEasyQ()+examDTO.getHardQ()+examDTO.getMediumQ()+"");
        lblExamTitle.setText(examDTO.getExamTitle());
      
    }
}
