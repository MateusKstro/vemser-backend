import java.util.Locale;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a nota: ");
        Double nota = scanner.nextDouble();

        if (nota >= 0 && nota <= 5) {
            System.out.println("aluno reprovado.");
        }
        else if (nota > 5 && nota < 7){
            System.out.println("em exame.");
        }
        else if (nota >= 7 && nota <= 10){
            System.out.println("aluno aprovado.");
        }
        else {
            System.out.println("essa nota é invalida.");
        }
    }
}
