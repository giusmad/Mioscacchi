package com.giusmad.scacchi;

public class Pedone extends Pezzo{
    public Pedone(boolean isBianco) {
        super(isBianco, "Pedone");
    }   
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        return true;
    }
}