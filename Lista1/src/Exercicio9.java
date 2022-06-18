import java.util.Locale;
import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos você tem? ");
        int anos = scanner.nextInt();
        int meses = anos * 12;
        int dias  = anos * 365;

        System.out.println("Você já viveu um total de " + dias + " dias!!");
    }
}
