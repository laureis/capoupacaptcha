package fr.upem.captcha;

public class Image {

    private String name;
    private String url;
    private boolean selected; 
    private Theme theme;

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean getSelected() {
        return this.selected;
    }

    public Theme getTheme() {
        return this.theme;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Image(String name, String url, Theme theme) {
        this.name = name;
        this.url = url;
        this.selected = false;
        this.theme = theme;
    }
}