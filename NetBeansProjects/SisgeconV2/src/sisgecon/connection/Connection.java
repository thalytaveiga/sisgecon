package sisgecon.connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Connection{
    public static java.sql.Connection getConnection() throws SQLException{
        try {
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","postgres");
             Class.forName("org.postgresql.Driver");                             
             return DriverManager.getConnection("jdbc:postgresql://localhost:5432/condominio", props);                         
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());            
            throw new SQLException();            
        }        
    } 

    public PreparedStatement prepareStatement(String select__from_usuario) throws SQLException {
        PreparedStatement stm = 
                getConnection().prepareStatement(select__from_usuario);
        return stm;
    }
}