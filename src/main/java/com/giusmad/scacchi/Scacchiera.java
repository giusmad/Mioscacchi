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
        griglia[1][0] = new Torre(false); 
        griglia[1][1] = new Torre(false);
        griglia[1][2] = new Torre(false);
        griglia[1][3] = new Torre(false);
        griglia[1][4] = new Torre(false); 
        griglia[1][5] = new Torre(false);
        griglia[1][6] = new Torre(false);
        griglia[1][7] = new Torre(false);

        griglia[6][0] = new Torre(true); 
        griglia[6][1] = new Torre(true);
        griglia[6][2] = new Torre(true);
        griglia[6][3] = new Torre(true);
        griglia[6][4] = new Torre(true); 
        griglia[6][5] = new Torre(true);
        griglia[6][6] = new Torre(true);
        griglia[6][7] = new Torre(true);

        // RE
        griglia[0][4] = new Torre(false); 
        griglia[7][4] = new Torre(true);
        
        // REGINE
        griglia[0][3] = new Torre(false); 
        griglia[7][3] = new Torre(true);
        
        // CAVALLI
        griglia[0][1] = new Torre(false); 
        griglia[0][6] = new Torre(false);
        griglia[7][1] = new Torre(true);
        griglia[7][6] = new Torre(true);

        // ALFIERI
        griglia[0][2] = new Torre(false); 
        griglia[0][5] = new Torre(false);
        griglia[7][2] = new Torre(true);
        griglia[7][5] = new Torre(true);
    }

    public Pezzo[][] getGriglia() {
        return griglia;
    }
}