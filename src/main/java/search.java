import java.awt.*;
import javax.swing.*;
public class search {
    public search() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alex F
        search = new JWindow();
        textField = new JTextField();
        label1 = new JLabel();
        searchBtn = new JButton();
        cancelBtn = new JButton();

        //======== search ========
        {
            Container searchContentPane = search.getContentPane();

            //---- label1 ----
            label1.setText("\u041f\u043e\u0438\u0441\u043a");

            //---- searchBtn ----
            searchBtn.setText("\u041d\u0430\u0439\u0442\u0438");

            //---- cancelBtn ----
            cancelBtn.setText("\u041e\u0442\u043c\u0435\u043d\u0430");

            GroupLayout searchContentPaneLayout = new GroupLayout(searchContentPane);
            searchContentPane.setLayout(searchContentPaneLayout);
            searchContentPaneLayout.setHorizontalGroup(
                searchContentPaneLayout.createParallelGroup()
                    .addGroup(searchContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchContentPaneLayout.createParallelGroup()
                            .addComponent(textField, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, searchContentPaneLayout.createSequentialGroup()
                                .addGap(0, 221, Short.MAX_VALUE)
                                .addComponent(cancelBtn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn)))
                        .addContainerGap())
                    .addGroup(searchContentPaneLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(label1)
                        .addContainerGap(188, Short.MAX_VALUE))
            );
            searchContentPaneLayout.setVerticalGroup(
                searchContentPaneLayout.createParallelGroup()
                    .addGroup(searchContentPaneLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(searchContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBtn)
                            .addComponent(cancelBtn))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            search.pack();
            search.setLocationRelativeTo(search.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alex F
    private JWindow search;
    private JTextField textField;
    private JLabel label1;
    private JButton searchBtn;
    private JButton cancelBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
