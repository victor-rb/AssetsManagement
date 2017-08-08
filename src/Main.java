import GUI.GUI;
import com.sun.javafx.runtime.SystemProperties;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Baptisvi on 03/08/2017.
 */
public class Main {

    static GUI gui = new GUI();

    public static void main(String[] args) throws SQLException{
        gui.guiCreator();

    }

}
