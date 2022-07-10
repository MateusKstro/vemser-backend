package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull
    private TipoEndereco tipo;
    @NotEmpty
    @Size(max = 250)
    private String logradouro;
    @NotNull
    private Integer numero;
    private String complemento;
    @NotEmpty
    @Size(max = 8)
    private String cep;
    @NotBlank
    @Size (max = 250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;


}

