package fr.upem.captcha.images.red;

import fr.upem.captcha.*;
import fr.upem.captcha.images.*;
import java.util.ArrayList;
import fr.upem.captcha.graphics.*; 

public class Red implements Images {

    public ArrayList<CaptchaImage> getImages(int number) {
        ArrayList<CaptchaImage> mdr = new ArrayList<CaptchaImage>();
        return mdr;
    }

    public boolean isCorrect(CaptchaImage image) {
        return false;
    }
}