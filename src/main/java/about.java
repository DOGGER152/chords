import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class about {
    public about() {
        initComponents();
    }

    private void okBtnActionPerformed(ActionEvent e) {
        mainFrame.dispose();
        new chords();
    }

    private void textPrint() {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set,Color.black);
        StyleConstants.setBackground(set,Color.black);
       // StyleConstants.setAlignment(set,StyleConstants.ALIGN_CENTER);
       // doc.setParagraphAttributes(0,doc.getLength(),set,false);
        String path = getClass().getResource("about.txt").getPath();
        File aboutFiletxt = new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(aboutFiletxt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
            try {
                System.out.println(sc.nextLine());
                doc.insertString(doc.getLength(),sc.nextLine(),null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
        sc.close();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alex F
        mainFrame = new JWindow();
        scrollPane1 = new JScrollPane();
        textPane = new JTextPane();
        okBtn = new JButton();
        label9 = new JLabel();

        //======== mainFrame ========
        {
            Container mainFrameContentPane = mainFrame.getContentPane();

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(textPane);
            }

            //---- okBtn ----
            okBtn.setText("OK");
            okBtn.addActionListener(e -> okBtnActionPerformed(e));

            //---- label9 ----
            label9.setText("by Alex F");
            label9.setFont(new Font("Rage Italic", Font.PLAIN, 22));
            label9.setForeground(new Color(0, 102, 153));

            GroupLayout mainFrameContentPaneLayout = new GroupLayout(mainFrameContentPane);
            mainFrameContentPane.setLayout(mainFrameContentPaneLayout);
            mainFrameContentPaneLayout.setHorizontalGroup(
                mainFrameContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, mainFrameContentPaneLayout.createSequentialGroup()
                        .addGroup(mainFrameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(mainFrameContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
                            .addGroup(mainFrameContentPaneLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                                .addComponent(okBtn)))
                        .addContainerGap())
            );
            mainFrameContentPaneLayout.setVerticalGroup(
                mainFrameContentPaneLayout.createParallelGroup()
                    .addGroup(mainFrameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainFrameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(okBtn)
                            .addComponent(label9))
                        .addContainerGap())
            );
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(mainFrame.getOwner());
            mainFrame.setVisible(true);
            textPrint();
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alex F
    private JWindow mainFrame;
    private JScrollPane scrollPane1;
    private JTextPane textPane;
    private JButton okBtn;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
