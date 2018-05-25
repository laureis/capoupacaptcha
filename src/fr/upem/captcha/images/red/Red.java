package fr.upem.captcha.images.red;

import fr.upem.captcha.*;
import fr.upem.captcha.images.*;
import java.util.ArrayList;
import fr.upem.captcha.graphics.*; 
import java.io.File;
import java.io.IOException;

public class Red implements Images {

    public void getImages(File dir) {
        ArrayList<CaptchaImage> mdr = new ArrayList<CaptchaImage>();
        //return mdr;
    }
    
    public ArrayList<CaptchaImage> getImages(int number) {
        ArrayList<CaptchaImage> mdr = new ArrayList<CaptchaImage>();
        return mdr;
    }

    public boolean isCorrect(CaptchaImage image) {
        return false;
    }
}