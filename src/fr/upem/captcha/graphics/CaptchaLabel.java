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

        String newLabel = "<html><div style=' padding:10px; width:190px; color:#fdedec; font-weight:bold; font-family:monospace;'>"
            +"<h"+h+">"+label+"</h"+h+">"
            +"</div></html>";
        return newLabel;
    }
}