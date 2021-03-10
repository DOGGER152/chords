
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.TabbedPaneUI;
import com.formdev.flatlaf.*;
import com.jgoodies.forms.factories.*;

public class chords extends JPanel{

    public chords(){initComponents();}

    private BufferedImage img() {

        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("fretboard2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
         return img;
    }

    private int Major;

    private void button8ActionPerformed (ActionEvent e) {
        Major=2;
        Graphics g = fretboard.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(133,32,11,11);
        g.fillOval(85,11,11,11);
        g.fillOval(85,60,11,11);
    }

    private void button16ActionPerformed (ActionEvent e) {
        Major=1;
        Graphics g = fretboard.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(43,32,11,11);
        g.fillOval(85,84,11,11);
        g.fillOval(131,109,11,11);
    }

    private void button10ActionPerformed (ActionEvent e){
        Major=3;
        Graphics g = fretboard.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(83,56,11,11);
        g.fillOval(132,84,11,11);
        g.fillOval(132,110,11,11);
    }

    private void button7ActionPerformed (ActionEvent e){
        Major=4;
        Graphics g = fretboard.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(133,84,11,11);
        g.fillOval(83,57,11,11);
        g.fillOval(42,10,11,11);
        g.fillOval(42,35,11,11);
    }

    private void button17ActionPerformed (ActionEvent e){
        Major=5;
        Graphics g = fretboard.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(133,9,11,11);
        g.fillOval(86,109,11,11);
        g.fillOval(133,136,11,11);
    }

    private void button19ActionPerformed (ActionEvent e){
        Major=6;
        Graphics g = fretboard.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(87,31,11,11);
        g.fillOval(86,56,11,11);
        g.fillOval(86,83,11,11);
    }

    private void button9ActionPerformed (ActionEvent e){
        Major=7;
        Graphics g = fretboard.getGraphics();
        g.setColor(Color.RED);
        g.drawLine(133,9,133,144);
        g.drawLine(134,9,134,144);
        g.drawLine(135,9,135,144);
        g.drawLine(136,9,136,144);
        g.fillOval(225,84,11,11);
        g.fillOval(225,109,11,11);
    }

    private void button11ActionPerformed(ActionEvent e) {
        fretboard.repaint();
    }

    /*private void label4MouseClicked(MouseEvent e) {
       int Mx=e.getX();
       int My=e.getY();
       String s = "X: "+Integer.toString(Mx)+" Y: "+Integer.toString(My);
       info.setText(s);
    }*/

    private void button5ActionPerformed(ActionEvent e) {
        Graphics g = fretboard.getGraphics();
        g.setColor(Color.RED);
        switch (Major) {
            case 0:
                    JOptionPane.showMessageDialog(chords,"Сначала выберите аккорд и нажмите \"Стереть\"","Внимание",JOptionPane.INFORMATION_MESSAGE);
                    break;
            case 1:
                    g.fillOval(42,32,11,11);
                    g.fillOval(42,82,11,11);
                    g.fillOval(132,110,11,11);
                    break;
            case 2:
                    g.fillOval(39,8,11,11);
                    g.fillOval(131,32,11,11);
                    g.fillOval(83,57,11,11);
                    break;
            case 3:
                    g.fillOval(132,84,11,11);
                    g.fillOval(132,110,11,11);
                    break;
            case 4:
                    g.drawLine(43,6,43,68);
                    g.drawLine(44,6,44,68);
                    g.drawLine(45,6,45,68);
                    g.drawLine(46,6,46,68);
                    g.fillOval(133,84,11,11);
                    break;
            case 5:
                    g.fillOval(135,137,11,11);
                    g.fillOval(42,109,11,11);
                    g.fillOval(39,8,11,11);
                    g.fillOval(39,32,11,11);
                    break;
            case 6:
                    g.fillOval(42,31,11,11);
                    g.fillOval(82,55,11,11);
                    g.fillOval(82,81,11,11);
                    break;
            case 7:
                    g.drawLine(84,5,84,120);
                    g.drawLine(85,5,85,120);
                    g.drawLine(86,5,86,120);
                    g.fillOval(131,32,11,11);
                    g.fillOval(175,56,11,11);
                    g.fillOval(175,83,11,11);
                    break;
        }
    }

    private void settingsBtn(ActionEvent e) {
        chords.dispose();
        new settings();
    }

    private void aboutActionPerformed(ActionEvent e) {
        chords.dispose();
        new about();
    }

    private void openVkPage(ActionEvent e) {
        URI uri = null;
        try {
            uri = new URI("https://vk.com/alex.flegontov");
        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception f) {
                f.printStackTrace();
            }
        }
    }

