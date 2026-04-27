package com.giusmad.scacchi;

public class Alfiere extends Pezzo{
    public Alfiere(boolean isBianco) {
        super(isBianco, "Alfiere");
    }
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        int spostamentoRiga = Math.abs(rigaArrivo - rigaPartenza);
        int spostamentoColonna = Math.abs(colArrivo - colPartenza);

        return (spostamentoRiga == spostamentoColonna) && (spostamentoRiga > 0);
    }
    
}
