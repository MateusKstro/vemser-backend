package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;

import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }

    public List<Contato> listarContatos(){
        return contatoRepository.list();
    }

    public void deletar(Integer id) throws Exception{
        contatoRepository.delete(id);
    }

    public Contato criarContato(Contato contato){
        return contatoRepository.create(contato);
    }

    public List<Contato> BuscarContatoPorIdPessoa(Integer id){
        return contatoRepository.BuscarContatoPorIdPessoa(id);
    }

    public Contato atualizarContato(Integer id, Contato contatoAtualizado) throws Exception {
        return contatoRepository.update(id, contatoAtualizado);
    }

}
