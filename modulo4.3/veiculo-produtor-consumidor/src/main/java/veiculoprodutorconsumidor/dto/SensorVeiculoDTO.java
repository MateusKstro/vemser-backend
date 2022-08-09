package veiculoprodutorconsumidor.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorVeiculoDTO {

    private LocalDateTime dataLeitura;

    private Double velocidade;

    private Integer rotacao;

    private boolean sensorFrenagem;
}
