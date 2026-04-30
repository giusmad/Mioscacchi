package com.giusmad.scacchi;

public class Game {
    private Scacchiera chessboard;
    private boolean isTurnoBianco;

    public Game(Scacchiera chessboard){
        this.chessboard=chessboard;
        this.isTurnoBianco= true ;
    }

    public boolean giocaMossa(int rigaP, int colP, int rigaA, int colA) {
        
        Pezzo pezzoDaMuovere = this.chessboard.getPezzo(rigaP,colP);

        if (pezzoDaMuovere == null) {
            return false;
        }

        // Controllo del turno
        // Se tocca al bianco (true) ma il pezzo è nero (false) blocco
        if (pezzoDaMuovere.isBianco != this.isTurnoBianco) {
            System.out.println("❌ Errore: Non è il tuo turno!");
            return false;
        }

        boolean mossaEseguita = this.chessboard.eseguiMossa(rigaP, colP, rigaA, colA);

        if (mossaEseguita) {
            // inverti il turno
            this.isTurnoBianco = !this.isTurnoBianco; 
            return true;
        }
        return false; 
    }
    public boolean isTurnoBianco() {
        return this.isTurnoBianco;
    }

}
