package chatkafka.service;


import chatkafka.dto.MensagemDTO;
import chatkafka.enums.Chats;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {

    @Value("${kafka.client-id}")
    private String clientId;

    private static final LocalDateTime DATA_ATUAL = LocalDateTime.now();

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensagem(String mensagem, List<Chats> chatsList) throws JsonProcessingException{
        MensagemDTO mensagemDTO =  MensagemDTO.builder()
                .usuario(clientId)
                .mensagem(mensagem)
                .dataCriacao(DATA_ATUAL).build();
        String payload = objectMapper.writeValueAsString(mensagemDTO);
        for(Chats topico : chatsList){
            send(payload, topico.getChat());
        }
    }

    private void send (String mensagem, String topico){

        MessageBuilder<String> messageBuilder = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        Message<String> stringMessage = messageBuilder
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(stringMessage);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info("Log enviado para o kafka com o texto: {}, e para o chat: {}",mensagem, topico);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Error ao publicar duvida no kafka com a mensagem: {}", mensagem, ex);
            }
        });
    }
}
