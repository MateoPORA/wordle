package Wordle;


import Wordle.Mot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mpora
 */
public class test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mot m = new Mot("BUTES");
        System.out.println(m);
        Mot m2= new Mot("BATES");
        Mot m3= new Mot("FAUTS");
        m.clearPerfect(m2);
        //m.clearPerfect(m2);
        System.out.println(m);
        m.clearMissplaced(m2);
        Dictionnaire d = new Dictionnaire("petitLarousse.txt");
        System.out.println(m.motInDico(d));
        m = new Mot("chat");
        System.out.println(m);
        //System.out.println(d);
        System.out.println(m.motInDico(d));
        Mot n = new Mot("butes");
        System.out.println(n.equals(m));
    }
    
}
