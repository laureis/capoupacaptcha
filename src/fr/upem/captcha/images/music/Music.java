package fr.upem.captcha.images.music;

import fr.upem.captcha.*;
import fr.upem.captcha.images.*;
import java.util.ArrayList;
import fr.upem.captcha.graphics.*; 
import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class Music implements Images {

    public void Music() {
        
    }

    public String getName() {

        return "Music";    
    }
    
    
    public ArrayList<CaptchaImage> getImages() {

        File dir = new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"+File.separator+"music");
        ArrayList<CaptchaImage> images = new ArrayList<CaptchaImage>();
        CaptchaFilesManager.getAllFilesWithExtension(dir, "png", images);
        Collections.shuffle(images);
        return images;
    }

    public ArrayList<CaptchaImage> getImages(int number) {
        ArrayList<CaptchaImage> allImages = getImages();
        ArrayList<CaptchaImage> someImages = new ArrayList<CaptchaImage>();
        for (int i = 0; i < number; i++) {
            someImages.add(allImages.get(i));
        }
        return someImages;
    }

    public boolean isCorrect(CaptchaImage image) {
        ArrayList<CaptchaImage> allImages = getImages();
        for (int i = 0; i < allImages.size(); i++) {
            if ( (image != allImages.get(i)) || (image == allImages.get(i) && (!image.getSelected() ) ))  return false;
        }
        return true;
    }
}