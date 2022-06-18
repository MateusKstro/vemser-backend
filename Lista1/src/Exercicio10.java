import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Número de votos em branco: ");
        int votoBranco = scanner.nextInt();
        System.out.println("Número de votos nulos:");
        int votoNulo = scanner.nextInt();
        System.out.println("Número de votos válidos:");
        int votoValido = scanner.nextInt();

        int totalEleitores = votoBranco + votoNulo + votoValido;

        System.out.println("Total de eleitores: " + totalEleitores);

        if(votoBranco == 0){
            System.out.println("Não houve votos em branco.");
        }
        else {
            System.out.println("Total de votos brancos foi de: " + votoBranco);
            System.out.println("Percentual de votos em branco:" + (votoBranco * 100)/totalEleitores + "%");
        }
        if (votoNulo == 0){
            System.out.println("Não houve votos nulos.");
        }
        else {
            System.out.println("Total de votos nulos foi de: " + votoNulo);
            System.out.println("Percentual de votos em branco:" + (votoNulo * 100)/totalEleitores + "%");
        }
        if (votoValido == 0){
            System.out.println("Não houve votos válidos.");
        }
        else {
            System.out.println("Total de votos válidos foi de: " + votoValido);
            System.out.println("Percentual de votos válidos:" + (votoValido * 100)/totalEleitores + "%");
        }
    }
}
