import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContoCorrente contoStandard = new ContoCorrente("Mario Rossi", 1000.0);
        ContoOnLine contoOnline = new ContoOnLine("Luigi Bianchi", 1500.0, 300.0);

        System.out.println("--- Gestione Conto Corrente Standard ---");
        effettuaPrelievi(scanner, contoStandard);

        System.out.println("\n--- Gestione Conto OnLine ---");
        effettuaPrelievi(scanner, contoOnline);

        scanner.close();
    }

    public static void effettuaPrelievi(Scanner scanner, ContoCorrente conto) {
        while (true) {
            System.out.print("Inserisci l'importo da prelevare (o 0 per terminare): ");
            try {
                double importo = scanner.nextDouble();
                if (importo == 0) {
                    break;
                }
                conto.preleva(importo);
                System.out.println("Prelievo effettuato. Saldo attuale: " + conto.restituisciSaldo());
            } catch (BancaException e) {
                System.err.println("Errore durante il prelievo: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.err.println("Errore: inserisci un importo numerico valido.");
                scanner.next();
            }
        }
        System.out.println("Saldo finale: " + conto.restituisciSaldo());
    }
}
