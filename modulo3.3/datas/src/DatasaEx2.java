import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DatasaEx2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe duas datas: ");
        LocalDate primeiraData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate segundaData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Period diferencaDatas = Period.between(primeiraData, segundaData);
        System.out.println("Diferença de " + diferencaDatas.getDays() + " dias, " + diferencaDatas.getMonths() + " meses e " + diferencaDatas.getYears() + " anos.");
    }
}
