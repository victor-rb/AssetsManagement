package GUI;
import Control.SQLConnection;
import Control.SQLQueryControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;


public class UserPanel {

    private String item;

    private String[] depList = {"AFS","EXE","FIN","IT","LGC","MKT","PRP","REC","SLS"};

    private JLabel lbHeadLine = new JLabel("USER MANAGEMENT",SwingConstants.CENTER);
    private JLabel lbFirstName = new JLabel("First Name:",SwingConstants.RIGHT);
    private JLabel lbLastName = new JLabel("Last Name:",SwingConstants.RIGHT);
    private JLabel lbADDS = new JLabel("ADDS:",SwingConstants.RIGHT);
    private JLabel lbMail = new JLabel("Email:",SwingConstants.RIGHT);
    private JLabel lbDepartment = new JLabel("Department:",SwingConstants.RIGHT);
    private JLabel lbEmployeeID = new JLabel("Employee ID:",SwingConstants.RIGHT);
    private JLabel lbJobRole = new JLabel("Function:",SwingConstants.RIGHT);
    private JLabel lbManager = new JLabel("Manager:",SwingConstants.RIGHT);
    private JLabel lbTelephone = new JLabel("Tel. Number:",SwingConstants.RIGHT);
    private JLabel lbMobile = new JLabel("Moble:",SwingConstants.RIGHT);
    private JLabel lbLocation = new JLabel("Location:",SwingConstants.RIGHT);
    private JLabel lbDisplayName = new JLabel ("Display Name:", SwingConstants.RIGHT);
    private JLabel lbDispRes = new JLabel("");

    private JTextField tfFirstName = new JTextField();
    private JTextField tfLastName = new JTextField();
    private JTextField tfADDS = new JTextField();
    private JTextField tfMail = new JTextField();
    private JTextField tfEmployeeID = new JTextField();
    private JTextField tfWorkingCompany = new JTextField();
    private JTextField tfJobRole = new JTextField();
    private JTextField tfManager = new JTextField();
    private JTextField tfTelephone = new JTextField();
    private JTextField tfMobile = new JTextField();
    private JTextField tfLocation = new JTextField();

    private JComboBox<String> cmbDepartment = new JComboBox<>(depList);

    private JCheckBox cbWorkCompany = new JCheckBox("PBR (Write the company below if different)",true);

