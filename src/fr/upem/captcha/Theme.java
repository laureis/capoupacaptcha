package fr.upem.captcha;

import fr.upem.captcha.graphics.*;
import fr.upem.captcha.images.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Theme implements Images {

    private int level;
    private String name;
    private String url;
    private ArrayList<CaptchaImage> images = new ArrayList<CaptchaImage>();

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }
    
    public ArrayList<CaptchaImage> getImages() {
       return this.images;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public void setImages(ArrayList<CaptchaImage> images) {
        this.images = images;
    }

    public void setImages() {

        File[] listImages = new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"+File.separator+this.name).listFiles();        
        for (int i = 0; i < listImages.length; i++) {
            this.images.add(new CaptchaImage(listImages[i].getName(), listImages[i].getAbsolutePath(), null));
        }
    }

    public Theme (String name, String url) {
        this.name = name;
        this.url = url;
        setImages();
    }

    public ArrayList<CaptchaImage> getImages(int number) {
        Collections.shuffle(this.images);
        ArrayList<CaptchaImage> nImages = new ArrayList<CaptchaImage>();
        for (int i = 0; i < number; i++) {
            nImages.add(this.images.get(i));
        }
        return nImages;
    }

    public boolean isCorrect(CaptchaImage image) {

        for (CaptchaImage i : this.images) {
            if ((image == i) && image.getSelected()) return true;
        }
        return false;
    }

    public void upgradeLevel() {

    }

}
