package com.giusmad.scacchi;

public class Pedone extends Pezzo {
    
    public Pedone(boolean isBianco) {
        super(isBianco, "Pedone");
    }   
    
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        int direzione = isBianco ? -1 : 1;
        int rigaIniziale = isBianco ? 6 : 1;
        
        // un passo in avanti dritto
        if (colPartenza == colArrivo && rigaArrivo == rigaPartenza + direzione) {
            return true;
        }
        
        // due passi in avanti dritti (solo dalla posizione iniziale)
        if (colPartenza == colArrivo && rigaPartenza == rigaIniziale && rigaArrivo == rigaPartenza + (direzione * 2)) {
            return true;
        }
        
        // un passo in diagonale (usato per mangiare)
        if (Math.abs(colArrivo - colPartenza) == 1 && rigaArrivo == rigaPartenza + direzione) {
            return true;
        }
        
        return false;
    }
}