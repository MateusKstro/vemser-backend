import java.util.Locale;
import java.util.Scanner;

public class exercicio8 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int[][] vetores = new int[5][4];

        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna" + (j + 1));
                vetores[i][j] = scanner.nextInt();
            }
        }

       double alunoUm = (vetores[0][1] * 0.6) + (vetores[0][2] * 0.4);
       double alunoDois = (vetores[1][1] * 0.6) + (vetores[1][2] * 0.4);
       double alunoTres = (vetores[2][1] * 0.6) + (vetores[2][2] * 0.4);
       double alunoQuatro = (vetores[3][1] * 0.6) + (vetores[3][2] * 0.4);
       double alunoCinco = (vetores[4][1] * 0.6) + (vetores[4][2] * 0.4);

       if(alunoUm > alunoDois && alunoUm > alunoTres && alunoUm > alunoQuatro && alunoUm > alunoCinco){
           System.out.println("A matricula com a maior nota foi a :" + vetores[0][0]);
       } else if (alunoDois > alunoUm && alunoDois > alunoTres && alunoDois > alunoQuatro && alunoDois > alunoCinco) {
           System.out.println("A matricula com a maior nota foi a :" + vetores[1][0]);
       } else if (alunoTres > alunoUm && alunoTres > alunoDois && alunoTres > alunoQuatro && alunoTres > alunoCinco){
           System.out.println("A matricula com a maior nota foi a :" + vetores[2][0]);
       } else if (alunoQuatro > alunoUm && alunoQuatro > alunoDois && alunoQuatro > alunoTres && alunoQuatro > alunoCinco){
           System.out.println("A matricula com a maior nota foi a :" + vetores[3][0]);
       } else if (alunoCinco > alunoUm && alunoCinco > alunoDois && alunoCinco > alunoTres && alunoCinco > alunoQuatro){
           System.out.println("A matricula com a maior nota foi a :" + vetores[4][0]);
       }

       double mediaNotaF = (vetores [0][3] + vetores [1][3] + vetores[2][3] + vetores[3][3] + vetores[4][3]);
       mediaNotaF /= 5;

       System.out.println();
       System.out.println("A media de notas finais foi: " + mediaNotaF);


    scanner.close();
    }
}
