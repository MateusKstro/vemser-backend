package veiculoprodutorconsumidor.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;
@Data
@Document(collection = "sensor_veiculo")
public class SensorVeiculoEntity {

    @Id
    private String id;

    private LocalDateTime dataLeitura;

    private Double velocidade;

    private Integer rotacao;

    private boolean sensorFrenagem;
}
