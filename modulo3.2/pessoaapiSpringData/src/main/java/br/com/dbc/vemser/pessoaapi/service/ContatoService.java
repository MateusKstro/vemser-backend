package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.dto.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.dto.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
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
        return contatoRepository.findAll().stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public void deletar(Integer id) throws RegraDeNegocioException{
        log.info("chamou deletar");
        ContatoEntity contatoEntityDeletado = findById(id);
        contatoRepository.delete(contatoEntityDeletado);
    }

    public ContatoDTO criarContato(Integer id, ContatoCreateDTO contatoCriado) throws RegraDeNegocioException {
        log.info("Criando contato");
        PessoaEntity pessoaEntity = pessoaService.findById(id);
        contatoCriado.setIdPessoa(id);
        ContatoEntity contato = objectMapper.convertValue(contatoCriado, ContatoEntity.class);
        contato.setPessoaEntity(pessoaEntity);
        return objectMapper.convertValue(contatoRepository.save(contato), ContatoDTO.class);
    }

    public List<ContatoDTO> buscarContatoPorIdPessoa(Integer id) throws RegraDeNegocioException{
        log.info("Buscando por idPessoa");
        verificarIdPessoa(id);
        return contatoRepository.findAll().stream()
                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(id))
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public void verificarIdPessoa(Integer idPessoa) throws RegraDeNegocioException{
        pessoaService.findById(idPessoa);
    }

    public ContatoDTO atualizarContato(Integer id, ContatoCreateDTO contatoAtualizado) throws RegraDeNegocioException{
        log.info("Atualizando contato");
        ContatoEntity contatoEntityRecuperado = findById(id);
        contatoEntityRecuperado.setIdPessoa(contatoAtualizado.getIdPessoa());
        contatoEntityRecuperado.setTipoContato(contatoAtualizado.getTipoContato());
        contatoEntityRecuperado.setNumero(contatoAtualizado.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizado.getDescricao());
        return objectMapper.convertValue(contatoRepository.save(contatoEntityRecuperado), ContatoDTO.class);
    }

    public ContatoEntity findById (Integer idContato)throws RegraDeNegocioException {
        return contatoRepository.findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não econtrada"));
    }
}
