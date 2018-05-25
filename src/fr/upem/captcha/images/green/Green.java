package fr.upem.captcha.images.green;

import fr.upem.captcha.*;
import fr.upem.captcha.images.*;
import java.util.ArrayList;
import fr.upem.captcha.graphics.*; 

public class Green implements Images {

    // on récupère toutes les images du thème green
    public ArrayList<CaptchaImage> getImages() {
        ArrayList<CaptchaImage> mdr = new ArrayList<CaptchaImage>();
        return mdr;
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