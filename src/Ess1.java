import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Ess1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int[] randomNumberArray = new int[5];

        for (int i = 0; i < randomNumberArray.length; i++) {
            randomNumberArray[i] = random.nextInt(10) + 1;
        }
        System.out.println("Array di base: " + Arrays.toString(randomNumberArray));

        int posizione;

        do {
            try {
                System.out.println("In che posizione vuoi inserire il nuovo numero ? (1 - 5), se vuoi uscire inserisci 0");
                posizione = scan.nextInt();

                if (posizione == 0) {
                    break;
                }

                if (posizione >= 1 && posizione < randomNumberArray.length + 1) {
                    System.out.println("inserisci un nuovo numero tra 1 e 10");
                    int newNumber = scan.nextInt();

                    if (newNumber > 0) {
                        randomNumberArray[posizione - 1] = newNumber;
                        System.out.println("Nuovo Array: " + Arrays.toString(randomNumberArray));
                    } else {
                        System.out.println("Errore: inserisci un numero positivo intero tra 1 e 10");
                    }
                } else {
                    System.out.println("Errore: Posizione Non Valida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Errore: Inserisci un numero valido tra 1 e 10");
                scan.nextLine();
                posizione = -1;
            }
        } while (posizione != 0);
    scan.close();
    }
}
