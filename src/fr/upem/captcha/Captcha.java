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

public class Captcha extends JFrame {

	
	public static String coucou = "C'est pas qu'on te fait pas confiance, mais prouve nous que t'es pas un robot";
	private JPanel pan = new JPanel();
	private JLabel bjr = new JLabel("hola bb");
	private JButton b_jouer = new JButton("Start");
	
	public Captcha() {

			this.setTitle("Capoupacaptcha");
			this.setSize(800,350);
			this.setResizable(false);
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
			pan.add(b_jouer);
			this.add(pan, BorderLayout.SOUTH);
			this.setVisible(true);

    }
}
	