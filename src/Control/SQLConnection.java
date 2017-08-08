package Control;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Baptisvi on 08/08/2017.
 */
public class SQLConnection {

    public Statement openConnection(){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"SQL Error: " + e.getMessage(), "Driver Error", JOptionPane.INFORMATION_MESSAGE);
        }
        try{
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\baptisvi\\Documents\\Assets_and_Users_PBR.accdb","","");
            Statement statement = con.createStatement();
            return statement;

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"SQL Error: " + e.getMessage(), "Connection Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
}
