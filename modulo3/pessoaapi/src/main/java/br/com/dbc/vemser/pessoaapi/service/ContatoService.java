package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {


    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> listarContatos(){
        return contatoRepository.list();
    }

    public void deletar(Integer id) throws Exception{
        Contato contatoDeletado = findById(id);
        contatoRepository.list().remove(contatoDeletado);
    }

    public Contato criarContato(Integer id, Contato contato) throws Exception{
        pessoaService.findById(id);
        contato.setIdPessoa(id);
        return contatoRepository.create(contato);
    }

    public List<Contato> buscarContatoPorIdPessoa(Integer id) throws Exception{
        verificarIdPessoa(id);
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public void verificarIdPessoa(Integer idPessoa) throws Exception{
        pessoaService.findById(idPessoa);
    }

    public Contato atualizarContato(Integer id, Contato contatoAtualizado) throws Exception {
        Contato contatoRecuperado = findById(id);
        contatoRecuperado.setIdPessoa(contatoAtualizado.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizado.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizado.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizado.getDescricao());
        return contatoRecuperado;
    }

    public Contato findById(Integer idContato) throws Exception{
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato nao encontrado"));
        return contatoRecuperado;
    }
}
