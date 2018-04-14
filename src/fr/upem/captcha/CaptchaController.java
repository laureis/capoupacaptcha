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


    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public String toString() {
        return this.mainTheme.toString();
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

    	int randomIndex2 = ThreadLocalRandom.current().nextInt(0, folderCount);
        while (randomIndex2 == randomIndex) randomIndex2 = ThreadLocalRandom.current().nextInt(0, folderCount);
        File[] images2 = folders[randomIndex2].listFiles(); 
        ArrayList<Image> im2 = new ArrayList<Image>();
        
        for (int i = 0; i < images.length; i++) {
            im2.add(new Image(images2[i].getName(), images2[i].getAbsolutePath(), new Theme(folders[randomIndex].getName(), folders[randomIndex].getPath())) );
        }

        this.mainTheme = theme;
        this.images = smartShuffle(im, im2);
    }

    // fonction qui constuit un tableau d'image contenant entre 1 et 4 images correspondant au thème
    // principal du captcha et d'autres images correspondant à un autre thème
    public ArrayList<Image> smartShuffle(ArrayList<Image> mainThemeImages, ArrayList<Image> otherImages) {

        int nbGood = ThreadLocalRandom.current().nextInt(1, 4);
        ArrayList<Image> img = new ArrayList<Image>();
        Collections.shuffle(mainThemeImages);
        Collections.shuffle(otherImages);
        for (int i = 0; i < nbGood; i++) {
            img.add(mainThemeImages.get(i));
        }
        for (int i = 0; i < 6-nbGood; i++) {
            img.add(otherImages.get(i));
        }
        Collections.shuffle(img);
        return img;        
    }

    // fonction qui vérifie que toutes les images sélectionnées appartiennet au thème principal du captcha
    public boolean checkSelectedImages() {

        for (int i = 0; i < this.images.size(); i++) {
            if (this.images.get(i).getSelected()) {
                if (this.images.get(i).getTheme() != this.mainTheme) return false; 
            }
        }
        return true;
    }

}