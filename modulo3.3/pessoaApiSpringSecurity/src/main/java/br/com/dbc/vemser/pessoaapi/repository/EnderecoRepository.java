package br.com.dbc.vemser.pessoaapi.repository;


import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query(" select e" +
            "   from ENDERECO_PESSOA e" +
            "   where e.pais = :pais")
    List<EnderecoEntity> enderecoByPais(@Param("pais") String pais);


    @Query(value = " select e" +
            " from ENDERECO_PESSOA e")
    Page<EnderecoEntity> findEnderecoCepPaginado(String cep, Pageable pageable);

    @Query(value = " select e" +
            " from ENDERECO_PESSOA e" +
            " where (:pais is null or e.pais = :pais)")
    Page<EnderecoEntity> findEnderecoPaisPaginado(@Param ("pais") String pais, Pageable pageable);
}
