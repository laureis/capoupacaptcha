package fr.upem.captcha;

import fr.upem.captcha.graphics.*;
import fr.upem.captcha.images.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CaptchaFilesManager {

    public static void getAllFilesAndDirectories(File dir) {
        try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					getAllFilesAndDirectories(file);
				} else {
					System.out.println("     file:" + file.getPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void getDirectories(int level, File dir, ArrayList<File> allDirectories) {
        
		File[] files = dir.listFiles();
		level --;
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.println(file.getName() + " added ! ");
				allDirectories.add(file);
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

    public static String getClassFiles() {
		return "mdr";
    }

}