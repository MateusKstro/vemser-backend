package chatkafka.controller;

import chatkafka.enums.Chats;
import chatkafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/porducer")
@RequiredArgsConstructor
public class ProdutorController {

    @Autowired
    private ProdutorService produtorService;

    @PostMapping("/enviar-mensagem")
    public void enviarMensagem(@RequestParam String mensagem,
                               @RequestParam List<Chats> chatsList) throws JsonProcessingException {
        produtorService.enviarMensagem(mensagem, chatsList);
    }

}
