package com.giusmad.scacchi;

public class Re extends Pezzo{
    public Re(boolean isBianco) {
        super(isBianco, "Re");
    }
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        return true;
    }
}

