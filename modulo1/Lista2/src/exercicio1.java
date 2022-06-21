import java.util.Locale;
import java.util.Scanner;

public class exercicio1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o produto?");
        String produto = scanner.nextLine();

        System.out.println("Qual o valor do " + produto + "?");
        double valorProduto = scanner.nextDouble();


        for(int i = 1; i <= 10; i++){
            double porcentagem = (5.00 * i)/100.00;
            double precoFinal = (valorProduto - (valorProduto*porcentagem));
            System.out.println(i + " x R$ " + String.format("%.2f",(precoFinal)) + " = R$ " + String.format("%.2f",(precoFinal*i)));
        }

        scanner.close();
    }
}
