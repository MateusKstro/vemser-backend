import java.util.Scanner;

public class exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numeros = new int[3];
        int posicaoMenor = 0;
        int con = Integer.MAX_VALUE;

        for (int i = 0; i < numeros.length; i++){
            System.out.println("Digite o valor " + i + ":");
            numeros[i] = scanner.nextInt();
            scanner.nextLine();
        if (numeros[i] < con) {
            posicaoMenor = i;
            con = numeros[1];
            }
        }

        System.out.println("A posição do menor numero é: " + posicaoMenor);
        scanner.close();
    }
}
