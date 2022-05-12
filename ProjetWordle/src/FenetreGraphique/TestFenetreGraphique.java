/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FenetreGraphique;

import Wordle.Clavier;
import Wordle.Dictionnaire;
import Wordle.Matus;
import Wordle.Mot;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author guillaume.laurent
 */
public class TestFenetreGraphique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Matus w=new Matus("petitLarousse.txt");
        //w.showMotS();
        while(w.getTentatives()>0 && !w.getVictoire()){
            w.proposition();
            FenetreGraphique fenetre = new FenetreGraphique("WORDLE", 500, 400);
        //fenetre.getGraphics2D().setColor(Color.RED);
        //fenetre.getGraphics2D().drawLine(10, 10, 60, 160);

             fenetre.getGraphics2D().setColor(Color.RED);
             fenetre.getGraphics2D().drawRect(18, 100, 460, 282);

             fenetre.getGraphics2D().setColor(Color.BLUE);
        //fenetre.getGraphics2D().fillOval(200, 10, 20, 10);

             fenetre.getGraphics2D().drawString("WORDLE", 220, 20);
             fenetre.getGraphics2D().drawString("Vous cherchez:", 20, 50);
             fenetre.getGraphics2D().drawString(w.getTiret(), 120, 50);
             fenetre.getGraphics2D().drawString("Tentatives restantes:", 300, 50);
             fenetre.getGraphics2D().drawString(w.toString(), 440, 50);

             fenetre.actualiser();

             fenetre.enregistrerImage("test.png");
             
        }
        
     }

}