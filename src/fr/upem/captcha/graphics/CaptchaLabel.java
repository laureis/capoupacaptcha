package fr.upem.captcha.graphics;

import java.awt.*;
import javax.swing.*;

public class CaptchaLabel extends JLabel {

    private int h;
    private String label;

    public CaptchaLabel(String label, int h) {

        super();
        setText(getHTMLStyle(label, h));
    }

    public String getHTMLStyle(String label, int h)  {

        String newLabel = "<html><div style=' padding:20px; width:190px; color:#333333; font-weight:bold; font-family:Arial;'>"
            +"<h"+h+">"+label+"</h"+h+">"
            +"</div></html>";
        return newLabel;
    }
}