package fr.upem.captcha;

import fr.upem.captcha.*;
import fr.upem.captcha.graphics.*;
import fr.upem.captcha.images.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CaptchaController {
	
    private int level;
    private Images theme;
    private Theme mainTheme;
    private ArrayList<CaptchaImage> images = new ArrayList<CaptchaImage>();
	
    public CaptchaController() {
        this.level = 1;
        this.setRandomTheme(this.level, new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"));
    }

    public int getLevel() {
        
        return this.level; 
    }

    public Images getTheme() {

        return this.theme;
    }

    public ArrayList<CaptchaImage> getImages() {

        return this.images;
    }

    public void setLevel(int level) {

        this.level = level;
    }
    

    public void setImages(ArrayList<CaptchaImage> images) {

        this.images = images;
    }

    public String toString() {

        return this.mainTheme.toString();
    }

    public void setRandomTheme(int level, File dir) {
    
        ArrayList<File> allDirectories = new ArrayList<File>();
        CaptchaFilesManager.getDirectories(this.level, new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"), allDirectories);
        int randomIndex = ThreadLocalRandom.current().nextInt(0, allDirectories.size());
        try {
            Class<?> themeClass = Class.forName("fr.upem.captcha.images."+allDirectories.get(randomIndex).getName()+"."+allDirectories.get(randomIndex).getName().substring(0,1).toUpperCase()+allDirectories.get(randomIndex).getName().substring(1).toLowerCase());
            Object o = themeClass.newInstance(); 
            this.theme = (Images) o;
            this.images = this.theme.getImages(6);
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // fonction qui constuit un tableau d'image contenant entre 1 et 4 images correspondant au thème
    // principal du captcha et d'autres images correspondant à un autre thème
    public void smartShuffle() {

        int nbGood = ThreadLocalRandom.current().nextInt(1, 4);
        this.images = this.mainTheme.getImages(ThreadLocalRandom.current().nextInt(1, 4);
        Collections.shuffle(this.images);
    }

    // fonction qui vérifie que toutes les images sélectionnées appartiennet au thème principal du captcha
    public boolean checkSelectedImages() {

        for (int i = 0; i < this.images.size(); i++) {
            if (! this.theme.isCorrect(this.images.get(i))) return false;
        }
        return true;
    }

}