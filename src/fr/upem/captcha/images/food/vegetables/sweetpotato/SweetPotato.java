package fr.upem.captcha.images;

import fr.upem.captcha.*;
import fr.upem.captcha.images.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import fr.upem.captcha.graphics.*; 
import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class SweetPotato implements Images {

    public void SweetPotato() {   
    }

    public String getName() {

        return "les patates douces";    
    }
    
    public ArrayList<CaptchaImage> getImages() {

        File dir = new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"+File.separator+"food"+File.separator+"vegetables"+File.separator+"sweetpotato");
        ArrayList<CaptchaImage> images = new ArrayList<CaptchaImage>();
        CaptchaFilesManager.getAllFilesWithExtension(dir, "png", images);
        return images;
    }

    public ArrayList<CaptchaImage> getImages(int number) {
        
        System.out.println(number);
        ArrayList<CaptchaImage> allImages = new ArrayList<CaptchaImage>();
        CaptchaFilesManager.getAllFilesWithExtension(new File("src"+File.separator+"fr"+File.separator+"upem"+File.separator+"captcha"+File.separator+"images"+File.separator+"food"+File.separator+"vegetables"+File.separator+"carrot"), "png", allImages);
        Collections.shuffle(allImages);
        ArrayList<CaptchaImage> allImagesTheme = getImages();
        Collections.shuffle(allImagesTheme);
        ArrayList<CaptchaImage> someImages = new ArrayList<CaptchaImage>();
        for (int i = 0; i < number; i++) someImages.add(allImagesTheme.get(i));
        for (int i = 0; i < 6 - number; i++) {

            if (!allImagesTheme.contains(allImages.get(i))) someImages.add(allImages.get(i));
            else {
                int randomIndex = ThreadLocalRandom.current().nextInt(0, allImages.size());
                while (allImagesTheme.contains(allImages.get(i))) {
                    randomIndex = ThreadLocalRandom.current().nextInt(0, allImages.size());
                }
                someImages.add(allImages.get(randomIndex));
            }

        }
        return someImages;
    }

    public boolean isCorrect(CaptchaImage image) {

        ArrayList<CaptchaImage> allImages = getImages();
        
        if (image.getSelected()) {
            for (CaptchaImage i : allImages) {

                if (image.getUrl().equals(i.getUrl())) return true;
            }
            return false;
        }
        else {
            for (CaptchaImage i : allImages) {

                if (image.getUrl().equals(i.getUrl())) return false;
            }
            return true;
        }
    }
}