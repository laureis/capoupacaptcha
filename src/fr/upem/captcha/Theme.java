package fr.upem.captcha;
import java.util.ArrayList;

public class Theme {

    private String name;
    private String url;
    private ArrayList<Image> images = new ArrayList<Image>();

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public ArrayList<Image> getImages() {
        return this.images;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public Theme (String name, String url, ArrayList<Image> images) {
        this.name = name;
        this.url = url;
        this.images = images;
    }
}
