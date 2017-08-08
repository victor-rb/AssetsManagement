package Control;

import GUI.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Baptisvi on 08/08/2017.
 */
public class SQLQueryControl extends UserPanel {

    ResultSet resultSet = null;

    public void userTableCreate(Statement statement) throws SQLException{

        resultSet = statement.executeQuery("SELECT ADDS_USER, WORKING_COMPANY, FIRST_NAME, LAST_NAME FROM USER");

        while (resultSet.next()){
            String name = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME");
            String AD = resultSet.getString("ADDS_USER");
            String comp = resultSet.getString("WORKING_COMPANY");
            setTableModel(name, AD, comp);
        }

    }

}
