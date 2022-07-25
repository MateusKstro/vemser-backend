import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Datas {

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
        System.out.println();
        System.out.println("------------------------------------------------------------------");

        // -------homework2

        System.out.println("Informe duas datas: ");
        LocalDate primeiraData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate segundaData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Period diferencaDatas = Period.between(primeiraData, segundaData);
        System.out.println("Diferença de " + diferencaDatas.getDays() + " dias, " + diferencaDatas.getMonths() + " meses e " + diferencaDatas.getYears() + " anos.");
        System.out.println();
        System.out.println("------------------------------------------------------------------");

        // -------homework3

        LocalDateTime dataAtual3 = LocalDateTime.now();
        LocalDateTime dataMaisQuinzeDiasEDezHoras = dataAtual3.plusDays(15).plusHours(10);
        Period periodo = Period.between(dataAtual3.toLocalDate(), dataMaisQuinzeDiasEDezHoras.toLocalDate());

        System.out.println("Dia da semana: " + dataMaisQuinzeDiasEDezHoras.getDayOfWeek() + "\n" +
                "Dia do ano (corrido): " + dataMaisQuinzeDiasEDezHoras.getDayOfYear());

        System.out.println();
        System.out.println("------------------------------------------------------------------");

        // -------homework4

        LocalDateTime horaAtual = LocalDateTime.now().atZone(ZoneId.of("UTC-03:00")).toLocalDateTime();
        LocalDateTime horarioShow = LocalDateTime.of(2024, 9, 14, 18, 30, 0).atZone(ZoneId.of("UTC+01:00")).withZoneSameInstant(ZoneId.of("UTC-03:00")).toLocalDateTime();

        LocalDateTime horarioParaCalular = LocalDateTime.from(horaAtual);

        long diferencaAnos = ChronoUnit.YEARS.between(horarioParaCalular, horarioShow);
        horarioParaCalular = horarioParaCalular.plusYears(diferencaAnos);
        long diferencaMeses = ChronoUnit.MONTHS.between(horarioParaCalular, horarioShow);
        horarioParaCalular = horarioParaCalular.plusMonths(diferencaMeses);
        long diferencaDias = ChronoUnit.DAYS.between(horarioParaCalular, horarioShow);
        horarioParaCalular = horarioParaCalular.plusDays(diferencaDias);
        long diferencaHoras = ChronoUnit.HOURS.between(horarioParaCalular, horarioShow);
        horarioParaCalular = horarioParaCalular.plusHours(diferencaHoras);
        long diferencaMinutos = ChronoUnit.MINUTES.between(horarioParaCalular, horarioShow);
        horarioParaCalular = horarioParaCalular.plusMinutes(diferencaMinutos);
        long diferencaSegundos = ChronoUnit.SECONDS.between(horarioParaCalular, horarioShow);

        System.out.println("Faltam :"
                + "\nAnos: " + diferencaAnos
                + "\nMeses: " + diferencaMeses
                + "\nDias: " + diferencaDias
                + "\nHoras: " + diferencaHoras
                + "\nMinutos: " + diferencaMinutos
                + "\nSegundos: " + diferencaSegundos);

    }

}
