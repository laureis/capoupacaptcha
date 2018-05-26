package fr.upem.captcha;

import fr.upem.captcha.graphics.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Captcha extends CaptchaFrame {

	private CaptchaController controller = new CaptchaController();
	private JPanel panelDesc = new JPanel(); 
	private JPanel panelImages = new JPanel();
	private JPanel panelSubmit = new JPanel();

	public Captcha() {

		super();
    }

	public void display() {
		displayInstruction();
		displayImages();
		displaySubmitButton();
		this.setVisible(true);
	}

	public void displayInstruction() {

		panelDesc.setBackground(null);
        panelDesc.add(new CaptchaLabel("Cap ou pas cap de choisir les images "+controller.getTheme().getName()+" ?", 3));
		this.add(panelDesc, BorderLayout.NORTH);
	}

	public void displayImages() {

		GridLayout layoutImages = new GridLayout(3,2);
        panelImages.setBackground(null);
		panelImages.setLayout(layoutImages);
		for (int i = 0; i < 6; i++) {
			panelImages.add(controller.getImages().get(i));
		}
		this.add(panelImages);
	}

	public void refresh() {
		
		panelDesc.removeAll();
		panelSubmit.removeAll();
		panelImages.removeAll();
		controller.refresh();
		display();
	}

	public void displaySubmitButton() {

    	panelSubmit.setBackground(null);
		CaptchaButton submitButton = new CaptchaButton("S U B M I T");
		submitButton.addActionListener( new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
                System.out.println(controller.checkSelectedImages());
                boolean done = controller.checkSelectedImages();
				JOptionPane.showMessageDialog(null, done ? "You're free to go ! " : "Ohlala tu es un robot", "Capoupacaptcha" ,JOptionPane.INFORMATION_MESSAGE);
				if (done) dispose();
				else refresh();
			}
        });
		panelSubmit.add(submitButton);
		this.add(panelSubmit, BorderLayout.SOUTH);
	}
}

