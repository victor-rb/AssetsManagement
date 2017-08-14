package Control;

import GUI.UserPanel;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Baptisvi on 08/08/2017.
 */
public class SQLQueryControl extends UserPanel {

    ResultSet resultSet = null;

    public void userTableCreate(Statement statement, DefaultTableModel model) throws SQLException{

        resultSet = statement.executeQuery("SELECT ADDS_USER, WORKING_COMPANY, FIRST_NAME, LAST_NAME FROM USER");

        model.setRowCount(0);

        while (resultSet.next()){
            String name = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME");
            String AD = resultSet.getString("ADDS_USER");
            String comp = resultSet.getString("WORKING_COMPANY");
            model.addRow(new String[] {name, AD,comp});
        }
    }

    public void userPaneFill(Statement statement ,JTextField FN, JTextField AD,JTextField LN, JTextField WC, JTextField Mail, JComboBox DEP, JTextField EMPID, JTextField JOB, JTextField MAN, JTextField TEL, JTextField MOB, JTextField LOC, JLabel DSP, String iten) throws SQLException {

        resultSet = statement.executeQuery("SELECT * FROM USER WHERE ADDS_USER = '" + iten + "'");

        while (resultSet.next()) {

            WC.setText(resultSet.getString(1));
            FN.setText(resultSet.getString(2));
            LN.setText(resultSet.getString(3));
            AD.setText(resultSet.getString(4));
            Mail.setText(resultSet.getString(5));
            DSP.setText(resultSet.getString(6));
            switch (resultSet.getString(7)){
                case "AFS" : DEP.setSelectedIndex(0);
                    break;
                case "EXE" : DEP.setSelectedIndex(1);
                    break;
                case "FIN" : DEP.setSelectedIndex(2);
                    break;
                case "IT" : DEP.setSelectedIndex(3);
                    break;
                case "LGC" : DEP.setSelectedIndex(4);
                    break;
                case "MKT" : DEP.setSelectedIndex(5);
                    break;
                case "PRP" : DEP.setSelectedIndex(6);
                    break;
                case "REC" : DEP.setSelectedIndex(7);
                    break;
                case "SLS" : DEP.setSelectedIndex(8);
                    break;
            }
            EMPID.setText(resultSet.getString(8));
            JOB.setText(resultSet.getString(9));
            MAN.setText(resultSet.getString(10));
            TEL.setText(resultSet.getString(11));
            MOB.setText(resultSet.getString(12));
            LOC.setText(resultSet.getString(13));
        }
    }

    public void userUpdate(Statement statement ,JTextField FN, JTextField AD,JTextField LN, JTextField WC, JCheckBox ckWC, JTextField Mail, JComboBox DEP, JTextField EMPID, JTextField JOB, JTextField MAN, JTextField TEL, JTextField MOB, JTextField LOC) throws SQLException {

        String workString;
        if (ckWC.isSelected()) {
            WC.setText("PBR");
            workString ="PBR," + DEP.getSelectedItem().toString();
        }else {
            workString ="PBR," + DEP.getSelectedItem().toString() + "_EXTERN";
        }

        statement.executeUpdate("UPDATE USER SET Working_Company = '" + WC.getText() +
                "',First_Name = '" + FN.getText() +
                "',Last_Name = '" + LN.getText() +
                "',ADDS_User = '" + AD.getText() +
                "',email = '" + Mail.getText() +
                "',displayName = '" + LN.getText() + "," + FN.getText() + " (" + workString + ")" +
                "',department = '" + DEP.getSelectedItem().toString() +
                "',employeeID = '" + EMPID.getText() +
                "',personalTitle = '" + JOB.getText() +
                "',manager = '" + MAN.getText() +
                "',telephoneNumber = '" + TEL.getText() +
                "',mobile = '" + MOB.getText() +
                "',Location = '" + LOC.getText() + "' WHERE ADDS_USER = '" + AD.getText() + "';");


    }

    public void newUser(Statement statement ,JTextField FN, JTextField AD,JTextField LN, JTextField WC, JCheckBox ckWC, JTextField Mail, JComboBox DEP, JTextField EMPID, JTextField JOB, JTextField MAN, JTextField TEL, JTextField MOB, JTextField LOC) throws SQLException {
        String workString;
        if (ckWC.isSelected()) {
            WC.setText("PBR");
            workString ="PBR," + DEP.getSelectedItem().toString();
        }else {
            workString ="PBR," + DEP.getSelectedItem().toString() + "_EXTERN";
        }

        statement.executeQuery("INSERT INTO USER (" +
                "Working_Company" +
                ",First_Name" +
                ",Last_Name" +
                ",ADDS_User" +
                ",email" +
                ",displayName" +
                ",department" +
                ",employeeID" +
                ",personalTitle" +
                ",manager" +
                ",telephoneNumber" +
                ",mobile" +
                ",Location" +
                ") VALUES(" +
                        WC +"," +
                        FN +"," +
                        LN +"," +
                        AD +"," +
                        Mail +"," +
                        workString +"," +
                        DEP +"," +
                        EMPID +"," +
                        JOB +"," +
                        MAN +"," +
                        TEL +"," +
                        MOB +"," +
                        LOC +")");
    }

}
