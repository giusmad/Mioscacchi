package com.giusmad.scacchi;

public class Regina extends Pezzo {

    public Regina(boolean isBianco) {
        super(isBianco, "Regina");
    }

    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        int spostamentoRiga = Math.abs(rigaArrivo - rigaPartenza);
        int spostamentoColonna = Math.abs(colArrivo - colPartenza);

        boolean mossaComeTorre = (rigaPartenza == rigaArrivo || colPartenza == colArrivo) && (spostamentoRiga + spostamentoColonna > 0);
     
        boolean mossaComeAlfiere = (spostamentoRiga == spostamentoColonna) && (spostamentoRiga > 0);

        return mossaComeTorre || mossaComeAlfiere;
    }
}