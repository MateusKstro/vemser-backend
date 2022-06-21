import java.util.Locale;
import java.util.Scanner;

public class exercicio8 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int[][] matrizes = new int[5][4];
        int maiorNotaF = 0;
        int matriculaMaiorNotaFinal = 0;
        double mediaNotaF = 0;


        for(int i = 0; i < matrizes.length; i++) {
            for (int j = 0; j < matrizes.length; j++) {
                switch(j) {
                    case 0 -> {
                        System.out.println("Informe a matricula: " + (i + 1));
                        matrizes[i][j] = scanner.nextInt();
                    }
                    case 1 -> {
                        System.out.println("Informe a média das provas: ");
                        matrizes[i][j] = scanner.nextInt();
                    }
                    case 2 -> {
                        System.out.println("Informe a média dos trabalhaos: ");
                        matrizes[i][j] = scanner.nextInt();
                        mediaNotaF += (matrizes[i][1] * 0.6) + (matrizes[i][2] * 0.4);
                        matrizes[i][j + 1] = (int)((matrizes[i][1] + 0.6) + (matrizes[i][2] * 0.4));
                        if(matrizes[i][j + 1] > maiorNotaF){
                            matriculaMaiorNotaFinal = matrizes[i][0];
                            maiorNotaF = matrizes[i][j +1];
                        }
                    }
                }
            }
        }

        mediaNotaF /= matrizes.length;
        System.out.println("matricula com maior nota final: " + matriculaMaiorNotaFinal);
        System.out.println("media notas finais: " + mediaNotaF);
    scanner.close();
    }
}
