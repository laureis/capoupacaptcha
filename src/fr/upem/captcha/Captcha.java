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


public class Captcha extends JFrame {

	
	public static String coucou = "C'est pas qu'on te fait pas confiance, mais prouve nous que t'es pas un robot";
	private JPanel pan = new JPanel();
	private JLabel bjr = new JLabel("hola bb");
	private JButton b_jouer = new JButton("Start");
	private CaptchaController controller = new CaptchaController();
	private GridLayout layout = new GridLayout(4,4);

	public Captcha() throws IOException  {

			this.setTitle("Capoupacaptcha");
			this.setSize(800,350);
			this.setResizable(false);
			this.setLayout(layout);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			
			pan.add(bjr);
			pan.setBackground(Color.PINK);
			b_jouer.addActionListener( new ActionListener() {
				@SuppressWarnings("unused")
				public void actionPerformed(ActionEvent arg0) {
                    
                    JOptionPane.showMessageDialog(null, Captcha.coucou, "Capoupacaptcha" ,JOptionPane.INFORMATION_MESSAGE);
			        Menu m = new Menu();
                    }
                }
			);

			for (int i = 0; i < controller.getMainTheme().getImages().size(); i++) {
				System.out.println(controller.getMainTheme().getImages().get(i).getUrl());
				try {
					this.add(createLabelImage(controller.getMainTheme().getImages().get(i).getUrl()));
				}
				catch (IOException oops) {
					System.out.println("oops");
				}
			}

			pan.add(b_jouer);
			this.add(pan, BorderLayout.SOUTH);
			this.setVisible(true);

    }

    private static JLabel createLabelImage(String imageLocation) throws IOException {
		final JLabel label;
		try {
			
			BufferedImage img = ImageIO.read(new File(imageLocation)); //lire l'image
			Image sImage = img.getScaledInstance(800/4,350/4, Image.SCALE_SMOOTH);
			label = new JLabel(new ImageIcon(sImage));
		}
		catch (IOException oups) {
			return new JLabel("mdr c a apas marché");
		}
		return label;
	}
}

