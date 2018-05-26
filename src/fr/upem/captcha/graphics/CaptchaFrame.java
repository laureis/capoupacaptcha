package fr.upem.captcha.graphics;

import java.awt.*;
import javax.swing.*;

public class CaptchaFrame extends JFrame {

    public CaptchaFrame() {
        super();
        this.setTitle("capoupacaptcha");
        this.setSize(360,640);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x1c2833));
        this.centerWindow();
    }

    public void centerWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
}