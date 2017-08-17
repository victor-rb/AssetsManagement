package GUI;

import Control.SQLQueryControl;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Baptisvi on 16/08/2017.
 */
public class AssetPanel {

    private Statement assetSt = new GUI().setMainST();

    private SQLQueryControl queryControl = new SQLQueryControl();


    private JLabel lbHeadLine = new JLabel("ASSET MANAGEMENT", SwingConstants.CENTER);
    private JLabel lbName = new JLabel("Equip. Name*:",SwingConstants.RIGHT);
    private JLabel lbUser = new JLabel("User*:",SwingConstants.RIGHT);
    private JLabel lbType = new JLabel("Type:",SwingConstants.RIGHT);
    private JLabel lbBrand = new JLabel("Brand:",SwingConstants.RIGHT);
    private JLabel lbModel = new JLabel("Model:",SwingConstants.RIGHT);
    private JLabel lbSerialNumber = new JLabel("Serial Number*:",SwingConstants.RIGHT);
    private JLabel lbSupplier = new JLabel("Supplier:",SwingConstants.RIGHT);

    private JTextField tfName = new JTextField();
    private JTextField tfUser = new JTextField();
    private JTextField tfBrand = new JTextField();
    private JTextField tfModel = new JTextField();
    private JTextField tfSerialNumber = new JTextField();
    private JTextField tfSupplier = new JTextField();

    private JCheckBox chRental = new JCheckBox("Rental?");

    private JComboBox<String> comType = new JComboBox<>(new String[] {"Notebook", "Desktop", "Display", "Dockstation", "Mobile", "Other"});

    private JList<Object> autoList = new JList<>();


    void assetPaneGUI(JPanel assetPane) throws SQLException {

        Object[] data= queryControl.setDataUser(assetSt).toArray();

        lbHeadLine.setBounds(0, 0, 300,50);
        lbHeadLine.setFont(new Font(null,Font.ITALIC,14));

        lbName.setBounds(30,80, 80,30);
        tfName.setBounds(130, 80 , 220, 30);

        lbUser.setBounds(330, 80, 80,30);
        tfUser.setBounds(420, 80, 100,30);
        tfUser.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                DefaultListModel<Object> model = new DefaultListModel<>();
                autoList.setVisible(true);
                assetPane.setComponentZOrder(autoList,2);
                System.out.println(autoList.getComponentZOrder(autoList));
                for (int i = 0; i < data.length; i++) {
                    if (data[i].toString().contains(tfUser.getText().toLowerCase())) {
                        model.addElement(data[i]);

                    }
                    autoList.setModel(model);
                    autoList.setFixedCellHeight(30);
                    if (autoList.getModel().getSize() < 10){
                        autoList.setSize(100, autoList.getFixedCellHeight() * autoList.getModel().getSize());
                    }
                }
            }
        });

        lbType.setBounds(30, 130, 80, 30);
        comType.setBounds(130, 130, 100,30);

        lbBrand.setBounds(210,130,80,30);
        tfBrand.setBounds(300,130,130,30);

        chRental.setBounds(450, 130, 80,30);

        lbSerialNumber.setBounds(30, 180, 80 ,30);
        tfSerialNumber.setBounds(130, 180, 180,30);

        lbSupplier.setBounds(300, 180, 80,30);
        tfSupplier.setBounds(390, 180, 180,30);

        lbModel.setBounds(30, 230, 80, 30);
        tfModel.setBounds(130, 230, 220,30);

        autoList.setBounds(420, 110, 100, 300);
        autoList.setBorder(BorderFactory.createLineBorder(Color.black));
        autoList.setVisible(false);
        autoList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tfUser.setText(autoList.getSelectedValue().toString());
                autoList.setVisible(false);
            }
            @Override
            public void mouseEntered(MouseEvent e){
                super.mouseEntered(e);
                autoList.requestFocus();
            }
        });




        assetPane.add(lbHeadLine);
        assetPane.add(lbName);
        assetPane.add(lbName);
        assetPane.add(tfName);
        assetPane.add(lbUser);
        assetPane.add(tfUser);
        assetPane.add(lbUser);
        assetPane.add(lbType);
        assetPane.add(comType);
        assetPane.add(lbBrand);
        assetPane.add(tfBrand);
        assetPane.add(chRental);
        assetPane.add(lbSerialNumber);
        assetPane.add(tfSerialNumber);
        assetPane.add(lbSupplier);
        assetPane.add(tfSupplier);
        assetPane.add(lbModel);
        assetPane.add(tfModel);
        assetPane.add(autoList);

        //assetPane.add();

    }

}
