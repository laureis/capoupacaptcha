package fr.upem.captcha;

public class App implements Runnable {

    public void run() {
        
        final Captcha captcha = new Captcha();
        captcha.display();
    }
}