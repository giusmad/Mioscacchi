package com.giusmad.scacchi;

public abstract class Pezzo {
    private String nome;
    private boolean isBianco;

    public Pezzo(boolean isBianco, String nome){
        this.nome = nome;
        this.isBianco = isBianco;
    }

    public String getNome(){
        return nome;
    }

    public boolean getIsBianco(){
        return isBianco;
    }

    public abstract boolean mossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo);
}
