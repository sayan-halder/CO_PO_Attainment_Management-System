import java.sql.*;
import javax.swing.JOptionPane;
public class MyConnection {
    public Connection connectme()
    {
       try
       {
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           return DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\COPOAMS\\Database.accdb");
       }
       catch(ClassNotFoundException | SQLException e)
       {
            JOptionPane.showMessageDialog(null,e);
       }
       return null;
    }
}