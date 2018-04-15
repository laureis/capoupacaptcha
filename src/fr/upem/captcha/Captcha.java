package fr.upem.captcha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class Captcha extends CaptchaFrame {

	private CaptchaController controller = new CaptchaController();

	private GridLayout mainLayout = new GridLayout(3,1);
	private JPanel panelDesc = new JPanel(); 
	private JPanel panelImages = new JPanel();
	private JPanel panelSubmit = new JPanel();
	

	public static String coucou = "C'est pas qu'on te fait pas confiance, mais prouve nous que t'es pas un robot";
	
	public Captcha()  {

			super();
		
    		panelDesc.setBackground(null);
        	panelImages.setBackground(null);
        	panelSubmit.setBackground(null);
			panelDesc.add(new CaptchaLabel("Cap ou pas cap de sélectionner les images ? "));
			this.add(panelDesc, BorderLayout.NORTH);

			// Panel des images
			GridLayout layoutImages = new GridLayout(2,3);
			panelImages.setLayout(layoutImages);
			panelImages.setPreferredSize(new Dimension(360,300));
			for (int i = 0; i < 6; i++) {
				System.out.println(controller.getImages().get(i).getUrl());
				panelImages.add(controller.getImages().get(i));
			}
			this.add(panelImages);

			// Panel du bouton de vérification
			CaptchaButton submitButton = new CaptchaButton("submit");
			submitButton.addActionListener( new ActionListener() {
				@SuppressWarnings("unused")
				public void actionPerformed(ActionEvent arg0) {
                    System.out.println(controller.checkSelectedImages());
                    JOptionPane.showMessageDialog(null, Captcha.coucou, "Capoupacaptcha" ,JOptionPane.INFORMATION_MESSAGE);
                }
            });
			panelSubmit.add(submitButton);
			this.add(panelSubmit, BorderLayout.SOUTH);

			this.setVisible(true);

    }
}

