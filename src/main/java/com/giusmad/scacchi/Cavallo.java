package com.giusmad.scacchi;

public class Cavallo extends Pezzo{
    public Cavallo(boolean isBianco) {
        super(isBianco, "Cavallo");
    }
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        int spostamentoRiga = Math.abs(rigaArrivo - rigaPartenza);
        int spostamentoColonna = Math.abs(colArrivo - colPartenza);

        boolean casoA = (spostamentoRiga == 2 && spostamentoColonna == 1);
    
        boolean casoB = (spostamentoRiga == 1 && spostamentoColonna == 2);

        return casoA || casoB;
    }
}
