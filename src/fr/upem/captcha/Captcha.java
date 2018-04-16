package fr.upem.captcha;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
        panelDesc.add(new CaptchaLabel("Cap ou pas cap de choisir les images "+controller.getMainTheme().getName()+" ?"));
		this.add(panelDesc, BorderLayout.NORTH);
	}

	public void displayImages() {

		GridLayout layoutImages = new GridLayout(3,2);
        panelImages.setBackground(null);
		panelImages.setLayout(layoutImages);
		for (int i = 0; i < 6; i++) {
			System.out.println(controller.getImages().get(i).getUrl());
			panelImages.add(controller.getImages().get(i));
		}
		this.add(panelImages);
	}

	public void refresh() {
		
		panelDesc.removeAll();
		panelSubmit.removeAll();
		panelImages.removeAll();
		controller.setRandomTheme();
		display();
	}

	public void displaySubmitButton() {

    	panelSubmit.setBackground(null);
		CaptchaButton submitButton = new CaptchaButton("S U B M I T");
		submitButton.addActionListener( new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
                System.out.println(controller.checkSelectedImages());
                JOptionPane.showMessageDialog(null, controller.checkSelectedImages() ? "bien ouej frere" : "ohlala tu es un robot", "Capoupacaptcha" ,JOptionPane.INFORMATION_MESSAGE);
				refresh();
			}
        });
		panelSubmit.add(submitButton);
		this.add(panelSubmit, BorderLayout.SOUTH);
	}
}

