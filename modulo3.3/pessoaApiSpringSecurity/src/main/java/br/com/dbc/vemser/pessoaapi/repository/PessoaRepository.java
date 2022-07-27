package br.com.dbc.vemser.pessoaapi.repository;


import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaRelatorioDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    //query methods
    List<PessoaEntity> findByNomeContainsIgnoreCase (String nome);

    List<PessoaEntity> findByCpf(String cpf);

    //jpql = java persistence query language

    @Query(" select p " +
            "   from PESSOA p" +
            "   where p.cpf = ?1")
    List<PessoaEntity> listPessoaByCpf(String cpf);

    //pessoa: id, nome e email
    //Contato: numero;
    //Endereco:cep, cidade, estado e pais
    //Pet:nome

    @Query(value = "select new br.com.dbc.vemser.pessoaapi.dto.PessoaRelatorioDTO(" +
            " p.idPessoa," +
            " p.nome," +
            " p.email," +
            " ctt.numero," +
            " e.cep," +
            " e.cidade," +
            " e.estado," +
            " e.pais," +
            " pety.nome" +
            ")" +
            " from PESSOA p " +
            " left join p.contatos ctt " +
            " left join p.enderecos e " +
            " left join p.pets pety" +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa)")
    List<PessoaRelatorioDTO> listaRelatorio(@Param("idPessoa") Integer idPessoa);
}
