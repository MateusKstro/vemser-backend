package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaCompletaDTO extends PessoaDTO{

    private List<EnderecoDTO> enderecos;

    private List<ContatoDTO> contatos;

    private PetDTO pets;
}
