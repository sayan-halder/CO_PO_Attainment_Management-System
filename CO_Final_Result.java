import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class CO_Final_Result extends javax.swing.JFrame {
    MyConnection dbc=new MyConnection();
    Connection conn=dbc.connectme();
    ResultSet rs;
    PreparedStatement pstmt;

    public CO_Final_Result() {
        super("CO FINAL RESULT");
        initComponents();
    }
            /*pstmt=conn.prepareStatement("select * from TheoryExt_Details where SUBJECT_CODE=?");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                m=rs.getInt("Marks");
                rs.close();
                pstmt.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            if(m >= 60)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_UNIVERSITY = 3 where co = 1");
                pstmt.execute();
            }
            else if(m >= 55)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_UNIVERSITY = 2 where co = 1");
                pstmt.execute();
            }
            else if(m >= 50)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_UNIVERSITY = 1 where co = 1");
                pstmt.execute();
            }
            else
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_UNIVERSITY = 0 where co = 1");
                pstmt.execute();
            }
            pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*ATTAINMENT_LVL_IA+0.6*ATTAINMENT_LVL_UNIVERSITY) where co = 1");
            pstmt.execute();*/
    
    public void Calculation1()
    {
        int perco=0;
        try
        {
            pstmt=conn.prepareStatement("select * from CO1_RESULT where SUBJECT_CODE=?");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                perco=rs.getInt("PERCENTAGE");
                rs.close();
                pstmt.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found1!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            if(perco >= 60)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 3 where CO = 1");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*3+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 1");
                pstmt.execute();
            }
            else if(perco >= 55)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 2 where CO = 1");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*2+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 1");
                pstmt.execute();
            }
            else if(perco >= 50)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 1 where CO = 1");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 1");
                pstmt.execute();
            }
            else
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 0 where CO = 1");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 1");
                pstmt.execute();
            }
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void Calculation2()
    {
        int perco=0;
        try
        {
            pstmt=conn.prepareStatement("select * from CO2_RESULT where SUBJECT_CODE=?");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                perco=rs.getInt("PERCENTAGE");
                rs.close();
                pstmt.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found2!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            if(perco >= 60)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 3 where CO = 2");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*3+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 2");
                pstmt.execute();
            }
            else if(perco >= 55)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 2 where CO = 2");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*2+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 2");
                pstmt.execute();
            }
            else if(perco >= 50)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 1 where CO = 2");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 2");
                pstmt.execute();
            }
            else
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 0 where CO = 2");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 2");
                pstmt.execute();
            }
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void Calculation3()
    {
        int perco=0;
        try
        {
            pstmt=conn.prepareStatement("select * from CO3_RESULT where SUBJECT_CODE=?");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                perco=rs.getInt("PERCENTAGE");
                rs.close();
                pstmt.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found3!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            if(perco >= 60)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 3 where CO = 3");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*3+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 3");
                pstmt.execute();
            }
            else if(perco >= 55)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 2 where CO = 3");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*2+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 3");
                pstmt.execute();
            }
            else if(perco >= 50)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 1 where CO = 3");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 3");
                pstmt.execute();
            }
            else
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 0 where CO = 3");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 3");
                pstmt.execute();
            }
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void Calculation4()
    {
        int perco=0;
        try
        { 
            pstmt=conn.prepareStatement("select * from CO4_RESULT where SUBJECT_CODE=?");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                perco=rs.getInt("PERCENTAGE");
                rs.close();
                pstmt.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found4!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            if(perco >= 60)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 3 where CO = 4");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*3+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 4");
                pstmt.execute();
            }
            else if(perco >= 55)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 2 where CO = 4");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*2+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 4");
                pstmt.execute();
            }
            else if(perco >= 50)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 1 where CO = 4");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 4");
                pstmt.execute();
            }
            else
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 0 where CO = 4");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 4");
                pstmt.execute();
            }
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void Calculation5()
    {
        int perco=0;
        try
        {
            pstmt=conn.prepareStatement("select * from CO5_RESULT where SUBJECT_CODE=?");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                perco=rs.getInt("PERCENTAGE");
                rs.close();
                pstmt.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found5!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            if(perco >= 60)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 3 where CO = 5");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*3+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 5");
                pstmt.execute();
            }
            else if(perco >= 55)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 2 where CO = 5");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4*2+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 5");
                pstmt.execute();
            }
            else if(perco >= 50)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 1 where CO = 5");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.4+0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 5");
                pstmt.execute();
            }
            else
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_IA = 0 where CO = 5");
                pstmt.execute();
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set OVERALL_ATTAINMENT = (0.6*ATTAINMENT_LVL_UNIVERSITY) where CO = 5");
                pstmt.execute();
            }
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void CalculationU()
    {
        int m=0;
        try
        {
            for(int i=1;i<=5;i++)
            {
                pstmt=conn.prepareStatement("insert into CO_FINAL_RESULT (SUBJECT_CODE,CO) values (?,?)");
                pstmt.setString(1, sub_code.getText());
                pstmt.setInt(2,i);
                pstmt.execute();
            }
            
            pstmt=conn.prepareStatement("select * from THEORY_EXTERNAL_RESULT where SUBJECT_CODE=?");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                m=rs.getInt("percentage");
                rs.close();
                pstmt.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            if(m >= 60)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_UNIVERSITY = 3");
                pstmt.execute();
            }
            else if(m >= 55)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_UNIVERSITY = 2");
                pstmt.execute();
            }
            else if(m >= 50)
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_UNIVERSITY = 1");
                pstmt.execute();
            }
            else
            {
                pstmt=conn.prepareStatement("update CO_FINAL_RESULT set ATTAINMENT_LVL_UNIVERSITY = 0");
                pstmt.execute();
            }
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void jTable1()
    {
        try
        {
            pstmt=conn.prepareStatement("update CO_FINAL_RESULT set CO_TARGET=?");
            pstmt.setString(1,"3");
            pstmt.executeUpdate();
            
            pstmt=conn.prepareStatement("select CO, CO_TARGET, ATTAINMENT_LVL_IA, ATTAINMENT_LVL_UNIVERSITY, OVERALL_ATTAINMENT\n" +
                                        "from CO_FINAL_RESULT where SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
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
        jLabel1 = new javax.swing.JLabel();
        sub_code = new javax.swing.JTextField();
        btnshowbook = new javax.swing.JButton();
        btnback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true), "CO RESULT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CO", "CO TARGET", "ATTAINMENT LVL-IA", "ATTAINMENT LVL-UNIVERSITY", "OVERALL ATTAINMENT"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

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

        btnback.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnback.setText("GO BACK");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(sub_code)
                        .addGap(18, 18, 18)
                        .addComponent(btnshowbook)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(415, 415, 415)
                .addComponent(btnback)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sub_code, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnshowbook))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnback)
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void btnshowbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowbookActionPerformed
        try
        {
            pstmt=conn.prepareStatement("delete from CO_FINAL_RESULT");
            pstmt.execute();
            
            CalculationU();
            Calculation1();
            Calculation2();
            Calculation3();
            Calculation4();
            Calculation5();
            jTable1();
        }
        catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnshowbookActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        setVisible(false);
        Home_Page ob=new Home_Page();
        ob.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

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
            java.util.logging.Logger.getLogger(CO_Final_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CO_Final_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CO_Final_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CO_Final_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CO_Final_Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnshowbook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField sub_code;
    // End of variables declaration//GEN-END:variables

}
