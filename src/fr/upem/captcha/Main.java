package fr.upem.captcha;


public class Main {

	public static void main(String[] args) {
		System.out.println("Hello tchoin");
		Captcha cp = new Captcha();
        int cnt = cp.loadRandomTheme();
		System.out.println(cnt);
	}

}
