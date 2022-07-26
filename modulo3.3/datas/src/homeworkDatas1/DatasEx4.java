package homeworkDatas1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class DatasEx4 {

    public static void main(String[] args) {

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
