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

// Classe du contrôleur de l'application

public class CaptchaController {
	
    private int level; // 1: easy, 2: medium, 3: hard
    private Images theme; // le thème des images à sélectionner pour un test positif
    private ArrayList<CaptchaImage> images = new ArrayList<CaptchaImage>(); // la liste des images à afficher sur l'application, du bon thème et du mauvais thème
	
    // à l'exécution, le niveau par défaut est 0 et on choisit un thème au hasard de niveau 1
    public CaptchaController() {
        this.level = 1;
        this.setRandomTheme(this.level, new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"));
    }

    // getters et setters

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

    // on incrémente le niveau si possible et on choisit un nouveau thème
    public void refresh() {
        this.upgradeLevel();
        this.setRandomTheme(this.level, new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"));
    }

    // le choix du thème se fait grâce à la méthode de la classe CaptchaFileManager
    // on récupère tous les thèmes correspondant au niveau où en est l'utilisateur
    // et on choisit aléatoirement un thème
    // ensuite, on rajoute les images correspondant à ce thème et au thème voisin
    // on mélange le tout sinon les images seront ordonnées et ce serait facile
    public void setRandomTheme(int level, File dir) {
        
        this.images.clear();
        ArrayList<File> allDirectories = new ArrayList<File>();
        CaptchaFilesManager.getDirectories(this.level, new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"), allDirectories);
        int randomIndex = ThreadLocalRandom.current().nextInt(0, allDirectories.size());
        try {
            Class<?> themeClass = Class.forName("fr.upem.captcha.images."+allDirectories.get(randomIndex).getName().substring(0,1).toUpperCase()+allDirectories.get(randomIndex).getName().substring(1));
            Object o = themeClass.newInstance(); 
            this.theme = (Images) o;
            this.images = this.theme.getImages(ThreadLocalRandom.current().nextInt(1, 4));
            Collections.shuffle(this.images);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // pour chaque image, on vérifie si elle correspond bien au thème principal
    public boolean checkSelectedImages() {

        for (int i = 0; i < this.images.size(); i++) {
            if (! this.theme.isCorrect(this.images.get(i))) return false;
        }
        return true;
    }

    // on incrémente le niveau de 1 s'il est inférieur à 3
    public void upgradeLevel() {

        if (level < 3) level ++;
    }
}