    private DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }

    };

    private JTable table = new JTable(model);

    private Statement userSt = new SQLConnection().openConnection();


    private JScrollPane scTable = new JScrollPane(table);

    private JButton btNewEntry = new JButton("New Entry");
    private JButton btEdit = new JButton("Edit");
    private JButton btCancel = new JButton("Cancel");
    private JButton btUpdate = new JButton("Update");
    private JButton btSave = new JButton("Save");
    private JButton btDelete = new JButton("Delete");

    void userPaneGUI(JPanel userPane) throws SQLException {




        lbHeadLine.setBounds(0, 0, 300,50);
        lbHeadLine.setFont(new Font(null,Font.ITALIC,14));

        lbFirstName.setBounds(10,50, 80,30);
        tfFirstName.setBounds(100, 50 , 220, 30);



        lbADDS.setBounds(300, 50, 80,30);
        tfADDS.setBounds(390, 50, 220,30);



        lbLastName.setBounds(10, 100, 80,30);
        tfLastName.setBounds(100, 100, 220,30);


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


        lbMail.setBounds(10,200,80,30);
        tfMail.setBounds(100,200,220,30);


        lbDepartment.setBounds(340,200,80,30);
        cmbDepartment.setBounds(430,200,80,30);
        cmbDepartment.setEnabled(false);

        lbEmployeeID.setBounds(10, 250, 80, 30);
        tfEmployeeID.setBounds(100, 250 , 100, 30);


        lbJobRole.setBounds(180, 250, 80, 30);
        tfJobRole.setBounds(270, 250, 150, 30);


        lbManager.setBounds(400, 250, 80, 30);
        tfManager.setBounds(490, 250, 120, 30);


        lbTelephone.setBounds(10, 300, 80, 30);
        tfTelephone.setBounds(100, 300, 150, 30);

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
            btEdit.setEnabled(false);
            btNewEntry.setVisible(false);
            btSave.setVisible(true);
            table.removeEditor();
            clearForm();
            setFocus();
        });

        btSave.setBounds(350, 730, 80 ,30);
        btSave.setVisible(false);
        btSave.addActionListener(e -> {
            if (cbWorkCompany.isSelected()) tfWorkingCompany.setText("PBR");
            if (tfFirstName.getText().equals("") ||
                    tfADDS.getText().equals("") ||
                    tfLastName.getText().equals("") ||
                    tfEmployeeID.getText().equals("") ||
                    tfJobRole.getText().equals("") ||
                    tfLocation.getText().equals("") ||
                    tfMail.getText().equals("") ||
                    tfManager.getText().equals("") ||
                    tfTelephone.getText().equals("") ||
                    tfWorkingCompany.getText().equals("")){
                JOptionPane.showMessageDialog(null,"All the fields marked (*) are necessary","Fill Error Message",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                querryControl.newUser(userSt,tfFirstName,tfADDS,tfLastName,tfWorkingCompany,cbWorkCompany,tfMail,cmbDepartment,tfEmployeeID,tfJobRole,tfManager,tfTelephone,tfMobile,tfLocation);
                querryControl.userTableCreate(userSt,model);
                JOptionPane.showMessageDialog(null, "User Creation Succeed");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            clearForm();
            lostFocus();
            btSave.setVisible(false);
            btNewEntry.setVisible(true);
            btNewEntry.setEnabled(true);
            btEdit.setVisible(true);
            table.setEnabled(true);

        });


        btEdit.setBounds(440, 730, 80 ,30);
        btEdit.setEnabled(false);
        btEdit.addActionListener(e -> {

            btEdit.setVisible(false);
            btNewEntry.setVisible(false);
            table.removeEditor();

            setFocus();

            btUpdate.setVisible(true);
            btDelete.setVisible(true);

        });

        btUpdate.setBounds(440, 730, 80 ,30);
        btUpdate.setVisible(false);
        btUpdate.addActionListener(e -> {
            try {
                querryControl.userUpdate(userSt,tfFirstName,tfADDS,tfLastName,tfWorkingCompany,cbWorkCompany,tfMail,cmbDepartment,tfEmployeeID,tfJobRole,tfManager,tfTelephone,tfMobile,tfLocation);
                querryControl.userTableCreate(userSt,model);
                updatePane();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            clearForm();
            lostFocus();
            btDelete.setVisible(false);
            btUpdate.setVisible(false);
            btNewEntry.setVisible(true);
            btNewEntry.setEnabled(true);
            btEdit.setVisible(true);
            btEdit.setEnabled(false);
            table.setEnabled(true);
        });

        btCancel.setBounds(530, 730, 80 ,30);
        btCancel.addActionListener(e -> {
            clearForm();
            lostFocus();
            btSave.setVisible(false);
            btEdit.setVisible(true);
            btEdit.setEnabled(false);
            btUpdate.setVisible(false);
            btNewEntry.setVisible(true);
            btNewEntry.setEnabled(true);
            table.setEnabled(true);
        });

        btDelete.setBounds(350, 730, 80 ,30);
        btDelete.setBorder(BorderFactory.createLineBorder(Color.red));
        btDelete.setVisible(false);
        btDelete.addActionListener(e -> {
            int resp = JOptionPane.showConfirmDialog(null, "Proced with user Deletion\n" + tfADDS.getText(), "Deletion Confirm", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION){
                try {
                    querryControl.deleteEntry(userSt, tfADDS);
                    querryControl.userTableCreate(userSt,model);
                    JOptionPane.showMessageDialog(null, "User Deleted");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            btDelete.setVisible(false);
            btUpdate.setVisible(false);
            btEdit.setVisible(true);
            btNewEntry.setVisible(true);
            btNewEntry.setEnabled(true);
            clearForm();
            lostFocus();
            table.setEnabled(true);
        });


        lostFocus();


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
        userPane.add(btDelete);

    }

    private void setItem(String position){
        item = position;
    }

    private void clearForm(){
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

    private void setFocus(){
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
        cbWorkCompany.setEnabled(true);
        cmbDepartment.setEnabled(true);
        table.setFocusable(true);
        btNewEntry.setEnabled(false);
    }

    private void lostFocus(){
        tfFirstName.setFocusable(false);
        tfADDS.setFocusable(false);
        tfLastName.setFocusable(false);
        tfWorkingCompany.setFocusable(false);
        tfMail.setFocusable(false);
        tfEmployeeID.setFocusable(false);
        tfJobRole.setFocusable(false);
        tfManager.setFocusable(false);
        tfTelephone.setFocusable(false);
        tfMobile.setFocusable(false);
        tfLocation.setFocusable(false);
    }

    private void updatePane(){
        String update = "User Update to:\n" +
                tfFirstName.getText() + " " + tfLastName.getText() +"\n" +
                tfADDS.getText() +"\n" +
                tfWorkingCompany.getText() +"\n" +
                tfMail.getText() +"\n" +
                tfEmployeeID.getText() +"\n" +
                tfJobRole.getText() +"\n" +
                tfManager.getText() +"\n" +
                tfTelephone.getText() +"\n" +
                tfMobile.getText() +"\n" +
                tfLocation.getText();
        JOptionPane.showMessageDialog(null,update,"Update to",JOptionPane.INFORMATION_MESSAGE);
    }

}
