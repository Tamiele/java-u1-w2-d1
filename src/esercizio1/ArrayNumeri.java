import esercizio1.IndiceErrato;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;

public class ArrayNumeri {
    private final static Logger LOGGER = LoggerFactory.getLogger(ArrayNumeri.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numeri = new int[5];

        Random random = new Random();
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = random.nextInt(10) + 1;
            System.out.println(numeri[i]);
        }

        while (true) {
            System.out.println("Inserisci il numero da aggiungere (metti 0 per uscire):");
            int numeroAggiunto = scanner.nextInt();

            // Condizione di uscita
            if (numeroAggiunto == 0) {
                System.out.println("Uscita dal programma.");
                break;
            }

            System.out.println("Inserisci l'indice in cui lo vuoi sostituire:");
            int indice = scanner.nextInt();

            try {
                // Controllo con metodo che lancia un'eccezione
                verificaIndice(indice, numeri.length);
                numeri[indice] = numeroAggiunto;

                System.out.println("Lista aggiornata:");
                for (int i = 0; i < numeri.length; i++) {
                    System.out.println(numeri[i]);
                }
            } catch (IndiceErrato e) {
                LOGGER.error(e.getMessage());
                System.out.println("Errore: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Metodo per verificare la validità dell'indice
    private static void verificaIndice(int indice, int lunghezzaArray) {
        if (indice < 0 || indice >= lunghezzaArray) {
            throw new IndiceErrato("Indice " + indice + " non valido. Deve essere compreso tra 0 e " + (lunghezzaArray - 1));
        }
    }
}
