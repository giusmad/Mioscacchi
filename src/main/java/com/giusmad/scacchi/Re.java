package com.giusmad.scacchi;

public class Re extends Pezzo{
    public Re(boolean isBianco) {
        super(isBianco, "Re");
    }
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        int spostamentoRiga = Math.abs(rigaArrivo - rigaPartenza);
        int spostamentoColonna = Math.abs(colArrivo - colPartenza);

        boolean casoA = (spostamentoRiga == 0 && spostamentoColonna == 1);
    
        boolean casoB = (spostamentoRiga == 1 && spostamentoColonna == 0);

        boolean casoC = (spostamentoRiga == 1 && spostamentoColonna == 1);

        return casoA || casoB || casoC;
    }
}

