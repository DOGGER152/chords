import java.io.Serializable;

public class save implements Serializable {
    public save(int theme,int font,String path){
        this.theme=theme;
        this.font=font;
        this.path=path;
    }
    int theme;
    int font;

    public String getPath() {
        return path;
    }

    String path;
    public int getTheme() {
        return theme;
    }
    public int getFont() {
        return font;
    }

}
