package com.giusmad.scacchi;


public class Scacchiera {

    private Pezzo[][] griglia = new Pezzo[8][8];

    public Scacchiera() {
        inizializzaScacchiera();
    }

    private void inizializzaScacchiera() {
        // TORRI
        griglia[0][0] = new Torre(false); 
        griglia[0][7] = new Torre(false);
        griglia[7][0] = new Torre(true);
        griglia[7][7] = new Torre(true);

        // PEDONI
        griglia[1][0] = new Pedone(false); 
        griglia[1][1] = new Pedone(false);
        griglia[1][2] = new Pedone(false);
        griglia[1][3] = new Pedone(false);
        griglia[1][4] = new Pedone(false); 
        griglia[1][5] = new Pedone(false);
        griglia[1][6] = new Pedone(false);
        griglia[1][7] = new Pedone(false);

        griglia[6][0] = new Pedone(true); 
        griglia[6][1] = new Pedone(true);
        griglia[6][2] = new Pedone(true);
        griglia[6][3] = new Pedone(true);
        griglia[6][4] = new Pedone(true); 
        griglia[6][5] = new Pedone(true);
        griglia[6][6] = new Pedone(true);
        griglia[6][7] = new Pedone(true);

        // RE
        griglia[0][4] = new Re(false); 
        griglia[7][4] = new Re(true);
        
        // REGINE
        griglia[0][3] = new Regina(false); 
        griglia[7][3] = new Regina(true);
        
        // CAVALLI
        griglia[0][1] = new Cavallo(false); 
        griglia[0][6] = new Cavallo(false);
        griglia[7][1] = new Cavallo(true);
        griglia[7][6] = new Cavallo(true);

        // ALFIERI
        griglia[0][2] = new Alfiere(false); 
        griglia[0][5] = new Alfiere(false);
        griglia[7][2] = new Alfiere(true);
        griglia[7][5] = new Alfiere(true);
    }

    public Pezzo getPezzo(int riga, int colonna) {
        return griglia[riga][colonna];
    }

    public boolean direzioneLibera(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        int passoRiga = 0;
        if (rigaArrivo > rigaPartenza) passoRiga = 1;
        else if (rigaArrivo < rigaPartenza) passoRiga = -1;

        int passoColonna = 0;
        if (colArrivo > colPartenza) passoColonna = 1;
        else if (colArrivo < colPartenza) passoColonna = -1;

        int rigaCorrente = rigaPartenza + passoRiga;
        int colCorrente = colPartenza + passoColonna;

        while (rigaCorrente != rigaArrivo || colCorrente != colArrivo) {
            if (griglia[rigaCorrente][colCorrente] != null) {
                return false; 
            }
            
            rigaCorrente += passoRiga;
            colCorrente += passoColonna;
        }

        return true;
    }

    public boolean eseguiMossa(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        Pezzo pezzoDaMuovere = griglia[rigaPartenza][colPartenza];
        // controllo che nella casella selezionata ci sia effettivamente un pezzo
        if (pezzoDaMuovere == null) {
            return false; 
        }
        // geometria
        if (!pezzoDaMuovere.mossaValida(rigaPartenza, colPartenza, rigaArrivo, colArrivo)) {
            return false;
        }
        // direzione libera a meno del cavallo che salta
        if (!(pezzoDaMuovere instanceof Cavallo)) {
            if (!direzioneLibera(rigaPartenza, colPartenza, rigaArrivo, colArrivo)) {
                return false; 
            }
        }
        Pezzo pezzoInArrivo = griglia[rigaArrivo][colArrivo];
        // controllo che il pezzo in arrivo non sia una casella vuota
        // controllo che nella casa di arrivo non ci sia un pezzo "amico"
        if (pezzoInArrivo != null) {
            if (pezzoInArrivo.isBianco == pezzoDaMuovere.isBianco) {
                return false; 
            }
        }
        // eccezione pedone
        if (pezzoDaMuovere instanceof Pedone) {
            boolean mossaDiagonale = (colPartenza != colArrivo); // più specifico -> boolean mossaDiagonale = Math.abs(colA - colP) == 1;
            if (mossaDiagonale) {
                if (pezzoInArrivo == null) {
                    return false; 
                }
            } else {
                if (pezzoInArrivo != null) {
                    return false; 
                }
            }
        }
        // spostamento del pezzo
        griglia[rigaArrivo][colArrivo] = pezzoDaMuovere; 
        griglia[rigaPartenza][colPartenza] = null;           

        return true; 
    }
    
    public void stampa() {
        System.out.println("\n  a  b  c  d  e  f  g  h");
        for (int r = 0; r < 8; r++) {
            System.out.print((8 - r) + " "); // Stampa il numero della riga (8, 7, 6...)
            
            for (int c = 0; c < 8; c++) {
                Pezzo p = griglia[r][c];
                if (p == null) {
                    System.out.print("[ ]"); // Casella vuota
                } else {
                    // Prende l'iniziale del pezzo (es. 'T' per Torre, 'P' per Pedone)
                    String iniziale = p.getNome().substring(0, 1);
                    
                    // Se è nero in minuscolo per distinguerlo
                    if (!p.isBianco) {
                        iniziale = iniziale.toLowerCase();
                    }
                    System.out.print("[" + iniziale + "]");
                }
            }
            System.out.println(" " + (8 - r));
        }
        System.out.println("  a  b  c  d  e  f  g  h\n");
    }
}