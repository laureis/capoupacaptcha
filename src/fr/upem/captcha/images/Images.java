package fr.upem.captcha.images;

import fr.upem.captcha.graphics.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

// Interface gestion d'un thème
public interface Images {

    public String getName(); 
    // retourne le nom du thème à afficher dans l'instruction de l'application
    
    public ArrayList<CaptchaImage> getImages(); 
    // retourne toutes les images correspondant au thème
    
    public ArrayList<CaptchaImage> getImages(int number); 
    // retourne un certain nombre entre 1 et 4 d'images correspondant
    // au thème et 6 - number images de l'autre thème voisin 

    public boolean isCorrect(CaptchaImage image);
    // si l'image est sélectionnée, on doit vérifiée qu'elle appartienne
    // bien à toutes les images du thème, sinon on vérifie qu'elle n'y appartient pas
}
