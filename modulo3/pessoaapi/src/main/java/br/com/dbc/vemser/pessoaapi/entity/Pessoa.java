package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {

    private Integer idPessoa;

    @NotEmpty
    private String nome;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    @NotEmpty
    @Size(min=11, max=11)
    private String cpf;

}
