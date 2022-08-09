package veiculoprodutorconsumidor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import veiculoprodutorconsumidor.dto.SensorVeiculoDTO;
import veiculoprodutorconsumidor.entity.SensorVeiculoEntity;
import veiculoprodutorconsumidor.repository.SensorVeiculoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorVeiculoService {

    private final SensorVeiculoRepository sensorVeiculoRepository;
    private final ObjectMapper objectMapper;

    public void saveSensor(SensorVeiculoDTO sensorVeiculoDTO){
        sensorVeiculoRepository.save(objectMapper.convertValue(sensorVeiculoDTO, SensorVeiculoEntity.class));
    }

    public List<SensorVeiculoDTO> getAll(){
        return sensorVeiculoRepository.findAll().stream()
                .map(sensorVeiculoEntity -> objectMapper.convertValue(sensorVeiculoEntity, SensorVeiculoDTO.class))
                .toList();
    }

    public Long quantidadeLeituras(){
        return sensorVeiculoRepository.count();
    }

    public Double velocidadeMedia(){
        Double velocidade = sensorVeiculoRepository.findVelocidadeTotal();
        Long quantidade = sensorVeiculoRepository.count();
        return velocidade/quantidade;
    }

    public Double rotacaoMedia(){
        Double rotacao = sensorVeiculoRepository.findRotacaoTotal();
        Long quantidade = sensorVeiculoRepository.count();
        return rotacao/quantidade;
    }
}
