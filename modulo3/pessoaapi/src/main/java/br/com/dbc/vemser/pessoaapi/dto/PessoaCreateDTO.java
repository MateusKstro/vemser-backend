package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
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
}
