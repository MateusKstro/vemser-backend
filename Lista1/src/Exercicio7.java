import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valor de A: ");
        int A = scanner.nextInt();

        System.out.println("Valor de B: ");
        int B = scanner.nextInt();

        int trocaDeValores = A;
        A = B;
        B = trocaDeValores;

        System.out.println("Valor de A = " + A + ", Valor de B = " + B);

    }
}
