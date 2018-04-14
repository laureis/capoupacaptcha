package fr.upem.captcha;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class Menu extends JFrame {

    JFrame frame = new JFrame("Capoupacaptcha");
	GridLayout layout = createLayout(2,1);
	JLabel title = createTitle();
    JButton startButton = createButton();

    public Menu() {

        this.setTitle("CAPOUPACAPTCHA");
        this.setLayout(layout); 
        this.setSize(500, 700);
        
        this.setResizable(false);
        this.add(title);
        this.add(startButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
	
    private static GridLayout createLayout(int cl, int rw) {

		return new GridLayout(cl,rw);
	}

    private static JLabel createTitle() {

        JLabel label = new JLabel("<html><div style=' font-family: url(''); font-size:20px; text-align:center;'>"+"CAPOUPACAPTCHA"+"</div></html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    private static JButton createButton(){
		JButton button = new JButton("start");
        button.setBackground(Color.RED);
        button.setPreferredSize(new Dimension(40, 40));
        return button;
	}
}