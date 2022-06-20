import java.util.Locale;
import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos anos você tem? ");
        int anos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Quantos meses?");
        int meses = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Quantos dias?");
        int dias = scanner.nextInt();

        System.out.println("Você já viveu um total de " + (365*anos + meses*30 + dias) + " dias!!");

    scanner.close();
    }
}
