package Wordle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
/**
 *
 * @author cllinas
 */
public class Dictionnaire {
    private String nomDictionnaire;
    private ArrayList<Mot> dico;
   
    public Dictionnaire (String nomDictionnaire){
        this.nomDictionnaire=nomDictionnaire;
        dico = new ArrayList<Mot>();
        try{
            BufferedReader fichier = new BufferedReader(new FileReader(nomDictionnaire));
            while(fichier.ready()){
                Mot m = new Mot(fichier.readLine());
                dico.add(m);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
   
    public Dictionnaire(ArrayList<Mot> unDico){
        this.dico = unDico;
    }
 
   
    //Récupération du mot secret dans le dictionniare
    public Mot getWord(){
        Collections.shuffle(dico);
        return dico.get(0);
    }
   
    //Création d'un nouveau dictionnaire qui contient tous les mots avec un nombre de lettres donné
    public Dictionnaire subDicoNombreLettres(int i){
        ArrayList<Mot> subDico;
        subDico = new ArrayList<Mot>();
        for(int j=0;j<dico.size();j++){
            if(dico.get(j).getLong()==i){
                subDico.add(dico.get(j));
            }
        }
        Dictionnaire nouveauDico = new Dictionnaire(subDico);
        return nouveauDico;
    }
   
    //Création d'un nouveau dictionnaire qui contient tous les mots qui ne contiennent pas les lettres absentes du mot secret
    public Dictionnaire subDicoSansLettresAbsentes(ArrayList<Character> lettresAbsentes){
        ArrayList<Mot> subDico;
        subDico = new ArrayList<Mot>();
        for(int j=0;j<dico.size();j++){
                if(dico.get(j).hasNotLetter(lettresAbsentes)){
                    subDico.add(dico.get(j));
                }
        }
        Dictionnaire nouveauDico = new Dictionnaire(subDico);
        return nouveauDico;   
    }

    public ArrayList<Mot> getDico() {
        return dico;
    }
    
    

    @Override
    public String toString() {
        return "Dictionnaire{" + "dico=" + dico + '}';
    }

    
    

   
}