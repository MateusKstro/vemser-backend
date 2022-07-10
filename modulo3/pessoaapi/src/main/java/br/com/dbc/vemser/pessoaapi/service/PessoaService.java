package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoaCriado){
        log.info("Criando pessoa");
        Pessoa pessoa = objectMapper.convertValue(pessoaCriado, Pessoa.class);
        return objectMapper.convertValue(pessoaRepository.create(pessoa),PessoaDTO.class);
    }

    public List<PessoaDTO> list(){
        log.info("Listando Pessoas");
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("atualizando pessoa");
        Pessoa pessoaRecuperada = findById(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return objectMapper.convertValue(pessoaAtualizar, PessoaDTO.class);
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = findById(id);
        pessoaRepository.list().remove(pessoaRecuperada);
    }

    public List<PessoaDTO> listByName(String nome) {
        log.info("Buscar por nome");
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public Pessoa findById (Integer idPessoa)throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        return pessoaRecuperada;
    }
}
