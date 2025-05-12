import java.util.InputMismatchException;
import java.util.Scanner;

public class Ess2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double kmPercorsi;
        double litriBenzinaConsumata;

        try {
            System.out.println("Quanti km hai percorso?");
            kmPercorsi = scan.nextDouble();

            System.out.println("Quanti litri di benzina hai consumato?");
            litriBenzinaConsumata = scan.nextDouble();

            if (litriBenzinaConsumata == 0) {
                throw new ArithmeticException("Errore: dividere per 0 non è possibile.");
            }

            double kmPerLitro = kmPercorsi / litriBenzinaConsumata;
            System.out.println("Il consumo equivale a " + kmPerLitro + " km per litro");
        } catch (InputMismatchException e) {
            System.out.println("Errore: inserisci valori numerici validi per chilometri e litri.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            scan.close();
        }
    }
}
