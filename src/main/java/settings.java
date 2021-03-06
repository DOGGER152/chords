import java.awt.event.*;
import javax.swing.event.*;
import com.formdev.flatlaf.*;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Array;
import javax.swing.*;
public class settings {
    public settings() {initComponents();}
    private int theme;
    private int font;
    private String[] wip = {"<html><font size=\"17\" colour=\"red\" face=\"Vladimir Script\">Chord</font></html>"};
    String path;

    public void openPersonalisation(){
        tabbedPane1.setSelectedIndex(2);
    }
    
    private void aboutActionPerformed(ActionEvent e) {
        settings.dispose();
        new about();
    }

    private void fileChoserBtnActionPerformed(ActionEvent e) {
       setUpdateUI(jfc);
       jfc.setDialogTitle("Выбор директории");
       jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       int result = jfc.showOpenDialog(settings);
       if(result == JFileChooser.APPROVE_OPTION){
           initComponents();
           fileChoserPath.setText(jfc.getSelectedFile().getAbsolutePath());
       }
       else if(result == JFileChooser.CANCEL_OPTION) new chords();

    }

    private void githubActionPerformed(ActionEvent e)  {
        URI uri = null;
        try {
            uri = new URI("https://github.com/DOGGER152");
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

    private void vkActionPerformed(ActionEvent e)  {
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

    private void emailActionPerformed(ActionEvent e)  {
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

    private void cancelBtnActionPerformed(ActionEvent e) {
        settings.dispose();
        new chords();
    }

    private void saveBtnActionPerformed(ActionEvent e) {
        if(fileChoserPath.getText().equals("")) {
            JOptionPane.showMessageDialog(settings,
                    "Пожалуйста, укажите путь для сохранения",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
            initComponents();
        }
            else {
                path = jfc.getSelectedFile().getAbsolutePath();
            path = path.replaceAll("\\\\","\\\\\\\\");
            FileOutputStream fos,fosPath;
            ObjectOutputStream oos,oosPath;
            save save = new save(themes.getSelectedIndex(),fonts.getSelectedIndex(),null);
            save savePath = new save(0,0,path);
            try {
                fos = new FileOutputStream(path+"\\\\\\\\chords_config.bin");
                fosPath=new FileOutputStream("path.bin");
                try {
                    oos = new ObjectOutputStream(fos);
                    oosPath=new ObjectOutputStream(fosPath);

                    oosPath.writeObject(savePath);
                    oos.writeObject(save);

                    oos.close();
                    oosPath.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            JOptionPane.showMessageDialog(settings,
                    "Успешно!. Перезагрузите программу",
                    "Сохранение",
                    JOptionPane.INFORMATION_MESSAGE);

            settings.dispose();

            new chords();
        }
    }


    private static void setUpdateUI(JFileChooser choose) {
        UIManager.put("FileChooser.openButtonText", "Открыть");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.lookInLabelText", "Смотреть в");
        UIManager.put("FileChooser.fileNameLabelText", "Имя файла");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Тип файла");

        UIManager.put("FileChooser.saveButtonText", "Сохранить");
        UIManager.put("FileChooser.saveButtonToolTipText", "Сохранить");
        UIManager.put("FileChooser.openButtonText", "Открыть");
        UIManager.put("FileChooser.openButtonToolTipText", "Открыть");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Отмена");

        UIManager.put("FileChooser.lookInLabelText", "Папка");
        UIManager.put("FileChooser.saveInLabelText", "Папка");
        UIManager.put("FileChooser.fileNameLabelText", "Имя файла");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Тип файлов");

        UIManager.put("FileChooser.upFolderToolTipText", "На один уровень вверх");
        UIManager.put("FileChooser.newFolderToolTipText", "Создание новой папки");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Список");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Таблица");
        UIManager.put("FileChooser.fileNameHeaderText", "Имя");
        UIManager.put("FileChooser.fileSizeHeaderText", "Размер");
        UIManager.put("FileChooser.fileTypeHeaderText", "Тип");
        UIManager.put("FileChooser.fileDateHeaderText", "Изменен");
        UIManager.put("FileChooser.fileAttrHeaderText", "Атрибуты");

        UIManager.put("FileChooser.acceptAllFileFilterText", "Все файлы");
        choose.updateUI();
    }

    private void resetBtnActionPerformed(ActionEvent e) {
        readFile rf = new readFile();
        if(rf.hasPath()||rf.hasConfig()) {
            File path = new File("path.bin");
            path.delete();
        }
        if(rf.hasConfig()||rf.hasPath()){
            File config = new File(rf.readPath()  + "\\\\\\\\chords_config.bin");
            config.delete();

            JOptionPane.showMessageDialog(settings,
                    "Успешно!. Перезагрузите программу",
                    "Сброс настроек",
                    JOptionPane.WARNING_MESSAGE);
        }
        else JOptionPane.showMessageDialog(settings,
                "Не удалось найти файл сохранения",
                "Ошибка",
                JOptionPane.ERROR_MESSAGE);
        settings.dispose();
        new  chords();
    }

    public String[] themesArr = {"Dark","Light","Oceanic","Dark Purple","Blue","Dracula","Nord","Orange Light","Orange Dark","Eye Saver"};
    public String[] fontsArr = {"<html><font face=\"Segoe UI\">Segoe(Default)</font></html>",
            "<html><font face=\"Mistral\">Mistral</font></html>",
            "<html><font face=\"Impact\"> Impact </font></html>",
            "<html><font face=\"STCaiyun\">STCaiyun</font></html>",
            "<html><font face=\"Segoe Script\">Segoe Script</font></html>",
            "<html><font face=\"STSong\">STSong</font></html>",
            "<html><font face=\"Segoe Print\">Segoe Print</font></html>",
            "<html><font face=\"Roboto Thin\">Roboto Thin</font></html>",
            "<html><font face=\"Monotype Corsiva\">Monotype Corsiva</font></html>",
            "<html><font face=\"Calibri\">Calibri</font></html>"};

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alex F
        settings = new JWindow();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label5 = new JLabel();
        fileChoserPath = new JTextField();
        fileChoserBtn = new JButton();
        separator3 = new JSeparator();
        label6 = new JLabel();
        email = new JButton();
        vk = new JButton();
        github = new JButton();
        separator4 = new JSeparator();
        label7 = new JLabel();
        about = new JButton();
        label8 = new JLabel();
        panel2 = new JPanel();
        label4 = new JLabel();
        scrollPane3 = new JScrollPane();
        saves = new JList(wip);
        panel3 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        themes = new JList(themesArr);
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        fonts = new JList(fontsArr);
        separator1 = new JSeparator();
        separator2 = new JSeparator();
        label3 = new JLabel();
        resetBtn = new JButton();
        cancelBtn = new JButton();
        saveBtn = new JButton();
        label9 = new JLabel();

        //======== settings ========
        {
            settings.setFocusable(false);
            settings.setFocusableWindowState(false);
            Container settingsContentPane = settings.getContentPane();

            //======== tabbedPane1 ========
            {

                //======== panel1 ========
                {
                    panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
                    . EmptyBorder( 0, 0, 0, 0) , null, javax. swing. border. TitledBorder. CENTER, javax
                    . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,
                    12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
                    . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .
                    getPropertyName () )) throw new RuntimeException( ); }} );

                    //---- label5 ----
                    label5.setText("\u041f\u0443\u0442\u044c \u043a \u0444\u0430\u0439\u043b\u0443 \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f:");

                    //---- fileChoserPath ----
                    fileChoserPath.setVerifyInputWhenFocusTarget(false);
                    fileChoserPath.setRequestFocusEnabled(false);

                    //---- fileChoserBtn ----
                    fileChoserBtn.setText("\u041e\u0431\u0437\u043e\u0440");
                    fileChoserBtn.addActionListener(e -> fileChoserBtnActionPerformed(e));

                    //---- label6 ----
                    label6.setText("\u041e\u0431\u0440\u0430\u0442\u043d\u0430\u044f \u0441\u0432\u044f\u0437\u044c");

                    //---- email ----
                    email.setText("\u042d\u043b\u0435\u043a\u0442\u0440\u043e\u043d\u043d\u0430\u044f \u043f\u043e\u0447\u0442\u0430");
                    email.addActionListener(e -> emailActionPerformed(e));

                    //---- vk ----
                    vk.setText("\u0421\u0442\u0440\u0430\u043d\u0438\u0446\u0430 \u0412\u041a\u043e\u043d\u0442\u0430\u043a\u0442\u0435");
                    vk.addActionListener(e -> vkActionPerformed(e));

                    //---- github ----
                    github.setText("GitHub");
                    github.addActionListener(e -> githubActionPerformed(e));

                    //---- label7 ----
                    label7.setText("\u041e \u043f\u0440\u043e\u0433\u0440\u0430\u043c\u043c\u0435:");

                    //---- about ----
                    about.setText("About");
                    about.addActionListener(e -> aboutActionPerformed(e));

                    //---- label8 ----
                    label8.setText("Thanks for using me!");
                    label8.setFont(new Font("Showcard Gothic", Font.ITALIC, 16));
                    label8.setForeground(Color.red);
                    label8.setHorizontalAlignment(SwingConstants.CENTER);

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGap(0, 156, Short.MAX_VALUE)
                                        .addComponent(label6)
                                        .addGap(160, 160, 160))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(separator3, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label5, GroupLayout.Alignment.LEADING)))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(email)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(vk)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(github))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(fileChoserPath, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fileChoserBtn)))
                                        .addContainerGap(9, Short.MAX_VALUE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(separator4, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 5, Short.MAX_VALUE))))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(label7)
                                .addGap(59, 59, 59)
                                .addComponent(about)
                                .addGap(0, 159, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(115, Short.MAX_VALUE)
                                .addComponent(label8)
                                .addGap(114, 114, 114))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(email)
                                        .addComponent(vk)
                                        .addComponent(github))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(fileChoserPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fileChoserBtn))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(separator3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(label6)
                                        .addGap(48, 48, 48)))
                                .addGap(26, 26, 26)
                                .addComponent(separator4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label7)
                                    .addComponent(about))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(label8)
                                .addContainerGap())
                    );
                }
                tabbedPane1.addTab("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438", panel1);

                //======== panel2 ========
                {

                    //---- label4 ----
                    label4.setText("\u0412\u0441\u0435 \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f");
                    label4.setHorizontalAlignment(SwingConstants.CENTER);
                    label4.setHorizontalTextPosition(SwingConstants.CENTER);

                    //======== scrollPane3 ========
                    {
                        scrollPane3.setViewportView(saves);
                    }

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addContainerGap(159, Short.MAX_VALUE)
                                .addComponent(label4)
                                .addGap(162, 162, 162))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }
                tabbedPane1.addTab("\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f", panel2);

                //======== panel3 ========
                {

                    //---- label1 ----
                    label1.setText("\u0422\u0435\u043c\u0430:");

                    //======== scrollPane1 ========
                    {

                        //---- themes ----
                        themes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        scrollPane1.setViewportView(themes);
                    }

                    //---- label2 ----
                    label2.setText("\u0428\u0440\u0438\u0444\u0442:");

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setViewportView(fonts);
                    }

                    //---- separator2 ----
                    separator2.setOrientation(SwingConstants.VERTICAL);

                    //---- label3 ----
                    label3.setText("\u0421\u0431\u0440\u043e\u0441");

                    //---- resetBtn ----
                    resetBtn.setText("\u0421\u0431\u0440\u043e\u0441\u0438\u0442\u044c \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438");
                    resetBtn.addActionListener(e -> resetBtnActionPerformed(e));

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(label2)
                                .addContainerGap(76, Short.MAX_VALUE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(label3)
                                        .addGap(0, 79, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                        .addComponent(resetBtn)
                                        .addGap(25, 25, 25))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(separator1, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                        .addContainerGap())))
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(resetBtn)
                                        .addGap(0, 14, Short.MAX_VALUE))
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(separator2, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                                .addContainerGap())
                    );
                }
                tabbedPane1.addTab("\u041f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u0438\u0437\u0430\u0446\u0438\u044f", panel3);
            }

            //---- cancelBtn ----
            cancelBtn.setText("\u041e\u0442\u043c\u0435\u043d\u0430");
            cancelBtn.addActionListener(e -> cancelBtnActionPerformed(e));

            //---- saveBtn ----
            saveBtn.setText("\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c");
            saveBtn.addActionListener(e -> saveBtnActionPerformed(e));

            //---- label9 ----
            label9.setText("by Alex F");
            label9.setFont(new Font("Rage Italic", Font.PLAIN, 22));
            label9.setForeground(new Color(0, 102, 153));

            GroupLayout settingsContentPaneLayout = new GroupLayout(settingsContentPane);
            settingsContentPane.setLayout(settingsContentPaneLayout);
            settingsContentPaneLayout.setHorizontalGroup(
                settingsContentPaneLayout.createParallelGroup()
                    .addGroup(settingsContentPaneLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(cancelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(saveBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tabbedPane1)
            );
            settingsContentPaneLayout.setVerticalGroup(
                settingsContentPaneLayout.createParallelGroup()
                    .addGroup(settingsContentPaneLayout.createSequentialGroup()
                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(settingsContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelBtn)
                            .addComponent(saveBtn)
                            .addComponent(label9))
                        .addGap(0, 15, Short.MAX_VALUE))
            );
            settings.pack();
            settings.setLocationRelativeTo(settings.getOwner());
            readFile readFile = new readFile();
            if (readFile.hasPath()) {
                readFile.setFont(new javax.swing.plaf.FontUIResource(readFile.font(),Font.BOLD,12));
            }
            settings.setVisible(true);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alex F
    private JWindow settings;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label5;
    private JTextField fileChoserPath;
    private JButton fileChoserBtn;
    private JSeparator separator3;
    private JLabel label6;
    private JButton email;
    private JButton vk;
    private JButton github;
    private JSeparator separator4;
    private JLabel label7;
    private JButton about;
    private JLabel label8;
    private JPanel panel2;
    private JLabel label4;
    private JScrollPane scrollPane3;
    private JList saves;
    private JPanel panel3;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList themes;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JList fonts;
    private JSeparator separator1;
    private JSeparator separator2;
    private JLabel label3;
    private JButton resetBtn;
    private JButton cancelBtn;
    private JButton saveBtn;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JFileChooser jfc = new JFileChooser();
}
