package com.giusmad.scacchi;


public class Scacchiera {

    private Pezzo[][] griglia = new Pezzo[8][8];

    public Scacchiera() {
        inizializzaScacchiera();
    }

    private void inizializzaScacchiera() {
        // TORRI
        griglia[0][0] = new Torre(false); 
        griglia[0][7] = new Torre(false);
        griglia[7][0] = new Torre(true);
        griglia[7][7] = new Torre(true);

        // PEDONI
        griglia[1][0] = new Pedone(false); 
        griglia[1][1] = new Pedone(false);
        griglia[1][2] = new Pedone(false);
        griglia[1][3] = new Pedone(false);
        griglia[1][4] = new Pedone(false); 
        griglia[1][5] = new Pedone(false);
        griglia[1][6] = new Pedone(false);
        griglia[1][7] = new Pedone(false);

        griglia[6][0] = new Pedone(true); 
        griglia[6][1] = new Pedone(true);
        griglia[6][2] = new Pedone(true);
        griglia[6][3] = new Pedone(true);
        griglia[6][4] = new Pedone(true); 
        griglia[6][5] = new Pedone(true);
        griglia[6][6] = new Pedone(true);
        griglia[6][7] = new Pedone(true);

        // RE
        griglia[0][4] = new Re(false); 
        griglia[7][4] = new Re(true);
        
        // REGINE
        griglia[0][3] = new Regina(false); 
        griglia[7][3] = new Regina(true);
        
        // CAVALLI
        griglia[0][1] = new Cavallo(false); 
        griglia[0][6] = new Cavallo(false);
        griglia[7][1] = new Cavallo(true);
        griglia[7][6] = new Cavallo(true);

        // ALFIERI
        griglia[0][2] = new Alfiere(false); 
        griglia[0][5] = new Alfiere(false);
        griglia[7][2] = new Alfiere(true);
        griglia[7][5] = new Alfiere(true);
    }

    public Pezzo[][] getGriglia() {
        return griglia;
    }

    public boolean direzioneLibera(Pezzo[][] casaDaControllare ){
        return(casaDaControllare != null);
    }
}