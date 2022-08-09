package veiculoprodutorconsumidor.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import veiculoprodutorconsumidor.dto.SensorVeiculoDTO;
import veiculoprodutorconsumidor.service.SensorVeiculoService;

import java.util.List;

@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor
public class ConsumerController {

    private final SensorVeiculoService sensorVeiculoService;

    @GetMapping
    public List<SensorVeiculoDTO> getAll(){
        return sensorVeiculoService.getAll();
    }

    @GetMapping("/quantidade")
    public String getQuantidade(){
        Long quantidade = sensorVeiculoService.quantidadeLeituras();
        return "Quantidade de leituras: " + quantidade;
    }

    @GetMapping("/velociade-media")
    public Double getVelocidadeMedia(){
        return sensorVeiculoService.velocidadeMedia();
    }

    @GetMapping("/rotacao-media")
    public Double getRotacaoMedia(){
        return sensorVeiculoService.rotacaoMedia();
    }
}