    private void sendEmail(ActionEvent e) {
        Desktop desktop = Desktop.getDesktop();
        if(desktop.isSupported(Desktop.Action.MAIL)&&desktop!=null){
            try {
                desktop.mail(new URI("mailto:flegontov007@yandex.ru?subject=Аккорды"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        }
        else JOptionPane.showMessageDialog(null,
                "На вашем компьютере не поддерживается данная функция",
                "Ошибка",
                JOptionPane.ERROR_MESSAGE);
    }

    private void label4MouseClicked(MouseEvent e) {
        // TODO add your code here
    }


    private void initComponents () {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alex F
        chords = new JFrame();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu2 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu3 = new JMenu();
        menuItem = new JMenu();
        vk = new JMenuItem();
        email = new JMenuItem();
        about = new JButton();
        toolBar1 = new JToolBar();
        saveBtn = new JButton();
        guitarBtn = new JButton();
        melodyBtn = new JButton();
        searchBtn = new JButton();
        referenceBtn = new JButton();
        settingsBtn = new JButton();
        chordF = new JButton();
        chordD = new JButton();
        chordB = new JButton();
        chordC = new JButton();
        chordG = new JButton();
        chordA = new JButton();
        info = new JLabel();
        chordE = new JButton();
        scrollPane1 = new JScrollPane();
        saveList = new JList();
        fretboard = new JLabel();
        major = new JButton();
        button11 = new JButton();
        label9 = new JLabel();

        //======== chords ========
        {
            chords.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            chords.setTitle("\u0410\u043a\u043a\u043e\u0440\u0434\u044b v.0.1");
            chords.setIconImage(new ImageIcon(getClass().getResource("/lp.png")).getImage());
            chords.setResizable(false);
            Container chordsContentPane = chords.getContentPane();

            //======== menuBar1 ========
            {

                //======== menu1 ========
                {
                    menu1.setText("\u041c\u0435\u043d\u044e");

                    //---- menuItem4 ----
                    menuItem4.setText("\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c");
                    menu1.add(menuItem4);

                    //---- menuItem7 ----
                    menuItem7.setText("\u0412\u0441\u0435 \u043c\u043e\u0438 \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f");
                    menu1.add(menuItem7);
                }
                menuBar1.add(menu1);

                //======== menu2 ========
                {
                    menu2.setText("\u041f\u0430\u0440\u0430\u043c\u0435\u0442\u0440\u044b");

                    //---- menuItem1 ----
                    menuItem1.setText("\u041f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u0438\u0437\u0430\u0446\u0438\u044f");
                    menu2.add(menuItem1);

                    //---- menuItem3 ----
                    menuItem3.setText("\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f");
                    menu2.add(menuItem3);

                    //---- menuItem2 ----
                    menuItem2.setText("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438");
                    menu2.add(menuItem2);
                }
                menuBar1.add(menu2);

                //======== menu3 ========
                {
                    menu3.setText("\u0420\u0430\u0437\u043d\u043e\u0435");

                    //======== menuItem ========
                    {
                        menuItem.setText("\u0421\u0432\u044f\u0437\u0430\u0442\u044c\u0441\u044f \u0441 \u0440\u0430\u0437\u0440\u0430\u0431\u043e\u0442\u0447\u0438\u043a\u043e\u043c");

                        //---- vk ----
                        vk.setText("\u0421\u0442\u0440\u0430\u043d\u0438\u0446\u0430 \u0412\u041a\u043e\u043d\u0442\u0430\u043a\u0442\u0435");
                        vk.addActionListener(e -> openVkPage(e));
                        menuItem.add(vk);

                        //---- email ----
                        email.setText("E-Mail");
                        email.addActionListener(e -> sendEmail(e));
                        menuItem.add(email);
                    }
                    menu3.add(menuItem);
                }
                menuBar1.add(menu3);

                //---- about ----
                about.setText("\u041e \u043f\u0440\u043e\u0433\u0440\u0430\u043c\u043c\u0435");
                about.addActionListener(e -> aboutActionPerformed(e));
                menuBar1.add(about);
            }
            chords.setJMenuBar(menuBar1);

            //======== toolBar1 ========
            {
                toolBar1.setFloatable(false);

                //---- saveBtn ----
                saveBtn.setIcon(new ImageIcon(getClass().getResource("/save_btn.png")));
                toolBar1.add(saveBtn);

                //---- guitarBtn ----
                guitarBtn.setIcon(new ImageIcon(getClass().getResource("/lp_btn.png")));
                toolBar1.add(guitarBtn);

                //---- melodyBtn ----
                melodyBtn.setIcon(new ImageIcon(getClass().getResource("/note_btn.png")));
                toolBar1.add(melodyBtn);

                //---- searchBtn ----
                searchBtn.setIcon(new ImageIcon(getClass().getResource("/search_btn.png")));
                toolBar1.add(searchBtn);

                //---- referenceBtn ----
                referenceBtn.setIcon(new ImageIcon(getClass().getResource("/gtkhelp_103392.png")));
                toolBar1.add(referenceBtn);

                //---- settingsBtn ----
                settingsBtn.setIcon(new ImageIcon(getClass().getResource("/settings.png")));
                settingsBtn.addActionListener(e -> settingsBtn(e));
                toolBar1.add(settingsBtn);
            }

            //---- chordF ----
            chordF.setText("F");
            chordF.addActionListener(e -> button7ActionPerformed(e));

            //---- chordD ----
            chordD.setText("D");
            chordD.addActionListener(e -> button8ActionPerformed(e));

            //---- chordB ----
            chordB.setText("B");
            chordB.addActionListener(e -> button9ActionPerformed(e));

            //---- chordC ----
            chordC.setText("C");
            chordC.addActionListener(e -> button16ActionPerformed(e));

            //---- chordG ----
            chordG.setText("G");
            chordG.addActionListener(e -> button17ActionPerformed(e));

            //---- chordA ----
            chordA.setText("A");
            chordA.addActionListener(e -> button19ActionPerformed(e));

            //---- info ----
            info.setForeground(Color.black);
            info.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
            info.setText("\u0414\u0430 \u0431\u0443\u0434\u0435\u0442 \u0434\u0436\u0435\u043d\u0442!");
            info.setFocusable(false);
            info.setRequestFocusEnabled(false);
            info.setHorizontalTextPosition(SwingConstants.CENTER);
            info.setHorizontalAlignment(SwingConstants.CENTER);

            //---- chordE ----
            chordE.setText("E");
            chordE.addActionListener(e -> button10ActionPerformed(e));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(saveList);
            }

            //---- fretboard ----
            fretboard.setIcon(new ImageIcon(getClass().getResource("/fretboard2.jpg")));
            fretboard.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label4MouseClicked(e);
                }
            });

            //---- major ----
            major.setText("Major");
            major.addActionListener(e -> button5ActionPerformed(e));

            //---- button11 ----
            button11.setText("\u0421\u0442\u0435\u0440\u0435\u0442\u044c");
            button11.addActionListener(e -> button11ActionPerformed(e));

            //---- label9 ----
            label9.setText("by Alex F");
            label9.setFont(new Font("Rage Italic", Font.PLAIN, 22));
            label9.setForeground(new Color(0, 102, 153));

            GroupLayout chordsContentPaneLayout = new GroupLayout(chordsContentPane);
            chordsContentPane.setLayout(chordsContentPaneLayout);
            chordsContentPaneLayout.setHorizontalGroup(
                chordsContentPaneLayout.createParallelGroup()
                    .addComponent(fretboard, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toolBar1, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                    .addGroup(chordsContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(chordsContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(chordA, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(chordG, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(chordF, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(chordE, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(chordD, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addComponent(chordB, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(chordC, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                        .addGroup(chordsContentPaneLayout.createParallelGroup()
                            .addGroup(chordsContentPaneLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(chordsContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(button11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(major, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, chordsContentPaneLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(info, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
            );
            chordsContentPaneLayout.setVerticalGroup(
                chordsContentPaneLayout.createParallelGroup()
                    .addGroup(chordsContentPaneLayout.createSequentialGroup()
                        .addComponent(toolBar1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fretboard, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(chordsContentPaneLayout.createParallelGroup()
                            .addGroup(chordsContentPaneLayout.createSequentialGroup()
                                .addGroup(chordsContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(chordC)
                                    .addComponent(major))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chordsContentPaneLayout.createParallelGroup()
                                    .addComponent(chordD)
                                    .addComponent(button11))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chordE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chordF)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chordG)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chordA)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chordsContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(chordB)
                                    .addComponent(label9))
                                .addGap(0, 8, Short.MAX_VALUE))
                            .addComponent(info, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addContainerGap())
            );
            chords.pack();
            chords.setLocationRelativeTo(chords.getOwner());
            chords.setVisible(true);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alex F
    private JFrame chords;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem4;
    private JMenuItem menuItem7;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem3;
    private JMenuItem menuItem2;
    private JMenu menu3;
    private JMenu menuItem;
    private JMenuItem vk;
    private JMenuItem email;
    private JButton about;
    private JToolBar toolBar1;
    private JButton saveBtn;
    private JButton guitarBtn;
    private JButton melodyBtn;
    private JButton searchBtn;
    private JButton referenceBtn;
    private JButton settingsBtn;
    private JButton chordF;
    private JButton chordD;
    private JButton chordB;
    private JButton chordC;
    private JButton chordG;
    private JButton chordA;
    private JLabel info;
    private JButton chordE;
    private JScrollPane scrollPane1;
    private JList saveList;
    private JLabel fretboard;
    private JButton major;
    private JButton button11;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main (String[]args){
        FlatLightLaf.install();
        UIManager.put("TabbedPane.showTabSeparators", true);
        UIManager.put("TextComponent.arc", 5);
        readFile readFile = new readFile();
        if (readFile.hasPath()) {
            readFile.setTheme();
            readFile.setFont();
        }
        new chords();

    }
}
