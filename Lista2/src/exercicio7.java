import java.sql.SQLOutput;
import java.util.Scanner;

public class exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[4][4];
        int maiorQ10 = 0;

        for(int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1));
                matriz[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                if(matriz[i][j] >= 10){
                    maiorQ10++;
                    System.out.println("Valor maior que dez: " + matriz[i][j] + " no index [" + i + "," + j + "] da matriz");
                }
            }
        }
        if (maiorQ10 == 1){
            System.out.println("Ao todo é " + maiorQ10 + " valor que dez");
        } else {
            System.out.println("Ao todo são " + maiorQ10 + " maiores que dez");
        }
     scanner.close();
    }
}
