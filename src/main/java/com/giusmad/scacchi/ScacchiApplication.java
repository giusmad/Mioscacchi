package com.giusmad.scacchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class ScacchiApplication {

	public static void main(String[] args) {
		Scacchiera scacchiera = new Scacchiera();
        Game partita = new Game(scacchiera);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto a Scacchi! Scrivi le mosse in formato 'e2 e4'.");
        System.out.println("Scrivi 'quit' per uscire.");

        while (true) {
            scacchiera.stampa();

            // 1. Diciamo di chi è il turno
            if (partita.isTurnoBianco()) {
                System.out.println("Cosa fai, BIANCO?");
            } else {
                System.out.println("Cosa fai, NERO?");
            }

            // 2. Leggiamo l'input dell'utente
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("quit")) {
                System.out.println("Partita terminata. Arrivederci!");
                break; // Esce dal ciclo e chiude il gioco
            }

            // 3. Traduciamo "e2 e4" in coordinate matematiche
            try {
                String[] parti = input.split(" "); // Divide "e2" e "e4"
                String partenza = parti[0];
                String arrivo = parti[1];

                // TRADUZIONE COLONNE (Lettere in numeri: 'a'=0, 'b'=1... 'e'=4)
                int colP = partenza.charAt(0) - 'a'; 
                int colA = arrivo.charAt(0) - 'a';

                // TRADUZIONE RIGHE (Numeri visivi in indici array: '8'=0, '1'=7)
                int rigaP = 8 - Character.getNumericValue(partenza.charAt(1));
                int rigaA = 8 - Character.getNumericValue(arrivo.charAt(1));

                // 4. Mandiamo la mossa tradotta all'Arbitro
                boolean successo = partita.giocaMossa(rigaP, colP, rigaA, colA);

                if (!successo) {
                    System.out.println("⚠️ MOSSA NON VALIDA! Riprova.");
                }

            } catch (Exception e) {
                // Se l'utente scrive "ciao" invece di "e2 e4", evitiamo che il gioco crasci
                System.out.println("⚠️ Formato errato. Usa il formato 'e2 e4'.");
            }
        }
        
        scanner.close();
	}

}
