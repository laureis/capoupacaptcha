package fr.upem.captcha;

import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class CaptchaController {
	
    private Theme mainTheme;
    private ArrayList<Image> images = new ArrayList<Image>();
	
    public CaptchaController() {
        this.setRandomTheme();
    }

    public Theme getMainTheme() {
        return this.mainTheme;
    }

    public ArrayList<Image> getImages() {
        return this.images;
    }

    public void setRandomTheme() {

        File[] folders = new File("data").listFiles();
    	int folderCount = folders.length;
    	int randomIndex = ThreadLocalRandom.current().nextInt(0, folderCount);

        Theme theme = new Theme(folders[randomIndex].getName(), folders[randomIndex].getPath());

        File[] images = folders[randomIndex].listFiles(); 
        ArrayList<Image> im = new ArrayList<Image>();
        
        for (int i = 0; i < images.length; i++) {
            im.add(new Image(images[i].getName(), images[i].getAbsolutePath(), theme) );
        }

        Collections.shuffle(im);
        this.mainTheme = theme;
        this.images = im;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public String toString() {
        return this.mainTheme.toString();
    }



}