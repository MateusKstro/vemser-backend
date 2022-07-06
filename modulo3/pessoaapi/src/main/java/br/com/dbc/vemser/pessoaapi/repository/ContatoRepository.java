package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {

    private static List<Contato> listaContato = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository(){
        listaContato.add(new Contato(COUNTER.incrementAndGet(), 1,"COMERCIAL", 991898146, "whatsapp"));
        listaContato.add(new Contato(COUNTER.incrementAndGet(),2, "RESIDENCIAL", 778855443,"casa"));
        listaContato.add(new Contato(COUNTER.incrementAndGet(), 3, "RESIDENCIAL",557789763, "whatsapp"));
        listaContato.add(new Contato(COUNTER.incrementAndGet(), 4, "COMERCIAL",999889999, "whatsapp"));
        listaContato.add(new Contato(COUNTER.incrementAndGet(), 5, "RESIDENCIAL",344878631,"casa"));
    }

    public Contato create(Contato contato){
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContato.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContato;
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception{
        Contato contatoRecuperado = listaContato.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato nao encontrado"));
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoDeletado = listaContato.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato nao encontrado"));
        listaContato.remove(contatoDeletado);
    }

    public List<Contato> BuscarContatoPorIdPessoa(Integer id){
        return listaContato.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Contato BuscarPorIdContato(Integer id) throws Exception {
        return listaContato.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Conato nao encontrado"));
    }
}
