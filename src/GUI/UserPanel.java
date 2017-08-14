package GUI;
import Control.SQLConnection;
import Control.SQLQueryControl;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Baptisvi on 07/08/2017.
 */
public class UserPanel {

    String item;

    String[] depList = {"AFS","EXE","FIN","IT","LGC","MKT","PRP","REC","SLS"};

    JLabel lbHeadLine = new JLabel("USER MANAGEMENT",SwingConstants.CENTER);
    JLabel lbFirstName = new JLabel("First Name:",SwingConstants.RIGHT);
    JLabel lbLastName = new JLabel("Last Name:",SwingConstants.RIGHT);
    JLabel lbADDS = new JLabel("ADDS:",SwingConstants.RIGHT);
    JLabel lbMail = new JLabel("Email:",SwingConstants.RIGHT);
    JLabel lbDepartment = new JLabel("Department:",SwingConstants.RIGHT);
    JLabel lbEmployeeID = new JLabel("Employee ID:",SwingConstants.RIGHT);
    JLabel lbJobRole = new JLabel("Function:",SwingConstants.RIGHT);
    JLabel lbManager = new JLabel("Manager:",SwingConstants.RIGHT);
    JLabel lbTelephone = new JLabel("Tel. Number:",SwingConstants.RIGHT);
    JLabel lbMobile = new JLabel("Moble:",SwingConstants.RIGHT);
    JLabel lbLocation = new JLabel("Location:",SwingConstants.RIGHT);
    JLabel lbDisplayName = new JLabel ("Display Name:", SwingConstants.RIGHT);
    JLabel lbDispRes = new JLabel("");

    JTextField tfFirstName = new JTextField();
    JTextField tfLastName = new JTextField();
    JTextField tfADDS = new JTextField();
    JTextField tfMail = new JTextField();
    JTextField tfEmployeeID = new JTextField();
    JTextField tfWorkingCompany = new JTextField();
    JTextField tfJobRole = new JTextField();
    JTextField tfManager = new JTextField();
    JTextField tfTelephone = new JTextField("+55(11)");
    JTextField tfMobile = new JTextField("+55(11)");
    JTextField tfLocation = new JTextField("SP");

    JComboBox<String> cmbDepartment = new JComboBox<>(depList);

