package GUI;

import javax.swing.*;

/**
 * Created by Baptisvi on 03/08/2017.
 */
public class GUI {

    JFrame frame = new JFrame("Assets Manager");
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel userPane = new JPanel();
    JPanel assetPane = new JPanel();

    public void guiCreator(){
        frame.setSize(1080,900);

        tabbedPane.setSize(1080,900);
        userPane.setSize(1080, 900);
        assetPane.setSize(1080, 900);

        frame.add(tabbedPane);
        tabbedPane.add("User",userPane);

        frame.setVisible(true);
        tabbedPane.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
