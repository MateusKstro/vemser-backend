import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um dos estados abaixo: ");
        System.out.println("Digite 1 para RS.");
        System.out.println("Digite 2 para SC.");
        System.out.println("Digite 3 para BA.");
        System.out.print("Digite sua escolha:");
        int escolha = scanner.nextInt();

        switch(escolha){
            case 1 -> {
                System.out.println("Escolha entre essas duas cidades: 1-Porto Alegre, 2-Gramado.");
                int cidadeRS = scanner.nextInt();
                switch (cidadeRS) {
                    case 1 -> {
                        System.out.println("Porto Alegre tem 4,4 milhões de habitantes e sua principal festa é a Semana Farroupilha.");
                    }
                    case 2 -> {
                        System.out.println("Gramado tem tem 36.555 mil habitantes e sua principal festa é o Festival de Gramado.");
                    }
                    default ->{
                        System.out.println("Número inválido.");
                    }
                }
            }
            case 2 -> {
                System.out.println("Escolha entre essas duas cidades: 1-Florianópolis, 2-Balneário Camboriú.");
                int cidadesSC = scanner.nextInt();
                switch (cidadesSC){
                    case 1 -> {
                        System.out.println("Florianópolis tem 508.826 mil habitantes e sua principal praia é Jurerê.");
                    }
                    case 2 -> {
                        System.out.println("Balneário Camboriú tem 145.796 mil habitantes e sua principal praia é Praia Central.");
                    }
                    default -> {
                        System.out.println("Número inválido.");
                    }
                }
            }
            case 3 -> {
                System.out.println("Escolha entre essas duas cidade: 1-Salvador, 2-Feira de Santana.");
                int cidadesBA = scanner.nextInt();
                switch (cidadesBA){
                    case 1 -> {
                        System.out.println("Salvador tem 2,9 milhões de habitantes e sua principal festa é o Carnaval.");
                    }
                    case 2 -> {
                        System.out.println("Feira de Santana tem 619.609 mil de habitantes e sua principal festa é a Festa do Vaqueiro");
                    }
                    default -> {
                        System.out.println("Número inválido.");
                    }
                }
            }
            default -> {
                System.out.println("Número inválido.");
            }
        }
     }
}