    JCheckBox cbWorkCompany = new JCheckBox("PBR (Write the company below if different)",true);

    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };

    JTable table = new JTable(model);

    Statement userSt = new SQLConnection().openConnection();


    JScrollPane scTable = new JScrollPane(table);

    JButton btNewEntry = new JButton("New Entry");
    JButton btEdit = new JButton("Edit");
    JButton btCancel = new JButton("Cancel");
    JButton btUpdate = new JButton("Update");
    JButton btSave = new JButton("Save");

    void userPaneGUI(JPanel userPane) throws SQLException {




        lbHeadLine.setBounds(0, 0, 300,50);
        lbHeadLine.setFont(new Font(null,Font.ITALIC,14));

        lbFirstName.setBounds(10,50, 80,30);
        tfFirstName.setBounds(100, 50 , 220, 30);
        tfFirstName.setFocusable(false);


        lbADDS.setBounds(300, 50, 80,30);
        tfADDS.setBounds(390, 50, 220,30);
        tfADDS.setFocusable(false);


        lbLastName.setBounds(10, 100, 80,30);
        tfLastName.setBounds(100, 100, 220,30);
        tfLastName.setFocusable(false);

        lbDisplayName.setBounds(10, 150, 80, 30);
        lbDispRes.setBounds(100, 150, 220, 30);

        cbWorkCompany.setBounds(340,100,270,30);
        cbWorkCompany.setEnabled(false);
        cbWorkCompany.addChangeListener(e -> {
            if (cbWorkCompany.isSelected()) {
                tfWorkingCompany.setEnabled(false);
            }else{
                tfWorkingCompany.setEnabled(true);
            }
        });

        tfWorkingCompany.setBounds(390,130,215,30);
        tfWorkingCompany.setFocusable(false);

        lbMail.setBounds(10,200,80,30);
        tfMail.setBounds(100,200,220,30);
        tfMail.setFocusable(false);

        lbDepartment.setBounds(340,200,80,30);
        cmbDepartment.setBounds(430,200,80,30);
        cmbDepartment.setEnabled(false);

        lbEmployeeID.setBounds(10, 250, 80, 30);
        tfEmployeeID.setBounds(100, 250 , 100, 30);
        tfEmployeeID.setFocusable(false);

        lbJobRole.setBounds(180, 250, 80, 30);
        tfJobRole.setBounds(270, 250, 150, 30);
        tfJobRole.setFocusable(false);

        lbManager.setBounds(400, 250, 80, 30);
        tfManager.setBounds(490, 250, 120, 30);
        tfManager.setFocusable(false);

        lbTelephone.setBounds(10, 300, 80, 30);
        tfTelephone.setBounds(100, 300, 150, 30);
        tfTelephone.setFocusable(false);
        tfTelephone.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfTelephone.getText().equals("+55(11)"))tfTelephone.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfTelephone.getText().equals("")) tfTelephone.setText("+55(11)");
            }
        });

        lbMobile.setBounds(220, 300, 80 ,30);
        tfMobile.setBounds(310, 300, 150, 30);
        tfMobile.setFocusable(false);
        tfMobile.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfMobile.getText().equals("+55(11)"))tfMobile.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfMobile.getText().equals("")) tfMobile.setText("+55(11)");
            }
        });

        lbLocation.setBounds(460, 300, 80 ,30);
        tfLocation.setBounds(550, 300, 60, 30);
        tfLocation.setFocusable(false);

        SQLQueryControl querryControl = new SQLQueryControl();

        scTable.setBounds(10, 350, 605, 350);
        scTable.setBorder(BorderFactory.createLineBorder(Color.black));

        table.setBounds(10, 350, 605, 360);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                btEdit.setEnabled(true);
                int row = table.getSelectedRow();
                setItem(table.getModel().getValueAt(row, 1).toString());
                try {
                    querryControl.userPaneFill(userSt, tfFirstName, tfADDS, tfLastName, tfWorkingCompany, tfMail, cmbDepartment, tfEmployeeID, tfJobRole, tfManager, tfTelephone, tfMobile, tfLocation, lbDispRes, item);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if (tfWorkingCompany.getText().equals("PBR")){
                    tfWorkingCompany.setText("");
                    cbWorkCompany.setSelected(true);
                }else {
                    cbWorkCompany.setSelected(false);
                }
            }
        });

        model.addColumn("Name");
        model.addColumn("ADDS User");
        model.addColumn("Company");

        querryControl.userTableCreate(userSt, model);

        btNewEntry.setBounds(350, 730, 80 ,30);
        btNewEntry.addActionListener(e -> {
            clearForm();
            btEdit.setEnabled(false);
            table.setEnabled(false);
            table.setFocusable(false);
            table.setRowSelectionAllowed(false);
            btNewEntry.setVisible(false);
            btSave.setVisible(true);


        });

        btSave.setBounds(350, 730, 80 ,30);


        btEdit.setBounds(440, 730, 80 ,30);
        btEdit.setEnabled(false);
        btEdit.addActionListener(e -> {

            btEdit.setVisible(false);

            table.setEnabled(false);
            tfADDS.setFocusable(true);
            tfEmployeeID.setFocusable(true);
            tfFirstName.setFocusable(true);
            tfJobRole.setFocusable(true);
            tfLastName.setFocusable(true);
            tfLocation.setFocusable(true);
            tfMail.setFocusable(true);
            tfManager.setFocusable(true);
            tfMobile.setFocusable(true);
            tfTelephone.setFocusable(true);
            tfWorkingCompany.setFocusable(true);
            cbWorkCompany.setSelected(true);
            cbWorkCompany.setEnabled(true);
            cmbDepartment.setEnabled(true);
            table.setFocusable(true);
            btNewEntry.setEnabled(false);

            btUpdate.setVisible(true);

        });

        btUpdate.setBounds(440, 730, 80 ,30);
        btUpdate.setVisible(false);
        btUpdate.addActionListener(e -> {
            try {
                querryControl.userUpdate(userSt,tfFirstName,tfADDS,tfLastName,tfWorkingCompany,cbWorkCompany,tfMail,cmbDepartment,tfEmployeeID,tfJobRole,tfManager,tfTelephone,tfMobile,tfLocation);
                querryControl.userTableCreate(userSt,model);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            btUpdate.setVisible(false);
            btEdit.setVisible(true);
            btEdit.setEnabled(false);
            clearForm();
        });

        btCancel.setBounds(530, 730, 80 ,30);
        btCancel.addActionListener(e -> {
            clearForm();
            table.setEnabled(true);
        });


        userPane.add(lbHeadLine);
        userPane.add(lbFirstName);
        userPane.add(tfFirstName);
        userPane.add(lbADDS);
        userPane.add(tfADDS);
        userPane.add(lbLastName);
        userPane.add(lbDisplayName);
        userPane.add(lbDispRes);
        userPane.add(tfLastName);
        userPane.add(cbWorkCompany);
        userPane.add(tfWorkingCompany);
        userPane.add(lbMail);
        userPane.add(tfMail);
        userPane.add(lbDepartment);
        userPane.add(cmbDepartment);
        userPane.add(lbEmployeeID);
        userPane.add(tfEmployeeID);
        userPane.add(lbJobRole);
        userPane.add(tfJobRole);
        userPane.add(lbManager);
        userPane.add(tfManager);
        userPane.add(lbTelephone);
        userPane.add(tfTelephone);
        userPane.add(lbMobile);
        userPane.add(tfMobile);
        userPane.add(lbLocation);
        userPane.add(tfLocation);
        userPane.add(scTable);
        userPane.add(btNewEntry);
        userPane.add(btEdit);
        userPane.add(btUpdate);
        userPane.add(btCancel);
        userPane.add(btSave);

    }

    public void setItem(String position){
        item = position;
    }

    public void clearForm(){
        tfADDS.setText("");
        tfEmployeeID.setText("");
        tfFirstName.setText("");
        tfJobRole.setText("");
        tfLastName.setText("");
        tfLocation.setText("");
        tfMail.setText("");
        tfManager.setText("");
        tfMobile.setText("");
        tfTelephone.setText("");
        tfWorkingCompany.setText("");
        cmbDepartment.setSelectedItem(0);
        cbWorkCompany.setSelected(true);
    }


}
