package veiculoprodutorconsumidor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import veiculoprodutorconsumidor.dto.SensorVeiculoCreateDTO;
import veiculoprodutorconsumidor.service.ProdutorService;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void sendSensores(@RequestBody SensorVeiculoCreateDTO sensorVeiculoCreateDTO) throws JsonProcessingException{
        produtorService.sendSensores(sensorVeiculoCreateDTO);
    }
}
