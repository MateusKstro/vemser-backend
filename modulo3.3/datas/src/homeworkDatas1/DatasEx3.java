package homeworkDatas1;

import java.time.LocalDateTime;
import java.time.Period;

public class DatasEx3 {

    public static void main(String[] args) {

        LocalDateTime dataAtual3 = LocalDateTime.now();
        LocalDateTime dataMaisQuinzeDiasEDezHoras = dataAtual3.plusDays(15).plusHours(10);
        Period periodo = Period.between(dataAtual3.toLocalDate(), dataMaisQuinzeDiasEDezHoras.toLocalDate());

        System.out.println("Dia da semana: " + dataMaisQuinzeDiasEDezHoras.getDayOfWeek() + "\n" +
                "Dia do ano (corrido): " + dataMaisQuinzeDiasEDezHoras.getDayOfYear());

    }
}
