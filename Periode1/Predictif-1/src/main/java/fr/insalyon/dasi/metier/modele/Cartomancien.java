/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

/**
 *
 * @author sophiecrowley
 */
public class Cartomancien extends Medium {

    public Cartomancien() {
    }
    
    public Cartomancien(String denomination, String genre, String presentation) {
        super(denomination, genre, presentation);
    }

    @Override
    public String toString() {
        return "Cartomancien{" + super.toString() + '}';
    }
    
}
