import java.util.Scanner;

public class exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numeros = new int[3];


        for (int i = 0; i < numeros.length; i++){
            System.out.println("Digite o valor " + i + ":");
            numeros[i] = scanner.nextInt();
            scanner.nextLine();
            }
        if (numeros[0] < numeros [1] && numeros [0] < numeros[2]) {
            System.out.println("Menor numero é:" + numeros[0]);
        } else if (numeros[1] < numeros [0] && numeros [1] < numeros[2]){
            System.out.println("Menor numero é: " + numeros[1]);
        } else {
            System.out.println("Menor numero é: " + numeros[2]);
        }


        scanner.close();
    }
}
