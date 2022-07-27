package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    private final TokenService tokenService;


    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO login) throws RegraDeNegocioException{
        Optional<UsuarioEntity> optionalUsuario = usuarioService.findByLoginAndSenha(login.getLogin(), login.getSenha());
        if(optionalUsuario.isPresent()){
            String token = tokenService.getToken(optionalUsuario.get());
            return token;
        }
        throw new RegraDeNegocioException("Usuario ou senha invaalidos.");
    }
}
