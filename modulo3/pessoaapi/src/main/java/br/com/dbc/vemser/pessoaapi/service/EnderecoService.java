package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Log
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

    public List<EnderecoDTO> listarEnderecos(){
        log.info("listando enderecos");
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO buscarPorIdEndereco(Integer id) throws Exception {
        return objectMapper.convertValue(findById(id), EnderecoDTO.class);
    }

    public List<EnderecoDTO> buscarEnderecoPorIdPessoa(Integer id) throws Exception{
        log.info("Buscando por IdPessoa");
        verificarIdPessoa(id);
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    public void verificarIdPessoa(Integer idPessoa) throws Exception{
        pessoaService.findById(idPessoa);
    }

    public EnderecoDTO criarEndereco(Integer id, EnderecoCreateDTO enderecoCriado) throws Exception{
        log.info("criando endereco");
        pessoaService.findById(id);
        enderecoCriado.setIdPessoa(id);
        Endereco endereco = objectMapper.convertValue(enderecoCriado, Endereco.class);
        return objectMapper.convertValue(enderecoRepository.create(id, endereco), EnderecoDTO.class);
    }

    public EnderecoDTO atualizarEndereco(Integer id, EnderecoCreateDTO enderecoAtulizado) throws Exception {
        log.info("Atualizadno endereco");
        Endereco enderecoLocalizado = findById(id);
        enderecoLocalizado.setIdPessoa(enderecoAtulizado.getIdPessoa());
        enderecoLocalizado.setTipo(enderecoAtulizado.getTipo());
        enderecoLocalizado.setLogradouro(enderecoAtulizado.getLogradouro());
        enderecoLocalizado.setNumero(enderecoAtulizado.getNumero());
        enderecoLocalizado.setComplemento(enderecoAtulizado.getComplemento());
        enderecoLocalizado.setCep(enderecoAtulizado.getCep());
        enderecoLocalizado.setCidade(enderecoAtulizado.getCidade());
        enderecoLocalizado.setEstado(enderecoAtulizado.getEstado());
        enderecoLocalizado.setPais(enderecoAtulizado.getPais());
        return objectMapper.convertValue(enderecoLocalizado, EnderecoDTO.class);
    }

    public void deletar(Integer id) throws Exception{
        Endereco enderecoDeletado = findById(id);
        enderecoRepository.list().remove(enderecoDeletado);
    }

    public Endereco findById (Integer idEndereco) throws Exception{
        Endereco enderecoLocalizado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco nao encontrado"));
        return enderecoLocalizado;
    }
}
