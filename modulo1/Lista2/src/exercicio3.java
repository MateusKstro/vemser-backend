import java.util.Locale;
import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int jogadoresCadastrados = 0;
        double maiorAltura  = 0;
        double mediaAlturas = 0;
        int maisVelho = 0;
        double maisPesado = 0;

        System.out.println("Digite o nome do jogador: ");
        String nomeJogador = scanner.nextLine();

        while (!nomeJogador.equals("sair")){

            System.out.println("Digite a altura do jogador: ");
            double altura = scanner.nextDouble();
            scanner.nextLine();
            mediaAlturas += altura;
            if (altura > maiorAltura){
                maiorAltura = altura;
            }

            System.out.println("Digite a idade do jogador: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            if (idade > maisVelho){
                maisVelho = idade;
            }

            System.out.println("Digite o peso do jogador :");
            double peso = scanner.nextDouble();
            scanner.nextLine();
            if (peso > maisPesado){
                maisPesado = peso;
            }

            jogadoresCadastrados++;

            System.out.println("Digite o nome do jogador: ");
            nomeJogador = scanner.nextLine();

        }
        mediaAlturas /= jogadoresCadastrados;

        System.out.println("Quantidade de jogadores: " + jogadoresCadastrados);
        System.out.println("Altura do maior jogador: " + maiorAltura);
        System.out.println("Jogador mais velho: " + maisVelho + " anos");
        System.out.println("Jogador mais pesado " + maisPesado + " Kg");
        System.out.println("Media da altura dos jogadores: " + String.format("%.2f", mediaAlturas) + "metros");

        scanner.close();
    }
}
