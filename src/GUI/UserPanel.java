package GUI;
import GUI.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Baptisvi on 07/08/2017.
 */
public class UserPanel extends GUI {



    static void userPaneGUI(){

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

        JTable table = new JTable();

        lbHeadLine.setBounds(0, 0, 300,50);
        lbHeadLine.setFont(new Font(null,Font.ITALIC,14));

        lbFirstName.setBounds(10,50, 80,30);
        tfFirstName.setBounds(100, 50 , 220, 30);

        lbADDS.setBounds(300, 50, 80,30);
        tfADDS.setBounds(390, 50, 220,30);


        lbLastName.setBounds(10, 100, 80,30);
        tfLastName.setBounds(100, 100, 220,30);

        cbWorkCompany.setBounds(340,100,270,30);
        cbWorkCompany.addChangeListener(e -> {
            if (cbWorkCompany.isSelected()) {
                tfWorkingCompany.setEnabled(false);
            }else{
                tfWorkingCompany.setEnabled(true);
            }
        });

        tfWorkingCompany.setBounds(390,130,215,30);
        tfWorkingCompany.setEnabled(false);

        lbMail.setBounds(10,200,80,30);
        tfMail.setBounds(100,200,220,30);

        lbDepartment.setBounds(340,200,80,30);
        cmbDepartment.setBounds(430,200,80,30);

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

        table.setBounds(10, 350, 605, 400);
        table.setBorder(BorderFactory.createLineBorder(Color.black));



        userPane.add(lbHeadLine);
        userPane.add(lbFirstName);
        userPane.add(tfFirstName);
        userPane.add(lbADDS);
        userPane.add(tfADDS);
        userPane.add(lbLastName);
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
        userPane.add(table);
    }
}
