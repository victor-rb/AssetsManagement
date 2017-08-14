import GUI.GUI;
import com.sun.javafx.runtime.SystemProperties;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Baptisvi on 03/08/2017.
 */
public class Main {

    public static void main(String[] args) throws SQLException{
       GUI gui = new GUI();
       gui.guiCreator();
    }

}
