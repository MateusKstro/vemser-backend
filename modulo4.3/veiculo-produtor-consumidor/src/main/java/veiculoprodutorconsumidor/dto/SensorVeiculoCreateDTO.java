package veiculoprodutorconsumidor.dto;

import lombok.Data;

@Data
public class SensorVeiculoCreateDTO {

    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
