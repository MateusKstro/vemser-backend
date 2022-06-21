import java.util.Locale;
import java.util.Scanner;


public class Exercicio5 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quanto vale a sua hora?");
        double valorHora = scanner.nextDouble();

        System.out.println("Você trabalhou quantas horas?");
        double horasTrabalhadas = scanner.nextDouble();

        System.out.println("Você trabalhou: " + horasTrabalhadas + " normais");

        double valorHoraNormais = valorHora * horasTrabalhadas;
        System.out.printf("E vai receber um total de: %.2f%n", valorHoraNormais, "R$.");

        System.out.println("Quantas horas extras de 50%?");
        double horaExtra50 = scanner.nextDouble();

        double valorExtra50 = valorHora * horaExtra50 * 1.5;

        System.out.println("Você trabalhou: " + horaExtra50 + " horas extras de 50% e vai receber: " + valorExtra50 + "R$.");

        System.out.println("Quantas horas extras de 100%?");
        double horaExtra100 = scanner.nextDouble();

        double valorExtra100 = valorHora * horaExtra100 * 2;

        System.out.println("Você trabalhou: " + horaExtra100 + " horas extras de 100% e vai receber: " + valorExtra100 + "R$.");

        double salarioBruto = valorHoraNormais + valorExtra50 + valorExtra100;

        System.out.printf("Seu bruto é de: %.2f%n", salarioBruto,"R$.");

        scanner.close();
    }
}
