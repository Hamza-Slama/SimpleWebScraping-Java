/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hamzewi
 */
public class MyTeckFullDescription {
    
   
    String processeur ; 
    String freqProcesseur;
    String mememoire ; 
    String ecran ; 
    String disqueDur ; 
    String carteGraphique ; 
   

    public MyTeckFullDescription() {
    }

    public MyTeckFullDescription(String processeur, String freqProcesseur, String mememoire, String ecran, String disqueDur, String carteGraphique) {
        this.processeur = processeur;
        this.freqProcesseur = freqProcesseur;
        this.mememoire = mememoire;
        this.ecran = ecran;
        this.disqueDur = disqueDur;
        this.carteGraphique = carteGraphique;
       
    }

    public String getProcesseur() {
        return processeur;
    }

    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }

    public String getFreqProcesseur() {
        return freqProcesseur;
    }

    public void setFreqProcesseur(String freqProcesseur) {
        this.freqProcesseur = freqProcesseur;
    }

    public String getMememoire() {
        return mememoire;
    }

    public void setMememoire(String mememoire) {
        this.mememoire = mememoire;
    }

    public String getEcran() {
        return ecran;
    }

    public void setEcran(String ecran) {
        this.ecran = ecran;
    }

    public String getDisqueDur() {
        return disqueDur;
    }

    public void setDisqueDur(String disqueDur) {
        this.disqueDur = disqueDur;
    }

    public String getCarteGraphique() {
        return carteGraphique;
    }

    public void setCarteGraphique(String carteGraphique) {
        this.carteGraphique = carteGraphique;
    }

    

    
    
}
