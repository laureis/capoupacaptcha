package fr.upem.captcha;
import java.io.IOException;
import fr.upem.captcha.images.green.*;
import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		Green g;
		g = new Green();
		new Thread(new App()).start();
	}

}
