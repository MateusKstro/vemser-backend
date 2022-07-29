package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha){
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }


    public Optional<UsuarioEntity> findByLogin(String Login) {
        return usuarioRepository.findByLogin(Login);
    }

    public LoginDTO cadastro(LoginDTO loginDTO){
        UsuarioEntity novoUsuario = objectMapper.convertValue(loginDTO, UsuarioEntity.class);
        novoUsuario.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));
        usuarioRepository.save(novoUsuario);
        return loginDTO;
    }

    public Integer getidLoggedUser(){
        Integer findUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return findUserId;
    }

    public UsuarioDTO getLoggedUser() throws RegraDeNegocioException{
        return findById(getidLoggedUser());
    }

    public UsuarioDTO findById(Integer idUsuario) throws RegraDeNegocioException{
        UsuarioEntity usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RegraDeNegocioException("usuario nao encontrado"));
        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }
}
