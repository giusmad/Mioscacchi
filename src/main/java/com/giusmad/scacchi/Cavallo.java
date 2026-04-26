package com.giusmad.scacchi;

public class Cavallo extends Pezzo{
    public Cavallo(boolean isBianco) {
        super(isBianco, "Cavallo");
    }
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        return true;
    }
}
