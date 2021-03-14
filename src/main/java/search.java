import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class search {
    public search() {
        initComponents();
    }

    private void cancelBtnActionPerformed(ActionEvent e) {
        search.dispose();
    }

    private void searchBtnActionPerformed(ActionEvent e) {
    }

    private void initComponents() {
        search = new JWindow();
        textField = new JTextField();
        label1 = new JLabel();
        searchBtn = new JButton();
        cancelBtn = new JButton();

        //======== search ========
        {
            Container searchContentPane = search.getContentPane();

            //---- textField ----
            textField.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //---- label1 ----
            label1.setText("\u041f\u043e\u0438\u0441\u043a");
            label1.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            //---- searchBtn ----
            searchBtn.setText("\u041d\u0430\u0439\u0442\u0438");
            searchBtn.addActionListener(e -> searchBtnActionPerformed(e));

            //---- cancelBtn ----
            cancelBtn.setText("\u041e\u0442\u043c\u0435\u043d\u0430");
            cancelBtn.addActionListener(e -> cancelBtnActionPerformed(e));

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
                        .addContainerGap(186, Short.MAX_VALUE))
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
            readFile readFile = new readFile();
            if (readFile.hasPath()) {
                readFile.setFont(new javax.swing.plaf.FontUIResource(readFile.font(),Font.BOLD,12));
            }
            search.setVisible(true);
        }
    }

    private JWindow search;
    private JTextField textField;
    private JLabel label1;
    private JButton searchBtn;
    private JButton cancelBtn;
}
