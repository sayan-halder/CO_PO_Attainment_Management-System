import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class PO_Calculation extends javax.swing.JFrame {
    MyConnection dbc=new MyConnection();
    Connection conn=dbc.connectme();
    ResultSet rs;
    PreparedStatement pstmt;
    //int po1=0,po2=0,po3=0,po4=0,po5=0,po6=0,po7=0,po8=0,po9=0,po10=0,po11=0,po12=0;
    float co1=0,co2=0,co3=0,co4=0,co5=0;

    public PO_Calculation() {
        super("PO RESULT");
        initComponents();
    }
    
    public void CO_Value()
    {
        try
        {
            pstmt=conn.prepareStatement("select * from CO_Final_Result where SUBJECT_CODE=? and CO=1");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                co1=rs.getFloat("OVERALL_ATTAINMENT");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            pstmt=conn.prepareStatement("select * from CO_Final_Result where SUBJECT_CODE=? and CO=2");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                co2=rs.getFloat("OVERALL_ATTAINMENT");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            pstmt=conn.prepareStatement("select * from CO_Final_Result where SUBJECT_CODE=? and CO=3");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                co3=rs.getFloat("OVERALL_ATTAINMENT");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            pstmt=conn.prepareStatement("select * from CO_Final_Result where SUBJECT_CODE=? and CO=4");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                co4=rs.getFloat("OVERALL_ATTAINMENT");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            pstmt=conn.prepareStatement("select * from CO_Final_Result where SUBJECT_CODE=? and CO=5");
            pstmt.setString(1, sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                co5=rs.getFloat("OVERALL_ATTAINMENT");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Subject code not found!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void PO_Value()
    {
        try
        {
            for(int i=1;i<=5;i++)
            {
                pstmt=conn.prepareStatement("update PO_DETAILS set COV=? where CO=?");
                if(i==1)
                    pstmt.setFloat(1,co1);
                if(i==2)
                    pstmt.setFloat(1,co2);
                if(i==3)
                    pstmt.setFloat(1,co3);
                if(i==4)
                    pstmt.setFloat(1,co4);
                if(i==5)
                    pstmt.setFloat(1,co5);
                pstmt.setInt(2,i);
                pstmt.execute();
                
                pstmt=conn.prepareStatement("update PO_DETAILS set\n" +
                                            "po1v=po1*cov/3, po2v=po2*cov/3,\n" +
                                            "po3v=po3*cov/3, po4v=po4*cov/3,\n" +
                                            "po5v=po5*cov/3, po6v=po6*cov/3,\n" +
                                            "po7v=po7*cov/3, po8v=po8*cov/3,\n" +
                                            "po9v=po9*cov/3, po10v=po10*cov/3,\n" +
                                            "po11v=po11*cov/3, po12v=po12*cov/3\n" +
                                            "where CO=?");
                pstmt.setInt(1,i);
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
            pstmt=conn.prepareStatement("select co,po1v,po2v,po3v,po4v,po5v,po6v,po7v,po8v,po9v,po10v,po11v,po12v\n" +
                                        "from PO_DETAILS where SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void sum()
    {
        try
        {
            String pos;
            pstmt=conn.prepareStatement("select sum(po1v) as PO1SUM, sum(po2v) as PO2SUM, sum(po3v) as PO3SUM,\n" +
                                        "sum(po4v) as PO4SUM, sum(po5v) as PO5SUM, sum(po6v) as PO6SUM,\n" +
                                        "sum(po7v) as PO7SUM, sum(po8v) as PO8SUM, sum(po9v) as PO9SUM,\n" +
                                        "sum(po10v) as PO10SUM, sum(po11v) as PO11SUM, sum(po12v) as PO12SUM\n" +
                                        "from PO_DETAILS where SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            
            if(rs.next())
            {
                pos=rs.getString("PO1SUM");
                po1v.setText(pos);
                
                pos=rs.getString("PO2SUM");
                po2v.setText(pos);
                
                pos=rs.getString("PO3SUM");
                po3v.setText(pos);
                
                pos=rs.getString("PO4SUM");
                po4v.setText(pos);
                
                pos=rs.getString("PO5SUM");
                po5v.setText(pos);
                
                pos=rs.getString("PO6SUM");
                po6v.setText(pos);
                
                pos=rs.getString("PO7SUM");
                po7v.setText(pos);
                
                pos=rs.getString("PO8SUM");
                po8v.setText(pos);
                
                pos=rs.getString("PO9SUM");
                po9v.setText(pos);
                
                pos=rs.getString("PO10SUM");
                po10v.setText(pos);
                
                pos=rs.getString("PO11SUM");
                po11v.setText(pos);
                
                pos=rs.getString("PO12SUM");
                po12v.setText(pos);
            } 
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void attainment()
    {
        try
        {
            float cnt = 0, pov;
            pstmt=conn.prepareStatement("select count(po1) as POCount from PO_DETAILS where po1 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                        pov = Float.parseFloat(po1v.getText());
                        po1a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po1a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po2) as POCount from PO_DETAILS where po2 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po2v.getText());
                    po2a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po2a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po3) as POCount from PO_DETAILS where po3 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po3v.getText());
                    po3a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po3a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po4) as POCount from PO_DETAILS where po4 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po4v.getText());
                    po4a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po4a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po5) as POCount from PO_DETAILS where po5 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po5v.getText());
                    po5a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po5a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po6) as POCount from PO_DETAILS where po6 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po6v.getText());
                    po6a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po6a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po7) as POCount from PO_DETAILS where po7 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po7v.getText());
                    po7a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po7a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po8) as POCount from PO_DETAILS where po8 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po8v.getText());
                    po8a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po8a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po9) as POCount from PO_DETAILS where po9 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po9v.getText());
                    po9a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po9a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po10) as POCount from PO_DETAILS where po10 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po10v.getText());
                    po10a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po10a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po11) as POCount from PO_DETAILS where po11 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po11v.getText());
                    po11a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po11a.setText("0");
            }
            
            pstmt=conn.prepareStatement("select count(po12) as POCount from PO_DETAILS where po12 > 0 and SUBJECT_CODE=?");
            pstmt.setString(1,sub_code.getText());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                cnt=rs.getFloat("POCount");
                if (cnt > 0)
                {
                    pov = Float.parseFloat(po12v.getText());
                    po12a.setText(Float.toString(Math.round(pov / cnt)));
                }
                else
                    po12a.setText("0");
            }
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnback2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sub_code = new javax.swing.JTextField();
        btnshowbook2 = new javax.swing.JButton();
        po1v = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        po2v = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        po3v = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        po4v = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        po5v = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        po6v = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        po7v = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        po8v = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        po9v = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        po10v = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        po11v = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        po12v = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        po1a = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        po2a = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        po3a = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        po4a = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        po5a = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        po6a = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        po7a = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        po8a = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        po9a = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        po10a = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        po11a = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        po12a = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true), "PO RESULT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CO", "PO1", "PO2", "PO3", "PO4", "PO5", "PO6", "PO7", "PO8", "PO9", "PO10", "PO11", "PO12"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        btnback2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnback2.setText("GO BACK");
        btnback2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnback2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SUBJECT CODE");

        sub_code.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        sub_code.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnshowbook2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnshowbook2.setText("SHOW");
        btnshowbook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowbook2ActionPerformed(evt);
            }
        });

        po1v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po1v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SUM OF ALL PO'S");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PO1");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PO2");

        po2v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po2v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PO3");

        po3v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po3v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("PO4");

        po4v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po4v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PO5");

        po5v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po5v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PO6");

        po6v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po6v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PO7");

        po7v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po7v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PO8");

        po8v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po8v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("PO9");

        po9v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po9v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PO10");

        po10v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po10v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("PO11");

        po11v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po11v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("PO12");

        po12v.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po12v.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ATTAINMENT OF ALL PO'S");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PO1");

        po1a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po1a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("PO2");

        po2a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po2a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("PO3");

        po3a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po3a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("PO4");

        po4a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po4a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("PO5");

        po5a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po5a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("PO6");

        po6a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po6a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("PO7");

        po7a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po7a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("PO8");

        po8a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po8a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("PO9");

        po9a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po9a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("PO10");

        po10a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po10a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("PO11");

        po11a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po11a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("PO12");

        po12a.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        po12a.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(396, 396, 396)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(po1v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(po2v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(po3v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(po4v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(po5v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(po6v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(sub_code, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnshowbook2)
                                .addGap(282, 282, 282))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(po7v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(po8v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(po9v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(po10v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(po11v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(po12v, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(po1a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(po2a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(po3a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel21)
                                        .addGap(18, 18, 18)
                                        .addComponent(po4a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(po5a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(po6a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(18, 18, 18)
                                        .addComponent(po7a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel25)
                                        .addGap(18, 18, 18)
                                        .addComponent(po8a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel26)
                                        .addGap(18, 18, 18)
                                        .addComponent(po9a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel27)
                                        .addGap(18, 18, 18)
                                        .addComponent(po10a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel28)
                                        .addGap(18, 18, 18)
                                        .addComponent(po11a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel29)
                                        .addGap(18, 18, 18)
                                        .addComponent(po12a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(403, 403, 403)
                                        .addComponent(btnback2)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sub_code, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnshowbook2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(po1v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(po2v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(po3v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(po4v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(po5v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(po6v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(po7v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(po8v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(po9v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(po10v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(po11v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(po12v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(po1a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(po2a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(po3a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(po4a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(po5a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(po6a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(po7a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(po8a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(po9a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(po10a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(po11a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(po12a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addComponent(btnback2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnback2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnback2ActionPerformed
        setVisible(false);
        Home_Page ob=new Home_Page();
        ob.setVisible(true);
    }//GEN-LAST:event_btnback2ActionPerformed

    private void btnshowbook2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowbook2ActionPerformed
        try
        {
            CO_Value();
            PO_Value();
            jTable1();
            sum();
            attainment();
        }
        catch(HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnshowbook2ActionPerformed

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
            java.util.logging.Logger.getLogger(PO_Calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PO_Calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PO_Calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PO_Calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PO_Calculation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback2;
    private javax.swing.JButton btnshowbook2;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField po10a;
    private javax.swing.JTextField po10v;
    private javax.swing.JTextField po11a;
    private javax.swing.JTextField po11v;
    private javax.swing.JTextField po12a;
    private javax.swing.JTextField po12v;
    private javax.swing.JTextField po1a;
    private javax.swing.JTextField po1v;
    private javax.swing.JTextField po2a;
    private javax.swing.JTextField po2v;
    private javax.swing.JTextField po3a;
    private javax.swing.JTextField po3v;
    private javax.swing.JTextField po4a;
    private javax.swing.JTextField po4v;
    private javax.swing.JTextField po5a;
    private javax.swing.JTextField po5v;
    private javax.swing.JTextField po6a;
    private javax.swing.JTextField po6v;
    private javax.swing.JTextField po7a;
    private javax.swing.JTextField po7v;
    private javax.swing.JTextField po8a;
    private javax.swing.JTextField po8v;
    private javax.swing.JTextField po9a;
    private javax.swing.JTextField po9v;
    private javax.swing.JTextField sub_code;
    // End of variables declaration//GEN-END:variables
}
