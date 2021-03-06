package fr.upem.captcha.graphics;

import java.awt.*;
import javax.swing.*;

public class CaptchaButton extends JButton {

    public CaptchaButton(String label) {

        super();
        this.setText(getHTMLStyle(label));
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setIcon(new ImageIcon("assets/button.png"));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));        
    }

    public String getHTMLStyle(String label) {

        String newLabel = "<html><div style='padding:30px; color:#333333; font-size:10px; font-family:Arial;'>"
            +label
            +"</div></html>";
        return newLabel;
    }
}