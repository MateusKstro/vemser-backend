package chatkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemDTO {
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;
}
