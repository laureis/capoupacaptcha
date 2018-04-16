package fr.upem.captcha;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void selectImage() {

        this.selected = true;
        Graphics g = getGraphics();
        g.setColor(new Color(0x333333));
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