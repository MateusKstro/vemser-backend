package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.dto.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class EnderecoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private  PessoaService pessoaService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    EmailService emailService;

    public List<EnderecoDTO> listarEnderecos(){
        log.info("listando enderecos");
        return enderecoRepository.findAll().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO buscarPorIdEndereco(Integer id) throws Exception {
        return objectMapper.convertValue(findById(id), EnderecoDTO.class);
    }


    public EnderecoDTO criarEndereco(Integer id, EnderecoCreateDTO enderecoCriado) throws Exception{
        log.info("criando endereco");
        pessoaService.findById(id);
        enderecoCriado.setIdPessoa(id);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCriado, EnderecoEntity.class);
        return objectMapper.convertValue(enderecoRepository.save(enderecoEntity), EnderecoDTO.class);
    }

    public EnderecoDTO atualizarEndereco(Integer id, EnderecoCreateDTO enderecoAtulizado) throws Exception {
        log.info("Atualizadno endereco");
        EnderecoEntity enderecoEntityLocalizado = findById(id);
        enderecoEntityLocalizado.setTipo(enderecoAtulizado.getTipo());
        enderecoEntityLocalizado.setLogradouro(enderecoAtulizado.getLogradouro());
        enderecoEntityLocalizado.setNumero(enderecoAtulizado.getNumero());
        enderecoEntityLocalizado.setComplemento(enderecoAtulizado.getComplemento());
        enderecoEntityLocalizado.setCep(enderecoAtulizado.getCep());
        enderecoEntityLocalizado.setCidade(enderecoAtulizado.getCidade());
        enderecoEntityLocalizado.setEstado(enderecoAtulizado.getEstado());
        enderecoEntityLocalizado.setPais(enderecoAtulizado.getPais());
        return objectMapper.convertValue(enderecoRepository.save(enderecoEntityLocalizado), EnderecoDTO.class);
    }

    public void deletar(Integer id) throws Exception{
        EnderecoEntity enderecoEntityDeletado = findById(id);
        enderecoRepository.delete(enderecoEntityDeletado);
    }

    public EnderecoEntity findById (Integer id) throws Exception {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }

}
