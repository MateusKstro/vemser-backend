import java.util.Locale;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valor total consumido: R$");
        double valorTotal = scanner.nextDouble();

        System.out.println("Valor pago pelo cliente: R$");
        double valorCliente = scanner.nextDouble();

        if(valorCliente < valorTotal){
            System.out.println("O valor pago deve ser maior ou igual ao consumido");
        }
        else{
            double troco = valorCliente - valorTotal;
            System.out.println("O troco do cliente é de R$" + troco);
        }
    scanner.close();
    }
}
