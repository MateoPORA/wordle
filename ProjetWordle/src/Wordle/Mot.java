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
import ansicolor.AnsiColor;
import java.util.ArrayList;
public class Mot {
    private String motStr; //le mot en String
    private ArrayList<Character> motAL; //le mot sous forme d'ArrayList de character
    private ArrayList<Integer> charStatus; //le mot sous forme 011002 avec 0 absent, 1 mal place et 2 bien place
    
    public Mot(String m){ //constructeur de mot
        motStr=m.toUpperCase();
        ArrayList<Character> motALst = new ArrayList<Character>();
        ArrayList<Integer> charS= new ArrayList<Integer>();
        for (int i=0;i<m.length();i++){
            motALst.add(motStr.charAt(i));
            charS.add(0);
        }
        motAL=motALst;
        charStatus=charS;
        
    }

    public void setMotAL(ArrayList<Character> motAL) {
        this.motAL = motAL;
    }

    public void setCharStatus(ArrayList<Integer> charStatus) {
        this.charStatus = charStatus;
    }

    @Override
    public String toString() {
        return "Mot{" + "motAL=" + motAL + ", charStatus=" + charStatus + '}';
    }
    
    public int getLong(){ //renvoie la longueur d'un mot
        return this.motStr.length();
    }
    public Mot copie(){ //copie un mot pour le modifier
        Mot m=new Mot(this.motStr);
        return m;
    }
    public void setCharStatus(int i, int stat){ //modifie l'etat d'un character i d'un mot en stat
        this.charStatus.set(i, stat);
    }
    public void clearPerfect(Mot mT){ //nettoyage des lettres parfaitement placés
        for(int i=0;i<mT.getLong();i++){
            if(this.motAL.get(i)==mT.motAL.get(i)){
                mT.setCharStatus(i,2);
                this.motAL.set(i,'-');
                mT.motAL.set(i,'-');
            }
        }
        //System.out.println(mT);
    }
    public boolean hasNotLetter(char l){ //verifie si un mot ne contient pas la lettre l
        return !this.motAL.contains(l);
    }
    public boolean hasNotLetter(ArrayList<Character> l){ //pareil avec le groupe de lettres l
        boolean etat=true;
        for(int i=0;i<l.size();i++){
            if(this.motAL.contains(l.get(i))){
                etat=false;
            }
        }
        return etat;
    }
    
    public void clearMissplaced(Mot mT){ //nettoyage des lettres mal placés
        for(int i=0;i<mT.getLong();i++){
            if(this.motAL.contains(mT.motAL.get(i)) && mT.motAL.get(i)!='-'){
                mT.setCharStatus(i,1);
                this.motAL.set(this.motAL.indexOf(mT.motAL.get(i)),'-');
                mT.motAL.set(i,'-');
            }
        }
        //System.out.println(mT);
    }
    public void testMot(Mot m,Dictionnaire d){ //test le mot m par rapport a this
        Mot mS=this.copie();
        Mot mT=m.copie();
        if(this.getLong()==m.getLong()){
            if(m.motInDico(d)){
                mS.clearPerfect(mT);
                mS.clearMissplaced(mT);
                m.setCharStatus(mT.charStatus);
            }
            else{
                System.out.println("mot pas dans le dico");
            }
            //potentiellement add une fonction qui modifie les lettres dispo, mal places, etc...
        }
        else{
            System.out.println("longueur incorrecte");
        }
    }
    public boolean motInDico(Dictionnaire d){
        return d.getDico().contains(this);
    }
    public boolean motValide(){
        boolean etat=true;
        for(int i=0;i<this.getLong();i++){
            if(this.charStatus.get(i)!=2){
                etat=false;
            }
        }
        return etat;
    }
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null){
            return false;
        }
        if(!o.getClass().equals(this.getClass())){
            return false;
        }
        Mot m = (Mot) o;
        if(this.motStr.equals(m.motStr)){
            return true;
        }
        return false;
    }
    public String affichage(){
        String a="";
        for (int i=0;i<this.getLong();i++){
            int etat=this.charStatus.get(i);
            if(etat==2){
                a+=AnsiColor.GREEN_BACKGROUND+this.motAL.get(i);
            }
            if(etat==1){
                a+=AnsiColor.YELLOW_BACKGROUND+this.motAL.get(i);
            }
            if(etat==0){
                a+=AnsiColor.RED_BACKGROUND+this.motAL.get(i);
            }
        }
        return a;
    }
}

