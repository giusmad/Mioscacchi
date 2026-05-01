package com.giusmad.scacchi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class ScacchiApplication {

    public static void main(String[] args) {
    
        Scacchiera scacchiera = new Scacchiera();
        Game partita = new Game(scacchiera);
        Scanner scanner = new Scanner(System.in);
        System.out.println("♟️ BENVENUTO A SCACCHI!");
        System.out.println("Scrivi le mosse nel formato standard (es: 'e2 e4').");
        System.out.println("Scrivi 'quit' in qualsiasi momento per uscire.");

        while (true) {
            scacchiera.stampa();

            if (partita.isTurnoBianco()) {
                System.out.println("Cosa fai, BIANCO?");
            } else {
                System.out.println("Cosa fai, NERO?");
            }

            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("quit")) {
                System.out.println("Partita terminata. Arrivederci!");
                break; 
            }

            try {
                // Divido l'input dell'utente usando lo spazio ("e2 e4" -> "e2" e "e4")
                String[] parti = input.split(" "); 
                String partenza = parti[0]; 
                String arrivo = parti[1];   

                int colP = partenza.charAt(0) - 'a'; 
                int colA = arrivo.charAt(0) - 'a';

                // Capovolgo i numeri negli indici della matrice (es: riga visiva '8' diventa indice 0)
                int rigaP = 8 - Character.getNumericValue(partenza.charAt(1));
                int rigaA = 8 - Character.getNumericValue(arrivo.charAt(1));

                boolean successo = partita.giocaMossa(rigaP, colP, rigaA, colA);

                if (!successo) {
                    System.out.println("⚠️ MOSSA NON VALIDA! La mossa non rispetta le regole. Riprova.");
                } else {
                    System.out.println("✅ MOSSA ESEGUITA CON SUCCESSO!");
                }

            } catch (Exception e) {
                // Se l'utente scrive male (es. "ciao" o "e2e4" senza spazio)
                System.out.println("⚠️ Formato errato. Ricorda di usare una lettera e un numero, separati da spazio (es. 'e2 e4').");
            }
        }
        
        scanner.close();
    }
}