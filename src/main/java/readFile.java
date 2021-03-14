import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;

import javax.swing.*;
import java.io.*;

public class readFile {
    FileInputStream fis;
    ObjectInputStream ois;
    int theme;

    public void setFont (javax.swing.plaf.FontUIResource f){
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }

    public String font() {
        String fnt="";
    switch (readFont()){
        case 0:
            fnt="Segoe UI";
            break;
        case 1:
            fnt="Mistral";
            break;
        case 2:
            fnt="Impact";
            break;
        case 3:
            fnt="STCaiyun";
            break;
        case 4:
            fnt="Segoe Script";
            break;
        case 5:
            fnt="STSong";
            break;
        case 6:
            fnt="Segoe Print";
            break;
        case 7:
            fnt="Roboto Thin";
            break;
        case 8:
            fnt="Monotype Corsiva";
            break;
        case 9:
            fnt="Calibri";
            break;
        default: fnt="Segoe UI";
        }
        return fnt;
    }


    private int readTheme() {
        save save = new save(0,0,null);
        try{
            fis = new FileInputStream(readPath());
            ois= new ObjectInputStream(fis);
            save = (save) ois.readObject();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return save.getTheme();
    }

    private int readFont() {
        save save = new save(0,0,null);
        try{
            fis = new FileInputStream(readPath());
            ois= new ObjectInputStream(fis);
            save = (save) ois.readObject();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return save.getFont();
    }

    public String readPath() {

            save save = new save(0,0,null);
        try {
            fis = new FileInputStream("path.bin");
            ois = new ObjectInputStream(fis);
             save = (save) ois.readObject();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return save.getPath();
    }

    public boolean hasPath(){
        File file = new File("path.bin");

        if(file.exists()) return true;
        else return false;
    }

    public boolean hasConfig(){
        File config= new File(readPath() + "\\\\\\\\chords_config.bin");
        if(config.exists()) return true;
        else return false;
    }

    public void setTheme(){
        switch (readTheme()){
            case 0:
                FlatMaterialDarkerIJTheme.install();
                break;
            case 1:
                FlatGitHubIJTheme.install();
                break;
            case 2:
                FlatMaterialOceanicIJTheme.install();
                break;
            case 3:
                FlatGradiantoDarkFuchsiaIJTheme.install();
                break;
            case 4:
                FlatNightOwlIJTheme.install();
                break;
            case 5:
                FlatDraculaIJTheme.install();
                break;
            case 6:
                FlatNordIJTheme.install();
                break;
            case 7:
                FlatArcOrangeIJTheme.install();
                break;
            case 8:
                FlatArcDarkIJTheme.install();
                break;
            case 9:
                FlatSolarizedLightIJTheme.install();
                break;
        }
    }

}


