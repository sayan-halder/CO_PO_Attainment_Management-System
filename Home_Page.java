public class Home_Page extends javax.swing.JFrame {

    public Home_Page() {
        super("HOME PAGE");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnaddstudent = new javax.swing.JButton();
        btnaddsubject = new javax.swing.JButton();
        co1calc = new javax.swing.JButton();
        co2calc = new javax.swing.JButton();
        co3calc = new javax.swing.JButton();
        co4calc = new javax.swing.JButton();
        co5calc = new javax.swing.JButton();
        test1det = new javax.swing.JButton();
        test2det = new javax.swing.JButton();
        test3det = new javax.swing.JButton();
        coresult = new javax.swing.JButton();
        podetails = new javax.swing.JButton();
        pocalc = new javax.swing.JButton();
        test3det1 = new javax.swing.JButton();
        test3det2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        filemenu = new javax.swing.JMenu();
        logoutmenuitem = new javax.swing.JMenuItem();
        exitmenuitem = new javax.swing.JMenuItem();
        viewmenu = new javax.swing.JMenu();
        regstudmenuitem = new javax.swing.JMenuItem();
        regsubmenuitem = new javax.swing.JMenuItem();
        aboutmenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnaddstudent.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnaddstudent.setText("ADD NEW STUDENT");
        btnaddstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddstudentActionPerformed(evt);
            }
        });

        btnaddsubject.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnaddsubject.setText("ADD NEW SUBJECT");
        btnaddsubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddsubjectActionPerformed(evt);
            }
        });

        co1calc.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        co1calc.setText("CO1 CALCULATION");
        co1calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co1calcActionPerformed(evt);
            }
        });

        co2calc.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        co2calc.setText("CO2 CALCULATION");
        co2calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co2calcActionPerformed(evt);
            }
        });

        co3calc.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        co3calc.setText("CO3 CALCULATION");
        co3calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co3calcActionPerformed(evt);
            }
        });

        co4calc.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        co4calc.setText("CO4 CALCULATION");
        co4calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co4calcActionPerformed(evt);
            }
        });

        co5calc.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        co5calc.setText("CO5 CALCULATION");
        co5calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co5calcActionPerformed(evt);
            }
        });

        test1det.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        test1det.setText("ADD TEST 1 DETAILS");
        test1det.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test1detActionPerformed(evt);
            }
        });

        test2det.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        test2det.setText("ADD TEST 2 DETAILS");
        test2det.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test2detActionPerformed(evt);
            }
        });

        test3det.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        test3det.setText("ADD TEST 3 DETAILS");
        test3det.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test3detActionPerformed(evt);
            }
        });

        coresult.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        coresult.setText("CO FINAL RESULT");
        coresult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coresultActionPerformed(evt);
            }
        });

        podetails.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        podetails.setText("ADD PO DETAILS");
        podetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                podetailsActionPerformed(evt);
            }
        });

        pocalc.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        pocalc.setText("PO CALCULATION");
        pocalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pocalcActionPerformed(evt);
            }
        });

        test3det1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        test3det1.setText("ADD THEORY EXTERNAL DETAILS");
        test3det1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test3det1ActionPerformed(evt);
            }
        });

        test3det2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        test3det2.setText("THEORY EXTERNAL RESULT");
        test3det2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test3det2ActionPerformed(evt);
            }
        });

        filemenu.setText("FILE");

        logoutmenuitem.setText("LOGOUT");
        logoutmenuitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutmenuitemActionPerformed(evt);
            }
        });
        filemenu.add(logoutmenuitem);

        exitmenuitem.setText("EXIT");
        exitmenuitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitmenuitemActionPerformed(evt);
            }
        });
        filemenu.add(exitmenuitem);

        jMenuBar1.add(filemenu);

        viewmenu.setText("VIEW");

        regstudmenuitem.setText("REGESTERED STUDENTS");
        regstudmenuitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regstudmenuitemActionPerformed(evt);
            }
        });
        viewmenu.add(regstudmenuitem);

        regsubmenuitem.setText("REGESTERED SUBJECTS");
        regsubmenuitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regsubmenuitemActionPerformed(evt);
            }
        });
        viewmenu.add(regsubmenuitem);

        jMenuBar1.add(viewmenu);

        aboutmenu.setText("ABOUT");
        aboutmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutmenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(aboutmenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(co1calc, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(co2calc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(co3calc, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnaddstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnaddsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(test3det1)
                                .addGap(204, 204, 204))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(co4calc)
                                        .addGap(18, 18, 18)
                                        .addComponent(co5calc, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(podetails, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pocalc, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(coresult)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(test1det)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(test2det)
                        .addGap(18, 18, 18)
                        .addComponent(test3det))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(test3det2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaddstudent)
                    .addComponent(btnaddsubject))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(test1det)
                    .addComponent(test2det)
                    .addComponent(test3det))
                .addGap(18, 18, 18)
                .addComponent(test3det1)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(co1calc)
                    .addComponent(co2calc)
                    .addComponent(co3calc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(co4calc)
                    .addComponent(co5calc))
                .addGap(18, 18, 18)
                .addComponent(coresult)
                .addGap(18, 18, 18)
                .addComponent(test3det2)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(podetails)
                    .addComponent(pocalc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddstudentActionPerformed
        setVisible(false);
        Student_Details ob = new Student_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_btnaddstudentActionPerformed

    private void btnaddsubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddsubjectActionPerformed
        setVisible(false);
        Subject_Details ob=new Subject_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_btnaddsubjectActionPerformed

    private void logoutmenuitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutmenuitemActionPerformed
        setVisible(false);
        Login_Menu ob=new Login_Menu();
        ob.setVisible(true);
    }//GEN-LAST:event_logoutmenuitemActionPerformed

    private void exitmenuitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitmenuitemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitmenuitemActionPerformed

    private void aboutmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutmenuMouseClicked
        setVisible(false);
        About ob=new About();
        ob.setVisible(true);
    }//GEN-LAST:event_aboutmenuMouseClicked

    private void co2calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_co2calcActionPerformed
        setVisible(false);
        CO2_Calculation_Details ob = new CO2_Calculation_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_co2calcActionPerformed

    private void co1calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_co1calcActionPerformed
        setVisible(false);
        CO1_Calculation_Details ob = new CO1_Calculation_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_co1calcActionPerformed

    private void co3calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_co3calcActionPerformed
        setVisible(false);
        CO3_Calculation_Details ob = new CO3_Calculation_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_co3calcActionPerformed

    private void co4calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_co4calcActionPerformed
        setVisible(false);
        CO4_Calculation_Details ob = new CO4_Calculation_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_co4calcActionPerformed

    private void co5calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_co5calcActionPerformed
        setVisible(false);
        CO5_Calculation_Details ob = new CO5_Calculation_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_co5calcActionPerformed

    private void test1detActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test1detActionPerformed
        setVisible(false);
        Test1_Details ob = new Test1_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_test1detActionPerformed

    private void test2detActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test2detActionPerformed
        setVisible(false);
        Test2_Details ob = new Test2_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_test2detActionPerformed

    private void test3detActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test3detActionPerformed
        setVisible(false);
        Test3_Details ob = new Test3_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_test3detActionPerformed

    private void coresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coresultActionPerformed
        setVisible(false);
        CO_Final_Result ob = new CO_Final_Result();
        ob.setVisible(true);
    }//GEN-LAST:event_coresultActionPerformed

    private void podetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_podetailsActionPerformed
        setVisible(false);
        PO_Details ob = new PO_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_podetailsActionPerformed

    private void pocalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pocalcActionPerformed
        setVisible(false);
        PO_Calculation ob = new PO_Calculation();
        ob.setVisible(true);
    }//GEN-LAST:event_pocalcActionPerformed

    private void test3det1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test3det1ActionPerformed
        setVisible(false);
        TheoryExt_Details ob = new TheoryExt_Details();
        ob.setVisible(true);
    }//GEN-LAST:event_test3det1ActionPerformed

    private void test3det2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test3det2ActionPerformed
        setVisible(false);
        TheoryExt_Result ob = new TheoryExt_Result();
        ob.setVisible(true);
    }//GEN-LAST:event_test3det2ActionPerformed

    private void regstudmenuitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regstudmenuitemActionPerformed
        setVisible(false);
        Show_Students ob=new Show_Students();
        ob.setVisible(true);
    }//GEN-LAST:event_regstudmenuitemActionPerformed

    private void regsubmenuitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regsubmenuitemActionPerformed
        setVisible(false);
        Show_Subjects ob=new Show_Subjects();
        ob.setVisible(true);
    }//GEN-LAST:event_regsubmenuitemActionPerformed

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
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutmenu;
    private javax.swing.JButton btnaddstudent;
    private javax.swing.JButton btnaddsubject;
    private javax.swing.JButton co1calc;
    private javax.swing.JButton co2calc;
    private javax.swing.JButton co3calc;
    private javax.swing.JButton co4calc;
    private javax.swing.JButton co5calc;
    private javax.swing.JButton coresult;
    private javax.swing.JMenuItem exitmenuitem;
    private javax.swing.JMenu filemenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem logoutmenuitem;
    private javax.swing.JButton pocalc;
    private javax.swing.JButton podetails;
    private javax.swing.JMenuItem regstudmenuitem;
    private javax.swing.JMenuItem regsubmenuitem;
    private javax.swing.JButton test1det;
    private javax.swing.JButton test2det;
    private javax.swing.JButton test3det;
    private javax.swing.JButton test3det1;
    private javax.swing.JButton test3det2;
    private javax.swing.JMenu viewmenu;
    // End of variables declaration//GEN-END:variables
}
