package fr.upem.captcha;

public class Image {

    private String name;
    private String url;
    private boolean selected; 

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean getSelected() {
        return this.selected;
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
    
    public Image(String name, String url) {
        this.name = name;
        this.url = url;
        this.selected = false;
    }
}