package alert;

import javax.swing.*;

/**
 * @author Roberto Vicario
 * @version 1.0
 */
public class Alert extends JOptionPane {
    public Alert(String msg) {
        showMessageDialog(null, msg, getClass().toString(), JOptionPane.ERROR_MESSAGE);
    }
}
