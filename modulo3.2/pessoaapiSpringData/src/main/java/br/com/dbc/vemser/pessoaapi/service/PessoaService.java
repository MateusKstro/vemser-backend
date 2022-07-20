package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.dto.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCriado){
        log.info("Criando pessoa");
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCriado, PessoaEntity.class);
        return objectMapper.convertValue(pessoaRepository.save(pessoaEntity), PessoaDTO.class);
    }

    public List<PessoaDTO> list(){
        log.info("Listando Pessoas");
        return pessoaRepository.findAll().stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("atualizando pessoa");
        PessoaEntity pessoaEntityRecuperada = findById(id);
        pessoaEntityRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaEntityRecuperada.setEmail(pessoaAtualizar.getEmail());
        pessoaEntityRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaEntityRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaEntityRecuperada, PessoaEntity.class);
        return objectMapper.convertValue(pessoaRepository.save(pessoaEntity), PessoaDTO.class);
    }

    public void delete(Integer id) throws Exception {
        PessoaEntity pessoaEntityRecuperada = findById(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntityRecuperada, PessoaDTO.class);
        emailService.sendEmail(pessoaDTO, "delete");
        pessoaRepository.delete(pessoaEntityRecuperada);
    }

    public List<PessoaDTO> listByName(String nome) {
        log.info("Buscar por nome");
        return pessoaRepository.findAll().stream()
                .filter(pessoaEntity -> pessoaEntity.getNome().toUpperCase().contains(nome.toUpperCase()))
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTOComContatos> listarPessoasComContatos(Integer idPessoa) throws Exception {
        List<PessoaDTOComContatos> listPessoasDTOComContatos = new ArrayList<>();
        if (idPessoa == null) {
            listPessoasDTOComContatos.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComContatos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
                    }).toList()
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            listPessoasDTOComContatos.add(pessoaDTO);
        }
        return listPessoasDTOComContatos;
    }

    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(Integer idPessoa) throws Exception {
        List<PessoaDTOComEnderecos> listPessoasDTOComEnderecos = new ArrayList<>();
        if (idPessoa == null) {
            listPessoasDTOComEnderecos.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
                        pessoaDTO.setEnderecos(pessoa.getEnderecos().stream()
                                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
                    }).toList()
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecos.class);
            pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                    .collect(Collectors.toList())
            );
            listPessoasDTOComEnderecos.add(pessoaDTO);
        }
        return listPessoasDTOComEnderecos;
    }

    public List<PessoaDTOComPets> listarPessoasComPets(Integer idPessoa) throws Exception {
        List<PessoaDTOComPets> listPessoasDTOComPets = new ArrayList<>();
        if (idPessoa == null) {
            listPessoasDTOComPets.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComPets pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComPets.class);
                        pessoaDTO.setPets(objectMapper.convertValue(pessoa.getPets(), PetDTO.class));
                        return pessoaDTO;
                    }).toList()
            );
        }
        else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaDTOComPets pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComPets.class);
            pessoaDTO.setPets(objectMapper.convertValue(pessoaEntity.getPets(), PetDTO.class));
            listPessoasDTOComPets.add(pessoaDTO);
        }
        return listPessoasDTOComPets;
    }



    public PessoaEntity findById (Integer idPessoa)throws RegraDeNegocioException {
        PessoaEntity pessoaEntityRecuperada = pessoaRepository.findAll().stream()
                .filter(pessoaEntity -> pessoaEntity.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        return pessoaEntityRecuperada;
    }
}
