package br.com.dbc.vemser.pessoaapi.repository;


import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private List<Endereco> enderecoList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository(){
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.RESIDENCIAL,"Rua Clovis Pestana",204,"Apto.55","123456798","Cachoeirinha","RS","BR"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.COMERCIAL,"Rua Industrial",1056,"Empresa. 5406","467879328","Cachoeirinha","RS","BR"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),2, TipoEndereco.COMERCIAL,"Rua Pokemon",1567,"Empresa. 518","641868773","Porto Alegre","RS","BR"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),2, TipoEndereco.RESIDENCIAL,"Rua Padawans",3,"Apto.402","1879788","Porto Alegre","RS","BR"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),3, TipoEndereco.RESIDENCIAL,"Rua tapajos",480,"Casa 246","168879321","Canoas","RS","BR"));
    }

    public Endereco create(Endereco endereco){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        enderecoList.add(endereco);
        return endereco;
    }

    public List<Endereco> list(){
        return enderecoList;
    }

}
