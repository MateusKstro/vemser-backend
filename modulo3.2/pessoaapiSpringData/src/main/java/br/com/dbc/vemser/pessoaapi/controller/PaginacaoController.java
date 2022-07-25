package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PaginacaoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/descricao")
    public Page<ContatoEntity> listContatoPaginado(Integer pagina, Integer quantidadeRegistro, @RequestParam(required = false) String descricao) {
        Sort ordencao = Sort.by("descricao");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistro);
        return contatoRepository.findContatoPaginado(descricao, pageable);
    }

    @GetMapping("/endereco-cep")
    public Page<EnderecoEntity> listEnderecoCepPaginado(Integer pagina, Integer quantidadeRegistro, @RequestParam(required = false) String cep) {
        Sort ordencao = Sort.by("cep");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistro);
        return enderecoRepository.findEnderecoCepPaginado(cep, pageable);
    }

    @GetMapping("/endereco-pais")
    public Page<EnderecoEntity> listEnderecoPaisPaginado(Integer pagina, Integer quantidadeRegistro, @RequestParam(required = false) String pais) {
        Sort ordencao = Sort.by("pais");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistro);
        return enderecoRepository.findEnderecoPaisPaginado(pais, pageable);
    }
}
