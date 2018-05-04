package fr.upem.captcha;

import fr.upem.captcha.graphics.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class CaptchaController {
	
    private Theme mainTheme;
    private ArrayList<CaptchaImage> images = new ArrayList<CaptchaImage>();
	
    public CaptchaController() {
        this.setRandomTheme();
    }

    public Theme getMainTheme() {

        return this.mainTheme;
    }

    public ArrayList<CaptchaImage> getImages() {

        return this.images;
    }


    public void setImages(ArrayList<CaptchaImage> images) {

        this.images = images;
    }

    public String toString() {

        return this.mainTheme.toString();
    }

    public void setRandomTheme() {

        this.images.clear();
        File[] folders = new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images").listFiles();
    	int folderCount = folders.length;
    	int randomIndex = ThreadLocalRandom.current().nextInt(0, folderCount);

        Theme theme = new Theme(folders[randomIndex].getName(), folders[randomIndex].getPath());
        this.mainTheme = theme;
        this.smartShuffle();
    }

    // fonction qui constuit un tableau d'image contenant entre 1 et 4 images correspondant au thème
    // principal du captcha et d'autres images correspondant à un autre thème
    public void smartShuffle() {

        int nbGood = ThreadLocalRandom.current().nextInt(1, 4);
        this.images = this.mainTheme.getImages(6);
        Collections.shuffle(this.images);
    }

    // fonction qui vérifie que toutes les images sélectionnées appartiennet au thème principal du captcha
    public boolean checkSelectedImages() {

        for (int i = 0; i < this.images.size(); i++) {
            if (! this.mainTheme.isCorrect(this.images.get(i))) return false;
        }
        return true;
    }

}