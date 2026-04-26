package com.giusmad.scacchi;

public class Regina extends Pezzo{
    public Regina(boolean isBianco) {
        super(isBianco, "Regina");
    }
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        return true;
    }
}
