package fr.upem.captcha;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CaptchaButton extends JButton {

    public CaptchaButton(String label) {

        super();
        setText(getHTMLStyle(label));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setBackground(Color.WHITE);
        setIcon(new ImageIcon("assets/btn.png"));
        setRolloverIcon(new ImageIcon("assets/btn-hover.png"));

        
    }

    public String getHTMLStyle(String label) {

        String newLabel = "<html><div style='padding:30px; color:#333333; font-size:12px; font-family:monospace;'>"
            +label
            +"</div></html>";
        return newLabel;
    }
}