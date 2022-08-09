package veiculoprodutorconsumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import veiculoprodutorconsumidor.dto.SensorVeiculoDTO;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private final SensorVeiculoService sensorVeiculoService;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "groupSensorVeiculos",
            containerFactory = "listenerContainerFactory")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        SensorVeiculoDTO sensorVeiculoDTO = objectMapper.readValue(message, SensorVeiculoDTO.class);
        sensorVeiculoService.saveSensor(sensorVeiculoDTO);
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);

    }
}
