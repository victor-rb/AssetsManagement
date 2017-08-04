package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Baptisvi on 03/08/2017.
 */
public class GUI {

    JFrame frame = new JFrame("Assets Manager");
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel userPane = new JPanel();
    JPanel assetPane = new JPanel();
    JPanel footerPane = new JPanel();
    JButton exitBt = new JButton("Sair");

    public void guiCreator(){
        frame.setSize(1080,900);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        tabbedPane.setSize(1080,850);

        userPane.setSize(1080, 850);
        userPane.setBorder(BorderFactory.createLineBorder(Color.black));
        userPane.setLayout(null);

        footerPane.setBounds(0,850,1080,50);
        footerPane.setLayout(null);

        assetPane.setSize(1080, 850);
        assetPane.setBorder(BorderFactory.createLineBorder(Color.black));

        exitBt.setBounds((1080 /2) - 50,860, 100,30);
        exitBt.addActionListener(e -> System.exit(0));

        frame.add(tabbedPane);
        frame.add(footerPane);
        tabbedPane.add("            User          ",userPane);
        tabbedPane.add("           Assets          ", assetPane);
        footerPane.add(exitBt);

        userPaneGUI();

        frame.setVisible(true);
        tabbedPane.setVisible(true);

    }

    void userPaneGUI(){

        Object[] depList = {"AFS","EXE","FIN","IT","LGC","MKT","PRP","REC","SLS"};

        JLabel lbFirstName = new JLabel("First Name:",SwingConstants.RIGHT);
        JLabel lbLastName = new JLabel("Last Name:",SwingConstants.RIGHT);
        JLabel lbADDS = new JLabel("ADDS:",SwingConstants.RIGHT);
        JLabel lbMail = new JLabel("Email:",SwingConstants.RIGHT);
        JTextField tfFirstName = new JTextField();
        JTextField tfLastName = new JTextField();
        JTextField tfADDS = new JTextField();
        JTextField tfMail = new JTextField();
        JTextField tfWorkingCompany = new JTextField();
        JComboBox cmbDepartment = new JComboBox();

        JCheckBox cbWorkCompany = new JCheckBox("PBR (Write the company below if different)",true);

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
        tfWorkingCompany.setBounds(390,130,220,30);
        tfWorkingCompany.setEnabled(false);

        lbMail.setBounds(10,200,80,30);
        tfMail.setBounds(100,200,220,30);

        cmbDepartment.setBounds(100,200,80,30);
        cmbDepartment.addItem("123");

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
        userPane.add(cmbDepartment);
    }

}
