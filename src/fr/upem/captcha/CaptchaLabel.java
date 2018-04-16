package fr.upem.captcha;

import java.awt.*;
import javax.swing.*;

public class CaptchaLabel extends JLabel {

    public CaptchaLabel(String label) {

        super();
        setText(getHTMLStyle(label));
        setFont(new Font("Raleway-Bold", Font.PLAIN, 16));
    }

    public String getHTMLStyle(String label)  {

        String newLabel = "<html><div style=' padding:20px; width:200px; color:#333333; font-size:12px; font-weight:bold; font-family:Arial;'>"
            +label
            +"</div></html>";
        return newLabel;
    }
}