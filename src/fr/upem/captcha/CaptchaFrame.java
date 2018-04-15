package fr.upem.captcha;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class CaptchaFrame extends JFrame {

    private ImageIcon background;

    public CaptchaFrame() {
        super();
        this.setTitle("capoupacaptcha");
        this.setSize(360,640);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.background = new ImageIcon("assets/bg.png");
    }
    
    public void paint(Graphics g) {
        
        super.paint(g);
        g.drawImage(background.getImage(), 0, 0, this);
    }

}