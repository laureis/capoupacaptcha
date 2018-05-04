package fr.upem.captcha;

import fr.upem.captcha.graphics.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Menu extends CaptchaFrame {

    private JPanel panelDesc = new JPanel();
    private JPanel panelInfo = new JPanel();
    private JPanel panelSubmit = new JPanel();

    public Menu() {
        super();
    }

    public void display() {

        displayInstruction();
        displayStartButton();
        displayInfo();
        this.setVisible(true);
    }

    public void displayInstruction() {

        panelDesc.setBackground(null);
        panelDesc.add(new CaptchaLabel("CAPOUPACAPTCHA ?", 1));
        this.add(panelDesc, BorderLayout.NORTH);
    }

    public void displayInfo() {

        panelInfo.setBackground(null);
        panelInfo.add(new CaptchaLabel("Un projet incroyable", 2));
        this.add(panelInfo, BorderLayout.SOUTH);
    }

    public void displayStartButton() {

        panelSubmit.setBackground(null);
        CaptchaButton submitButton = new CaptchaButton("EN BAMBE");
        submitButton.addActionListener( new ActionListener() {
            @SuppressWarnings("unused")
            public void actionPerformed(ActionEvent arg0) {
                final Captcha captcha = new Captcha();
                setVisible(false);
                dispose();
                captcha.display();
            }
        });
        panelSubmit.add(submitButton);
        this.add(panelSubmit, BorderLayout.CENTER);
    }
}