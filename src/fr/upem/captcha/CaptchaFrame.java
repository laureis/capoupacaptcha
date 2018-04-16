package fr.upem.captcha;

import java.awt.*;
import javax.swing.*;

public class CaptchaFrame extends JFrame {

    public CaptchaFrame() {
        super();
        this.setTitle("capoupacaptcha");
        this.setSize(360,640);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xFF5555));
    }

}