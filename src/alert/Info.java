package alert;

import javax.swing.*;

/**
 * @author Roberto Vicario
 * @version 1.0
 */
public class Info extends JOptionPane {
    public Info(String msg) {
        showMessageDialog(null, msg, getClass().toString(), JOptionPane.INFORMATION_MESSAGE);
    }
}
