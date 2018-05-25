package fr.upem.captcha.images.green;

import fr.upem.captcha.*;
import fr.upem.captcha.images.*;
import java.util.ArrayList;
import fr.upem.captcha.graphics.*; 
import java.io.File;
import java.io.IOException;

public class Food implements Images {

    public void Food() {
        
    }

    public void display() {
        System.out.println("omg it works");
    }
    
    // on récupère toutes les images du thème green
    public void getImages(File dir) {
        try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					getImages(file);
				} else {
					System.out.println("     file:" + file.getPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

        //ArrayList<CaptchaImage> mdr = new ArrayList<CaptchaImage>();
       // return mdr;
    }

    // on récupère un certain nombre d'images du thème green
    public ArrayList<CaptchaImage> getImages(int number) {
        ArrayList<CaptchaImage> mdr = new ArrayList<CaptchaImage>();
        return mdr;
    }

    // l'image est correcte si son url contient green ou truc du genre...
    public boolean isCorrect(CaptchaImage image) {
        return false;
    }
}