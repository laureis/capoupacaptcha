package fr.upem.captcha;

public class App implements Runnable {

    // A l'exécution de l'application, un Menu est créé et affiché
    public void run() {

        final Menu menu = new Menu();
        menu.display();
    }
}