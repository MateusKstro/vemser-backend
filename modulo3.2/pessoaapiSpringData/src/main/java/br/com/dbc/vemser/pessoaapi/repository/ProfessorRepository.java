package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.dto.entity.pk.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK> {

}
