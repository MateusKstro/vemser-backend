import java.util.Locale;
import java.util.Scanner;

public class exercicio8 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int[][] matrizes = new int[5][4];

        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna" + (j + 1));
                matrizes[i][j] = scanner.nextInt();
            }
        }

       double alunoUm = (matrizes[0][1] * 0.6) + (matrizes[0][2] * 0.4);
       double alunoDois = (matrizes[1][1] * 0.6) + (matrizes[1][2] * 0.4);
       double alunoTres = (matrizes[2][1] * 0.6) + (matrizes[2][2] * 0.4);
       double alunoQuatro = (matrizes[3][1] * 0.6) + (matrizes[3][2] * 0.4);
       double alunoCinco = (matrizes[4][1] * 0.6) + (matrizes[4][2] * 0.4);

       if(alunoUm > alunoDois && alunoUm > alunoTres && alunoUm > alunoQuatro && alunoUm > alunoCinco){
           System.out.println("A matricula com a maior nota foi a :" + matrizes[0][0]);
       } else if (alunoDois > alunoUm && alunoDois > alunoTres && alunoDois > alunoQuatro && alunoDois > alunoCinco) {
           System.out.println("A matricula com a maior nota foi a :" + matrizes[1][0]);
       } else if (alunoTres > alunoUm && alunoTres > alunoDois && alunoTres > alunoQuatro && alunoTres > alunoCinco){
           System.out.println("A matricula com a maior nota foi a :" + matrizes[2][0]);
       } else if (alunoQuatro > alunoUm && alunoQuatro > alunoDois && alunoQuatro > alunoTres && alunoQuatro > alunoCinco){
           System.out.println("A matricula com a maior nota foi a :" + matrizes[3][0]);
       } else if (alunoCinco > alunoUm && alunoCinco > alunoDois && alunoCinco > alunoTres && alunoCinco > alunoQuatro){
           System.out.println("A matricula com a maior nota foi a :" + matrizes[4][0]);
       }

       double mediaNotaF = (matrizes [0][3] + matrizes [1][3] + matrizes[2][3] + matrizes[3][3] + matrizes[4][3]);
       mediaNotaF /= 5;

       System.out.println();
       System.out.println("A media de notas finais foi: " + mediaNotaF);


    scanner.close();
    }
}
