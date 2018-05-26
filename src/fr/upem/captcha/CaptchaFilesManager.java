package fr.upem.captcha;

import fr.upem.captcha.graphics.*;
import fr.upem.captcha.images.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FilenameFilter;

// Classe de gestion de fichiers pour l'application Capoupacaptcha

public class CaptchaFilesManager {

	// cette méthode doit être appelée seulement si c'est les fichiers recherchées sont des images
	// on récupère tous les fichiers du dossier et des sous dossiers à partir d'un File, d'une certaines extension
	// on crée un objet de type CaptchaImage 
	// et l'ajoute à une liste passé en paramètre
	public static void getAllFilesWithExtension(File dir, String extension, ArrayList<CaptchaImage> images) {

		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getAllFilesWithExtension(file, extension, images);
			} else {
				if (file.getName().endsWith(extension)) 
					images.add(new CaptchaImage(file.getName(), file.getAbsolutePath()));
			}
		}
	}

	// à partir du dossier "dir", on récupère tous les fichiers contenu dans le niveau "level"
	// et on les ajoute à une liste passée en paramètre
    public static void getDirectories(int level, File dir, ArrayList<File> allDirectories) {
        
		File[] files = dir.listFiles();
		level --;
		for (File file : files) {
			if (file.isDirectory()) {
				if (level == 0) allDirectories.add(file);
			}
		}
		if (level > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					getDirectories(level, file, allDirectories);
				}
			}
		}
    }
}