package fr.upem.captcha;

import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.util.ArrayList;


public class CaptchaController {
	
    private Theme mainTheme;
    
	public CaptchaController() {
        this.setRandomTheme();
    }

    public Theme getMainTheme() {
        return this.mainTheme;
    }

    public void setRandomTheme() {

        File[] folders = new File("data").listFiles();
    	int folderCount = folders.length;
    	int randomIndex = ThreadLocalRandom.current().nextInt(0, folderCount);
        File[] images = folders[randomIndex].listFiles(); 
        ArrayList<Image> im = new ArrayList<Image>();
        for (int i = 0; i < images.length; i++) {
            im.add(new Image(images[i].getName(), images[i].getAbsolutePath()));
        }
        Theme theme = new Theme(folders[randomIndex].getName(), folders[randomIndex].getPath(), im);
        this.mainTheme = theme;
    }

    public String toString() {
        return this.mainTheme.toString();
    }



}