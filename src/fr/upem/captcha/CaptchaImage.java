package fr.upem.captcha;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CaptchaImage extends JLabel {

    private String url;
    private boolean selected; 
    private Theme theme;

    public String getUrl() {
        return this.url;
    }

    public boolean getSelected() {
        return this.selected;
    }

    public Theme getTheme() {
        return this.theme;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public CaptchaImage(String name, String url, Theme theme) {
        super();
        this.url = url;
        this.selected = true;
        this.theme = theme;
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }

    public void selectImage() {

        this.selected = true;
    }

    public void unselectImage() {

        this.selected = false;
    }
}