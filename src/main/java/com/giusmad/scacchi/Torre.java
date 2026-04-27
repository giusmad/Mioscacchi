package com.giusmad.scacchi;

public class Torre extends Pezzo{
    public Torre(boolean isBianco) {
        super(isBianco, "Torre");
    }
    @Override
    public boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        int spostamentoRiga = Math.abs(rigaArrivo - rigaPartenza);
        int spostamentoColonna = Math.abs(colArrivo - colPartenza);
        return (rigaPartenza == rigaArrivo || colPartenza == colArrivo) && (spostamentoRiga + spostamentoColonna > 0);
    }
}
