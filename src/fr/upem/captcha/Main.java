package fr.upem.captcha;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		
		try {Captcha cc = new Captcha();}
				catch (IOException oops) {
					System.out.println("oops");
		}
	}

}
