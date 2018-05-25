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

    public Theme getMainTheme() {

        return this.mainTheme;
    }

    public ArrayList<CaptchaImage> getImages() {

        return this.images;
    }

    public void setLevel(int level) {

        this.level = level;
    }
    
    public void setTheme(Images theme) {

        this.theme = theme;
    }

    public void setImages(ArrayList<CaptchaImage> images) {

        this.images = images;
    }

    public String toString() {

        return this.mainTheme.toString();
    }

    public void setRandomTheme(int level, File dir) {
        // TODO
        // à partir de tous les fichiers .java et du level, on utilise l'introspection et on crée un nouveau fichier d'une certaine  classe
        // choisie aléatoirement
        // puis on appelle la fonction getImages de cette classe
        // et remplit le tableau d'images du controller

        ArrayList<File> allDirectories = new ArrayList<File>();
        CaptchaFilesManager.getDirectories(this.level, new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"), allDirectories);
        int randomIndex = ThreadLocalRandom.current().nextInt(0, allDirectories.size());
        System.out.println("mdr : ");
      try {
         // returns the Class object for the class with the specified name
         Class cls = Class.forName("java.lang.ClassLoader");         
         // returns the name and package of the class
         System.out.println("Class found = " + cls.getName());
         System.out.println("Package = " + cls.getPackage());
      } catch(ClassNotFoundException ex) {
         System.out.println(ex.toString());
      }
        /*
        this.images.clear();
        File[] folders = new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images").listFiles();
        int folderCount = folders.length;
    	int randomIndex = ThreadLocalRandom.current().nextInt(0, folderCount);
        for (int i = 0; i < folders.length; i++) {
            System.out.println(folders[randomIndex].getName());
            // System.out.println(folders[randomIndex].getPath() + " " + folders[randomIndex].getPath().endsWith(".java"));
        }

        Theme theme = new Theme(folders[randomIndex].getName(), folders[randomIndex].getPath());
        this.mainTheme = theme;
        this.smartShuffle();
        */
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