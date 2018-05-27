package fr.upem.captcha;

// Classe principale
public class Main {

	public static void main(String[] args) {
		System.setProperty( "file.encoding", "UTF-8" );
		new Thread(new App()).start();
	}

}
