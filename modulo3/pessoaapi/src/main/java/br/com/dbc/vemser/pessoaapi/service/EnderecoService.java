package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private  PessoaService pessoaService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.list();
    }

    public Endereco buscarPorIdEndereco(Integer id) throws Exception {
        return listarEnderecos().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Id invalido"));
    }

    public List<Endereco> buscarEnderecoPorIdPessoa(Integer id) throws Exception{
        verificarIdPessoa(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
    public void verificarIdPessoa(Integer idPessoa) throws Exception{
        pessoaService.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception("Id invalido"));
    }

    public Endereco criarEndereco(Integer id, Endereco endereco) throws Exception{
        Pessoa pessoa = pessoaRepository.list().stream()
                .filter(c -> c.getIdPessoa().equals(id))
                .findFirst().orElseThrow(() -> new Exception("Pessoa nao encontrado"));
        endereco.setIdPessoa(pessoa.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public Endereco atualizarEndereco(Integer id, Endereco enderecoAtulizado) throws Exception {
        Endereco enderecoLocalizado = enderecoRepository.list().stream()
                .filter(contato -> contato.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco nao encontrado"));
        enderecoLocalizado.setIdPessoa(enderecoAtulizado.getIdPessoa());
        enderecoLocalizado.setTipo(enderecoAtulizado.getTipo());
        enderecoLocalizado.setLogradouro(enderecoAtulizado.getLogradouro());
        enderecoLocalizado.setNumero(enderecoAtulizado.getNumero());
        enderecoLocalizado.setComplemento(enderecoAtulizado.getComplemento());
        enderecoLocalizado.setCep(enderecoAtulizado.getCep());
        enderecoLocalizado.setCidade(enderecoAtulizado.getCidade());
        enderecoLocalizado.setEstado(enderecoAtulizado.getEstado());
        enderecoLocalizado.setPais(enderecoAtulizado.getPais());
        return enderecoLocalizado;
    }

    public void deletar(Integer id) throws Exception{
        Endereco enderecoDeletado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco nao encontrado"));
        enderecoRepository.list().remove(enderecoDeletado);
    }
}
