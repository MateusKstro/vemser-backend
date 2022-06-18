import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a palavra para traduzir: ");
        String palavra = scanner.nextLine();

        switch (palavra){
            case "cachorro" ->{
                System.out.println("Dog");
            }
            case "dog" ->{
                System.out.println("Cachorro");
            }
            case "tempo" ->{
                System.out.println("Time");
            }
            case "time" ->{
                System.out.println("Tempo");
            }
            case "amor" ->{
                System.out.println("Love");
            }
            case "love" ->{
                System.out.println("Amor");
            }
            case "cidade" ->{
                System.out.println("City");
            }
            case "city" ->{
                System.out.println("Cidade");
            }
            case "feliz" ->{
                System.out.println("Happy");
            }
            case "happy" ->{
                System.out.println("Feliz");
            }
            case "triste" ->{
                System.out.println("Sad");
            }
            case "sad" ->{
                System.out.println("Triste");
            }
            case "Deveria" ->{
                System.out.println("Shoud");
            }
            case "shoud" ->{
                System.out.println("Deveria");
            }
            case "poderia" ->{
                System.out.println("Could");
            }
            case "could" ->{
                System.out.println("Poderia");
            }
            default ->{
                System.out.println("Essa palavra não é valida.");
            }
        }
    }
}
