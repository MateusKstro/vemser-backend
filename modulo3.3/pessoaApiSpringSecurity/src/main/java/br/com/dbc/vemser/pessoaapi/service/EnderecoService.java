package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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
                .map(enderecoEntity -> {
                    EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                    Set<PessoaEntity> pessoas = enderecoEntity.getPessoas();
                    if(pessoas != null && !pessoas.isEmpty()){
                        Integer idPessoa = pessoas.stream().findFirst()
                                .map(pessoaEntity -> pessoaEntity.getIdPessoa())
                                .get();
                        enderecoDTO.setIdPessoa(idPessoa);
                    }
                    return enderecoDTO;
                })
                .collect(Collectors.toList());
    }

    public EnderecoDTO buscarPorIdEndereco(Integer id) throws Exception {
        return objectMapper.convertValue(findById(id), EnderecoDTO.class);
    }


    public EnderecoDTO criarEndereco(Integer id, EnderecoCreateDTO enderecoCriado) throws Exception{
        log.info("criando endereco");
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCriado, EnderecoEntity.class);
        PessoaEntity pessoaEntity = pessoaService.findById(id);
        enderecoEntity.setPessoas(Set.of(pessoaEntity));
        EnderecoEntity enderecoEntityCriado = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntityCriado, EnderecoDTO.class);
        enderecoDTO.setIdPessoa(id);
        return enderecoDTO;
    }

    public EnderecoDTO atualizarEndereco(Integer id, EnderecoDTO enderecoAtulizado) throws Exception {
        log.info("Atualizadno endereco");
        PessoaEntity pessoaEntity = pessoaService.findById(enderecoAtulizado.getIdPessoa());
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoAtulizado, EnderecoEntity.class);
        enderecoEntity.setIdEndereco(id);
        enderecoEntity.setPessoas(Set.of(pessoaEntity));
        EnderecoDTO enderecoDTORecuperado = objectMapper.convertValue(enderecoRepository.save(enderecoEntity), EnderecoDTO.class);
        enderecoDTORecuperado.setIdPessoa(id);
        return enderecoDTORecuperado;
    }

    public void deletar(Integer id) throws Exception{
        EnderecoEntity enderecoEntity = findById(id);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity,EnderecoDTO.class);
        enderecoRepository.delete(enderecoEntity);
    }

    public EnderecoEntity findById (Integer id) throws Exception {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }

}
