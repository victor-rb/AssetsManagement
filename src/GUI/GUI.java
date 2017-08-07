package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Baptisvi on 03/08/2017.
 */
public class GUI {


    public JFrame frame = new JFrame("Assets Manager");
    public JPanel backPane = new JPanel();
    public JTabbedPane tabbedPane = new JTabbedPane();
    public static JPanel userPane = new JPanel();
    public JPanel assetPane = new JPanel();
    public JPanel searchPane = new JPanel();
    public JButton exitBt = new JButton("Sair");

    public void guiCreator(){

        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }

        frame.setSize(680,850);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        backPane.setSize(680,850);
        backPane.setBackground(Color.lightGray);
        backPane.setBorder(BorderFactory.createLineBorder(Color.black,2));
        backPane.setLayout(null);

        tabbedPane.setSize(630,800);
        tabbedPane.setLocation(25,25);

        userPane.setSize(630, 800);
        userPane.setBorder(BorderFactory.createLineBorder(Color.black));
        userPane.setLayout(null);

        assetPane.setSize(630, 800);
        assetPane.setBorder(BorderFactory.createLineBorder(Color.black));

        exitBt.setBounds((680 /2) - 50,825, 100,20);
        exitBt.addActionListener(e -> System.exit(0));



        frame.add(tabbedPane);
        tabbedPane.add("                          User                        ",userPane);
        tabbedPane.add("                         Assets                       ", assetPane);
        tabbedPane.add("                         Search                       ", searchPane);
        backPane.add(exitBt);
        frame.add(backPane);


        UserPanel.userPaneGUI();

        frame.setVisible(true);
        tabbedPane.setVisible(true);

    }



}
