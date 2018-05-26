package fr.upem.captcha.graphics;

import java.awt.*;
import javax.swing.*;

public class CaptchaLabel extends JLabel {

    private int h;
    private String label;

    public CaptchaLabel(String label, int h, int padding) {

        super();
        setText(getHTMLStyle(label, h, padding));
    }

    public String getHTMLStyle(String label, int h, int padding)  {

        String newLabel = "<html><div style=' padding:"+padding+"px; width:200px; color:#fdedec; font-weight:bold; font-family:monospace; text-align:justify'>"
            +"<h"+h+">"+label+"</h"+h+">"
            +"</div></html>";
        return newLabel;
    }
}