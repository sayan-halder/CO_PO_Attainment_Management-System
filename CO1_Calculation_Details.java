import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class CO1_Calculation_Details extends javax.swing.JFrame {
    MyConnection dbc=new MyConnection();
    Connection conn=dbc.connectme();
    ResultSet rs;
    PreparedStatement pstmt;

    public CO1_Calculation_Details() {
        super("CO1 CALCULATION DETAILS");
        initComponents();
    }

    public void jTable1()
    {
        try
        {
            pstmt=conn.prepareStatement("delete from CO");
            pstmt.execute();

            pstmt=conn.prepareStatement("insert into CO (USN, SUBJECT_CODE, TCON, TM)\n" +
                                        "select stud.USN, sub.SUBJECT_CODE, count(t1.QUESTION), sum(t1.MARKS)\n" +
                                        "from SUBJECT as sub, STUDENT as stud, TEST1 as t1 \n" +
                                        "where	sub.SUBJECT_CODE = t1.SUBJECT_CODE and \n" +
                                        "   	stud.USN = t1.USN and \n" +
                                        "  	t1.CO = 1 and \n" +
                                        "  	t1.MARKS > -1 \n" +
                                        "group by stud.USN, sub.SUBJECT_CODE");
            pstmt.execute();

            pstmt=conn.prepareStatement("insert into CO (USN, SUBJECT_CODE, TCON, TM)\n" +
                                        "select stud.USN, sub.SUBJECT_CODE, count(t2.QUESTION), sum(t2.MARKS)\n" +
                                        "from SUBJECT as sub, STUDENT as stud, TEST2 as t2 \n" +
                                        "where	sub.SUBJECT_CODE = t2.SUBJECT_CODE and \n" +
                                        "   	stud.USN = t2.USN and \n" +
                                        "  	t2.CO = 1 and \n" +
                                        "  	t2.MARKS > -1 \n" +
                                        "group by stud.USN, sub.SUBJECT_CODE");
            pstmt.execute();

            pstmt=conn.prepareStatement("insert into CO (USN, SUBJECT_CODE, TCON, TM)\n" +
                                        "select stud.USN, sub.SUBJECT_CODE, count(t3.QUESTION), sum(t3.MARKS)\n" +
                                        "from SUBJECT as sub, STUDENT as stud, TEST3 as t3 \n" +
                                        "where	sub.SUBJECT_CODE = t3.SUBJECT_CODE and \n" +
                                        "   	stud.USN = t3.USN and \n" +
                                        "  	t3.CO = 1 and \n" +
                                        "  	t3.MARKS > -1 \n" +
                                        "group by stud.USN, sub.SUBJECT_CODE");
            pstmt.execute();

            pstmt=conn.prepareStatement("delete from CO1_CALCULATION");
            pstmt.execute();

            pstmt=conn.prepareStatement("insert into CO1_CALCULATION (USN, SUBJECT_CODE, QUESTION, TOTAL)\n" +
                                        "select USN, SUBJECT_CODE, sum(TCON)*8, sum(TM)*100\n" +
                                        "from CO\n" +
                                        "group by USN, SUBJECT_CODE");
            pstmt.execute();

            pstmt=conn.prepareStatement("update CO1_CALCULATION set PERCENTAGE = TOTAL / QUESTION");
            pstmt.execute();

            pstmt=conn.prepareStatement("update CO1_CALCULATION set TARGET = 'Y' where PERCENTAGE >= 70.0");
            pstmt.execute();

            pstmt=conn.prepareStatement("select USN, TOTAL/100 as [Total Marks], PERCENTAGE, TARGET\n" +
                                        "from CO1_CALCULATION where SUBJECT_CODE=?  order by USN");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public void jTable2()
    {
        try
        {
            pstmt=conn.prepareStatement("delete from CO1_RESULT");
            pstmt.execute();

            pstmt=conn.prepareStatement("insert into CO1_RESULT (SUBJECT_CODE) values (?)");
            pstmt.setString(1,sub_code.getText());
            pstmt.execute();

            pstmt=conn.prepareStatement("update CO1_RESULT set TOTAL_STUDENTS=\n" +
                                        "select count(USN) from STUDENT");
            pstmt.execute();

            pstmt=conn.prepareStatement("update CO1_RESULT set TOTAL_CO=\n" +
                                        "select count(USN)*100 from CO1_CALCULATION\n" +
                                        "where TARGET='Y' and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            pstmt.execute();

            pstmt=conn.prepareStatement("update CO1_RESULT set PERCENTAGE = TOTAL_CO / TOTAL_STUDENTS");
            pstmt.execute();

            pstmt=conn.prepareStatement("select TOTAL_STUDENTS, TOTAL_CO/100, PERCENTAGE\n" +
                                        "from CO1_RESULT where SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnback = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sub_code = new javax.swing.JTextField();
        btnshowbook = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true), "DETAILS OF CO1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "USN", "Total Marks", "Percentege", "Target"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnback.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnback.setText("GO BACK");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUBJECT CODE");

        sub_code.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        sub_code.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnshowbook.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnshowbook.setText("SHOW");
        btnshowbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowbookActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Total number of students", "Total number of students scored above 70%", "Percentage"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(sub_code, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnshowbook)
                        .addGap(282, 282, 282))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnback)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sub_code, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnshowbook))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnback))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        setVisible(false);
        Home_Page ob=new Home_Page();
        ob.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnshowbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowbookActionPerformed
        try
        {
            jTable1();
            jTable2();
        }
        catch(HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnshowbookActionPerformed

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
            java.util.logging.Logger.getLogger(CO1_Calculation_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CO1_Calculation_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CO1_Calculation_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CO1_Calculation_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CO1_Calculation_Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnshowbook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField sub_code;
    // End of variables declaration//GEN-END:variables

}
