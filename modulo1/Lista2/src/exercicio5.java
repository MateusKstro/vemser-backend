import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vetores = new int[20];

        for(int i = 0; i < vetores.length;i++){
            System.out.println("Digite um numero: " + (i+1));
            vetores[i] = scanner.nextInt();
        }

        for(int i = vetores.length - 1; i >= 0; i--){
            System.out.println(vetores[i]);
        }
    }
}
