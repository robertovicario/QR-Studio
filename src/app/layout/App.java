package app.layout;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme;

import javax.swing.*;
import java.awt.*;

/**
 * @author Roberto Vicario
 * @version 1.0
 */
public class App extends JFrame {
    public App() {
        try {
            UIManager.setLookAndFeel(new FlatLightOwlIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        initComponents();
    }

    private void initComponents() {
        JFrame jFrame = new JFrame();
        JTabbedPane jTabbedPane1 = new JTabbedPane();

        jTabbedPane1.addTab("Overview", new Overview());
        jTabbedPane1.addTab("Generator", new Generator());
        jTabbedPane1.setSelectedIndex(1);

        GroupLayout layout = new GroupLayout(jFrame.getContentPane());
        jFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
        );

        jFrame.setTitle("QR Studio");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setMinimumSize(new Dimension(700, 525));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
