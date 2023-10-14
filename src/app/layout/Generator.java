package app.layout;

import alert.Info;
import core.CoreGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Generator extends JPanel {
    private final JTextField jTextField1 = new JTextField("https://www.example.com");
    private final JButton jButton1 = new JButton("Check");
    private final JLabel jLabel2 = new JLabel("Status: Valid URL");
    private final JButton jButton2 = new JButton("Info");
    private final JComboBox<String> jComboBox1 = new JComboBox<>();
    private final JLabel jLabel4 = new JLabel("Width: 512, Height: 512");
    private final JLabel jLabel6 = new JLabel("Background: White");
    private final JCheckBox jCheckBox1 = new JCheckBox("White");
    private final JCheckBox jCheckBox2 = new JCheckBox("Black");
    private final JLabel jLabel7 = new JLabel("Color: Black");
    private final JCheckBox jCheckBox3 = new JCheckBox("Black");
    private final JCheckBox jCheckBox4 = new JCheckBox("White");
    private final JCheckBox jCheckBox5 = new JCheckBox("Custom");
    private final JButton jButton3 = new JButton("Download");
    private final JButton jButton4 = new JButton("Reset");
    CoreGenerator coreGenerator = new CoreGenerator();

    public Generator() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JToolBar jToolBar1 = new JToolBar();
        JLabel jLabel1 = new JLabel("URL:");
        Box.Filler filler1 = new Box.Filler(new Dimension(12, 0), new Dimension(12, 0), new Dimension(12, 32767));
        Box.Filler filler2 = new Box.Filler(new Dimension(12, 0), new Dimension(12, 0), new Dimension(12, 32767));
        JToolBar jToolBar2 = new JToolBar();
        Box.Filler filler3 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        JSeparator jSeparator1 = new JSeparator();
        JToolBar jToolBar3 = new JToolBar();
        JLabel jLabel3 = new JLabel("Resolution:");
        Box.Filler filler4 = new Box.Filler(new Dimension(12, 0), new Dimension(12, 0), new Dimension(12, 32767));
        Box.Filler filler5 = new Box.Filler(new Dimension(24, 0), new Dimension(24, 0), new Dimension(24, 32767));
        Box.Filler filler6 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        JToolBar jToolBar4 = new JToolBar();
        JLabel jLabel5 = new JLabel("Format:");
        Box.Filler filler7 = new Box.Filler(new Dimension(12, 0), new Dimension(12, 0), new Dimension(12, 32767));
        Box.Filler filler8 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        JToolBar jToolBar5 = new JToolBar();
        Box.Filler filler9 = new Box.Filler(new Dimension(24, 0), new Dimension(24, 0), new Dimension(24, 32767));
        Box.Filler filler10 = new Box.Filler(new Dimension(24, 0), new Dimension(24, 0), new Dimension(24, 32767));
        Box.Filler filler11 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        JToolBar jToolBar6 = new JToolBar();
        JComboBox<String> jComboBox2 = new JComboBox<>();
        Box.Filler filler12 = new Box.Filler(new Dimension(24, 0), new Dimension(24, 0), new Dimension(24, 32767));
        Box.Filler filler13 = new Box.Filler(new Dimension(24, 0), new Dimension(24, 0), new Dimension(24, 32767));
        Box.Filler filler15 = new Box.Filler(new Dimension(24, 0), new Dimension(24, 0), new Dimension(24, 32767));
        Box.Filler filler14 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        JSeparator jSeparator2 = new JSeparator();
        JToolBar jToolBar7 = new JToolBar();
        Box.Filler filler16 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));

        jToolBar1.setRollover(true);
        jToolBar1.add(jLabel1);
        jToolBar1.add(filler1);
        jToolBar1.add(jTextField1);
        jToolBar1.add(filler2);

        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jToolBar2.setRollover(true);
        jToolBar2.add(jLabel2);
        jToolBar2.add(filler3);

        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar2.add(jButton2);

        jToolBar3.setRollover(true);
        jToolBar3.add(jLabel3);
        jToolBar3.add(filler4);

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "LOW", "MID", "HIGH" }));
        jComboBox1.setSelectedIndex(1);
        jToolBar3.add(jComboBox1);
        jToolBar3.add(filler5);
        jToolBar3.add(jLabel4);
        jToolBar3.add(filler6);

        jToolBar4.setRollover(true);
        jToolBar4.add(jLabel5);
        jToolBar4.add(filler7);

        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "JPG", "PNG" }));
        jComboBox2.setSelectedIndex(1);
        jToolBar4.add(jComboBox2);
        jToolBar4.add(filler8);

        jToolBar5.setRollover(true);
        jToolBar5.add(jLabel6);
        jToolBar5.add(filler9);

        jCheckBox1.setSelected(true);
        jCheckBox1.setFocusable(false);
        jCheckBox1.setHorizontalTextPosition(SwingConstants.CENTER);
        jCheckBox1.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar5.add(jCheckBox1);
        jToolBar5.add(filler10);

        jCheckBox2.setFocusable(false);
        jCheckBox2.setHorizontalTextPosition(SwingConstants.CENTER);
        jCheckBox2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar5.add(jCheckBox2);
        jToolBar5.add(filler11);
        
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(jCheckBox1);
        buttonGroup1.add(jCheckBox2);

        jToolBar6.setRollover(true);
        jToolBar6.add(jLabel7);
        jToolBar6.add(filler12);

        jCheckBox3.setSelected(true);
        jCheckBox3.setFocusable(false);
        jCheckBox3.setHorizontalTextPosition(SwingConstants.CENTER);
        jCheckBox3.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar6.add(jCheckBox3);
        jToolBar6.add(filler13);

        jCheckBox4.setFocusable(false);
        jCheckBox4.setHorizontalTextPosition(SwingConstants.CENTER);
        jCheckBox4.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar6.add(jCheckBox4);
        jToolBar6.add(filler15);

        jCheckBox5.setFocusable(false);
        jCheckBox5.setHorizontalTextPosition(SwingConstants.CENTER);
        jCheckBox5.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar6.add(jCheckBox5);
        jToolBar6.add(filler14);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(jCheckBox3);
        buttonGroup2.add(jCheckBox3);
        buttonGroup2.add(jCheckBox4);

        jToolBar7.setRollover(true);

        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar7.add(jButton3);
        jToolBar7.add(filler16);

        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar7.add(jButton4);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jToolBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToolBar2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator1)
                                        .addComponent(jToolBar3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToolBar5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToolBar6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToolBar4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToolBar7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator2))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jToolBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jToolBar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToolBar3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jToolBar4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jToolBar5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jToolBar6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jToolBar7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    private void initEvents() {
        jButton1.addActionListener(e -> {
            String URL = jTextField1.getText();
            coreGenerator.checkURL(URL);
        });
        jTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String URL = jTextField1.getText();
                coreGenerator.setStatus(URL, jLabel2);
            }
        });
        jButton2.addActionListener(e -> new Info("""
                Please, make sure the URL follows the required format:
                
                - It should start with 'http', 'https', or 'ftp'.
                - Followed by '://'.
                - Domain name should contain only letters, numbers, dots, and hyphens.
                - The domain should end with a two to four-letter top-level domain (TLD).
                - Optional: a colon and port number can follow the domain.
                - Optional: a path can follow the domain, consisting of letters, numbers, underscores, hyphens, and slashes.
                """));
    }
}
