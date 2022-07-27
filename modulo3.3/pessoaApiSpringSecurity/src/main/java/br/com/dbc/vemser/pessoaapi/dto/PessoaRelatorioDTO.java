package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRelatorioDTO {

    private Integer idPessoa;
    private String nome;
    private String email;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String nomePet;
}
