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
//import Clavier.Clavier;
public class Matus {
    private Dictionnaire dico;
    private Mot motS;
    private int score;
    private int tentatives;
    private boolean victoire;
    
    public Matus(String nomDico){
        dico=new Dictionnaire(nomDico);
        score=0;
        motS=dico.getWord();
        tentatives=5;
        victoire=false;
        String m="";
        for(int i=0;i<motS.getLong();i++){
            m+="_ ";
        }
        System.out.println("Début du jeu vous cherchez : "+m);
    }
    
    public boolean getVictoire(){
        return victoire;
    }
    public Mot getProp(){
        String prop = Clavier.getString().toUpperCase();
        Mot m = new Mot(prop);
        return m;
    }
    public void victoire(){
        System.out.print("Bravo, vous avez gagné !");
        score+=tentatives;
        System.out.print("Score : "+score);
    }
    public void proposition(){
        System.out.println("proposez un mot :");
        Mot mProp= this.getProp();
        motS.testMot(mProp,dico);
        System.out.println(mProp.toString());
        if(mProp.motValide()){
            this.victoire();
        }
        else{
            tentatives--;
        }
    }
    public void showMotS(){
        System.out.println(motS);
    }

    public int getTentatives() {
        return tentatives;
    }
    public String getTiret(){
        String tiret="";
        for(int i =0;i<motS.getLong();i++){
            tiret+="_ ";
        }
        return tiret;
    }
}
