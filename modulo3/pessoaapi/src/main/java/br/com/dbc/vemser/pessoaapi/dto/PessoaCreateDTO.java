package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotEmpty
    private String nome;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    @NotEmpty
    @Size(min=11, max=11)
    private String cpf;

    @Email
    private String email;
}
