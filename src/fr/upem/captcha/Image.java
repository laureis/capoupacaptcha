package fr.upem.captcha;

public class Image {

    private String name;
    private String url;

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Image(String name, String url) {
        this.name = name;
        this.url = url;
    }
}