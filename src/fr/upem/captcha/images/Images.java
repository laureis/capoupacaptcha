package fr.upem.captcha.images;

import fr.upem.captcha.graphics.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public interface Images {

    public ArrayList<CaptchaImage> getImages();    
    public ArrayList<CaptchaImage> getImages(int number);
    public boolean isCorrect(CaptchaImage image);
}
