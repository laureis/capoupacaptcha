package fr.upem.captcha;
import javax.swing.border.EmptyBorder;
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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class CaptchaImage extends JLabel {

    private String url;
    private boolean selected; 
    private Theme theme;
    private ImageIcon img;

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
        this.selected = false;
        this.theme = theme;
        this.img = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setIcon(img);
        this.addEvents();
    }

    public void selectImage() {

        this.selected = true;
        Graphics g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(30, 27, 10, 100);
        g.fillRect(30, 117, 100, 10);
        g.dispose();
    }

    public void unselectImage() {

        this.selected = false;
        this.repaint();
    }

    public void addEvents() {

        this.addMouseListener(new MouseListener() { //Ajouter le listener d'évenement de souris
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
		
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) { //ce qui nous intéresse c'est lorsqu'on clique sur une image, il y a donc des choses à faire ici
                EventQueue.invokeLater(new Runnable() { 
					
					@Override
					public void run() {
						if (selected == false) selectImage();
						else unselectImage();
					}
				});
				
			}
		});
    }
}