package fr.upem.captcha;

import fr.upem.captcha.graphics.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Classe du menu de l'application

public class Menu extends CaptchaFrame {

    private JPanel panelTitle = new JPanel(); // panneau du titre
    private JPanel panelDesc = new JPanel(); // panneau de la description
    private JPanel panelStart = new JPanel(); // panneau du bouton start

    public Menu() {
        super();
    }

    // affichage du menu
    public void display() {

        displayTitle();
        displayDesc();
        displayStartButton();
        this.setVisible(true);
    }

    // ajout du titre au menu
    public void displayTitle() {

        panelTitle.setBackground(null);
        panelTitle.add(new CaptchaLabel("CAPOUPACAPTCHA?", 1, 60));
        this.add(panelTitle, BorderLayout.NORTH);
    }

    // ajout de la description au menu
    public void displayDesc() {
        panelDesc.setBackground(null);
        panelDesc.add(new CaptchaLabel("captcha", 2, 0));
        panelDesc.add(new CaptchaLabel("nom masculin", 4, 0));
        panelDesc.add(new CaptchaLabel("Test requis pour acc\u00e9der "
            +"\u00e0 certains services sur Internet, "
            +"afin de diff\u00e9rencier les vrais utilisateurs humains d'\u00e9ventuels "
            +"robots mal intentionn\u00e9s.", 3, 0));
        this.add(panelDesc, BorderLayout.CENTER);
    }

    // ajout du bouton "start" au menu
    // au clic sur le bouton, la fenêtre du menu est fermée et 
    // la fenêtre du test est lancée
    public void displayStartButton() {

        panelStart.setBackground(null);
        CaptchaButton submitButton = new CaptchaButton("Faire le test");
        submitButton.addActionListener( new ActionListener() {
            @SuppressWarnings("unused")
            public void actionPerformed(ActionEvent arg0) {
                final Captcha captcha = new Captcha();
                dispose();
                captcha.display();
            }
        });
        panelStart.add(submitButton);
        this.add(panelStart, BorderLayout.SOUTH);
    }
}