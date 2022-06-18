import java.util.Locale;
import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Diga a altura do retângulo:");
        double altura = scanner.nextDouble();

        System.out.println("Diga a base do retângulo:");
        double base = scanner.nextDouble();

        double area = base * altura;

        System.out.printf("A área do retângulo é : %.2f%n", area);
    }
}
