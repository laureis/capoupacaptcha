package fr.upem.captcha;

import fr.upem.captcha.graphics.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

// Classe de gestion de l'application

public class Captcha extends CaptchaFrame {

	private CaptchaController controller = new CaptchaController(); // contrôleur de niveau et de vérification
	private JPanel panelDesc = new JPanel();  // panneau de description et d'instruction
	private JPanel panelImages = new JPanel(); // panneau des images
	private JPanel panelSubmit = new JPanel(); // panneau du bouton submit

	// création d'une fenêtre CaptchaFrame basique
	public Captcha() {

		super();
    }

	// affichage de la fenêtre
	public void display() {
		displayInstruction();
		displayImages();
		displaySubmitButton();
		this.setVisible(true);
	}

	// ajout du panneau d'instruction à la fenêtre
	public void displayInstruction() {

		panelDesc.setBackground(null);
        panelDesc.add(new CaptchaLabel("Cap ou pas cap de choisir "+controller.getTheme().getName()+" ?", 3, 10));
		this.add(panelDesc, BorderLayout.NORTH);
	}

	// ajout du panneau d'images à la fenêtre
	public void displayImages() {

		GridLayout layoutImages = new GridLayout(3,2);
        panelImages.setBackground(null);
		panelImages.setLayout(layoutImages);
		for (int i = 0; i < 6; i++) {
			panelImages.add(controller.getImages().get(i));
		}
		this.add(panelImages);
	}

	// ajout du panneau contenant le bouton de vérification
	// au clic sur le bouton, si l'utilisateur a bien sélectionné les images
	// on relance le thread de l'application
	// sinon on relance un nouveau thème
	public void displaySubmitButton() {

    	panelSubmit.setBackground(null);
		CaptchaButton submitButton = new CaptchaButton("vérifier");
		submitButton.addActionListener( new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
                boolean done = controller.checkSelectedImages();
				JOptionPane.showMessageDialog(null, done ? "Bien joué ! " : "Oops ! Vous pouvez réessayer.", "Capoupacaptcha" ,JOptionPane.INFORMATION_MESSAGE);
				if (done) {
					dispose();
					new Thread(new App()).start();
				}
				else refresh();
			}
        });
		panelSubmit.add(submitButton);
		this.add(panelSubmit, BorderLayout.SOUTH);
	}

	// on remet à zéro la fenêtre et le contrôleur
	public void refresh() {
		
		panelDesc.removeAll();
		panelSubmit.removeAll();
		panelImages.removeAll();
		controller.refresh();
		display();
	}
}

