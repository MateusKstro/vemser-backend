package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.dto.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public List<PetDTO> listarPets(){
        log.info("listando pets");
        return petRepository.findAll().stream()
                .map(petEntity -> objectMapper.convertValue(petEntity, PetDTO.class))
                .collect(Collectors.toList());
    }

    public PetDTO criarPet(Integer id, PetCreateDTO petCriado) throws RegraDeNegocioException {
        log.info("Criando Pet");
        pessoaService.findById(id);
        petCriado.setIdPessoa(id);
        PetEntity petEntity = objectMapper.convertValue(petCriado, PetEntity.class);
        return objectMapper.convertValue(petRepository.save(petEntity), PetDTO.class);
    }

    public PetDTO atualizarPet(Integer id, PetCreateDTO petAtualizado) throws RegraDeNegocioException {
        log.info("Atualizando contato");
        PetEntity petEntityRecuperado = findById(id);
        petEntityRecuperado.setIdPessoa(petAtualizado.getIdPessoa());
        petEntityRecuperado.setNome(petAtualizado.getNome());
        petEntityRecuperado.setTipoPet(petAtualizado.getTipoPet());
        return objectMapper.convertValue(petRepository.save(petEntityRecuperado), PetDTO.class);
    }

    public void deletar(Integer id) throws RegraDeNegocioException{
        log.info("chamou deletar");
        PetEntity petEntityDeletado = findById(id);
        petRepository.delete(petEntityDeletado);
    }

    public PetEntity findById(Integer idPet) throws RegraDeNegocioException{
        PetEntity petEntityRecuperado = petRepository.findAll().stream()
                .filter(contatoEntity -> contatoEntity.getIdPet().equals(idPet))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pet nao encontrado"));
        return petEntityRecuperado;
    }
}
