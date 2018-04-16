package fr.upem.captcha;

public class App extends Thread {

    private final Captcha captcha = new Captcha();

    public App() {
        super();
    }

    public void run() {
        captcha.display();
    }
}