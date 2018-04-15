package fr.upem.captcha;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CaptchaButton extends JButton {


    public CaptchaButton(String label) {

        super(label);
        setBackground(null);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setIcon(new ImageIcon("assets/btn.png"));
        setRolloverIcon(new ImageIcon("assets/btn-hover.png"));
    }
}