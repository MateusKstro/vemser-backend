package br.com.dbc.vemser.pessoaapi.repository;


import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query(" select ctt" +
            "   from CONTATO ctt" +
            "   where ctt.tipoContato = :tipoContato")
    List<ContatoEntity> getContatoPorTipo(@Param("tipoContato") TipoContato tipoContato);


}
