import java.util.Scanner;

public class exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um numero: ");
        int numeroEscolhido = scanner.nextInt();


        int advNumero;
        do {
            System.out.println("Tente adivinha o numero: ");
            advNumero = scanner.nextInt();
            scanner.nextLine();
            if (advNumero > numeroEscolhido) {
                System.out.println("O numero a ser encontrado e menor do que voce digitou");
            } else if (advNumero < numeroEscolhido){
                System.out.println("O numero a ser encontrado e maior do que voce digitou");
            } else {
                advNumero = numeroEscolhido;
            }
        } while (advNumero != numeroEscolhido);
        System.out.println("VOCE ACERTOU!!!");

    }
}
