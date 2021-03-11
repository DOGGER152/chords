import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.*;
public class about {
    public about() {
        initComponents();
    }

    private void okBtnActionPerformed(ActionEvent e) {
        new chords();
        about.dispose();
    }

    private void textPrint(){
        FileReader file = null;
        try {
            file = new FileReader(new File("about.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner  sc = new Scanner(file);

        while (sc.hasNextLine()){
            aboutTextArea.append(sc.nextLine());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alex F
        about = new JWindow();
        scrollPane1 = new JScrollPane();
        aboutTextArea = new JTextArea();
        okBtn = new JButton();
        label9 = new JLabel();
        label8 = new JLabel();

        //======== about ========
        {
            Container aboutContentPane = about.getContentPane();

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(aboutTextArea);
            }

            //---- okBtn ----
            okBtn.setText("OK");
            okBtn.addActionListener(e -> okBtnActionPerformed(e));

            //---- label9 ----
            label9.setText("by Alex F");
            label9.setFont(new Font("Rage Italic", Font.PLAIN, 22));
            label9.setForeground(new Color(0, 102, 153));

            //---- label8 ----
            label8.setText("Thanks for using me!");
            label8.setFont(new Font("Showcard Gothic", Font.ITALIC, 16));
            label8.setForeground(Color.red);

            GroupLayout aboutContentPaneLayout = new GroupLayout(aboutContentPane);
            aboutContentPane.setLayout(aboutContentPaneLayout);
            aboutContentPaneLayout.setHorizontalGroup(
                aboutContentPaneLayout.createParallelGroup()
                    .addGroup(aboutContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(aboutContentPaneLayout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                            .addGroup(aboutContentPaneLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(label8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                .addComponent(okBtn)))
                        .addContainerGap())
            );
            aboutContentPaneLayout.setVerticalGroup(
                aboutContentPaneLayout.createParallelGroup()
                    .addGroup(aboutContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aboutContentPaneLayout.createParallelGroup()
                            .addGroup(aboutContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(okBtn)
                                .addComponent(label9))
                            .addComponent(label8))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            about.pack();
            about.setLocationRelativeTo(about.getOwner());
            about.setVisible(true);
            textPrint();
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alex F
    private JWindow about;
    private JScrollPane scrollPane1;
    private JTextArea aboutTextArea;
    private JButton okBtn;
    private JLabel label9;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
