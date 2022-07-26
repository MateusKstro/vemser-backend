package homeworkDatas1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DatasEx1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        // -------homework1

        System.out.println("Infome sua data de nascimento: ");
        LocalDate dataAniversario = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataAtual = LocalDate.now();

        if(dataAniversario.withYear(dataAtual.getYear()).isAfter(dataAtual)){
            Period period = Period.between(dataAtual, dataAniversario.withYear(dataAtual.getYear()));
            System.out.println("Faltam " + period.getDays() + " dias e " + period.getMonths() + " meses para seu próximo aniversario!");
        } else {
            Period period = Period.between(dataAtual, dataAniversario.withYear(dataAtual.getYear() + 1));
            System.out.println("Faltam " + period.getDays() + " dias e " + period.getMonths() + " meses para seu próximo aniversario!");
        }

    }

}
