package fr.upem.captcha;

import fr.upem.captcha.graphics.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Menu extends CaptchaFrame {

    private JPanel panelTitle = new JPanel();
    private JPanel panelDesc = new JPanel();
    private JPanel panelInfo = new JPanel();
    private JPanel panelSubmit = new JPanel();

    public Menu() {
        super();
    }

    public void display() {

        displayTitle();
        displayDesc();
        displayStartButton();
        // displayInfo();
        this.setVisible(true);
    }

    public void displayTitle() {

        panelTitle.setBackground(null);
        panelTitle.add(new CaptchaLabel("CAPOUPACAPTCHA?", 1, 60));
        this.add(panelTitle, BorderLayout.NORTH);
    }

    public void displayDesc() {
        panelDesc.setBackground(null);
        panelDesc.add(new CaptchaLabel("captcha", 2, 0));
        panelDesc.add(new CaptchaLabel("nom masculin", 4, 0));
        panelDesc.add(new CaptchaLabel("Test requis pour accéder "
            +"à certains services sur Internet, "
            +"afin de différencier les utilisateurs humains d'éventuels "
            +"robots malveillants.", 3, 0));
        this.add(panelDesc, BorderLayout.CENTER);
    }

    public void displayInfo() {

        panelInfo.setBackground(null);
        panelInfo.add(new CaptchaLabel("Un projet IMAC / réalisé par Antoine Miaud et Laure Issa / Mai 2018", 5, 5));
        this.add(panelInfo, BorderLayout.SOUTH);
    }

    public void displayStartButton() {

        panelSubmit.setBackground(null);
        CaptchaButton submitButton = new CaptchaButton("Faire le test");
        submitButton.addActionListener( new ActionListener() {
            @SuppressWarnings("unused")
            public void actionPerformed(ActionEvent arg0) {
                final Captcha captcha = new Captcha();
                dispose();
                captcha.display();
            }
        });
        panelSubmit.add(submitButton);
        this.add(panelSubmit, BorderLayout.SOUTH);
    }
}