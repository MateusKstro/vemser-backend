import java.util.Scanner;

public class exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vetores [] = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Qual numero quer buscar?");
        int buscarNumero = scanner.nextInt();
        boolean filtro = true;

        for (int i = 0; i < vetores.length; i++){
            if(vetores[i] == buscarNumero){
                System.out.println("Existe esse numero na posição :" + i + " do vetor");
                filtro = false;
            }
        }
        if(filtro){
            System.out.println("Valor nao existe!");
        }
    scanner.close();
    }
}
