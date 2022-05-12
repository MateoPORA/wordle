package Wordle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mpora
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matus w=new Matus("petitLarousse.txt");
        //w.showMotS();
        while(w.getTentatives()>0 && !w.getVictoire()){
            w.proposition();
        }
        
    }
    
}
