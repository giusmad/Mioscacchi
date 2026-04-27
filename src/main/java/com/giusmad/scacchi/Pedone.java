package com.giusmad.scacchi;

public class Pedone extends Pezzo{
    public Pedone(boolean isBianco) {
        super(isBianco, "Pedone");
    }   
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        int direzione = isBianco ? -1 : 1;
        int rigaIniziale = isBianco ? 6 : 1;
        if (colPartenza == colArrivo && rigaArrivo == rigaPartenza + direzione) {
            return true;
        }
        if (colPartenza == colArrivo && rigaPartenza == rigaIniziale && rigaArrivo == rigaPartenza + (direzione * 2)) {
            return true;
        }
        return false;
    }
}