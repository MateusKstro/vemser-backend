package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Log
@Service
public class ContatoService {


    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<ContatoDTO> listarContatos(){
        log.info("listando contatos");
        return contatoRepository.list().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public void deletar(Integer id) throws Exception{
        log.info("chamou deletar");
        Contato contatoDeletado = findById(id);
        contatoRepository.list().remove(contatoDeletado);
    }

    public ContatoDTO criarContato(Integer id, ContatoCreateDTO contatoCriado) throws Exception {
        log.info("Criando contato");
        pessoaService.findById(id);
        contatoCriado.setIdPessoa(id);
        Contato contato = objectMapper.convertValue(contatoCriado, Contato.class);
        return objectMapper.convertValue(contatoRepository.create(id, contato), ContatoDTO.class);
    }

    public List<ContatoDTO> buscarContatoPorIdPessoa(Integer id) throws Exception{
        log.info("Buscando por idPessoa");
        verificarIdPessoa(id);
        return contatoRepository.list().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public void verificarIdPessoa(Integer idPessoa) throws Exception{
        pessoaService.findById(idPessoa);
    }

    public ContatoDTO atualizarContato(Integer id, ContatoCreateDTO contatoAtualizado) throws Exception {
        log.info("Atualizando contato");
        Contato contatoRecuperado = findById(id);
        contatoRecuperado.setIdPessoa(contatoAtualizado.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizado.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizado.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizado.getDescricao());
        return objectMapper.convertValue(contatoRecuperado, ContatoDTO.class);
    }

    public Contato findById(Integer idContato) throws Exception{
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato nao encontrado"));
        return contatoRecuperado;
    }
}
