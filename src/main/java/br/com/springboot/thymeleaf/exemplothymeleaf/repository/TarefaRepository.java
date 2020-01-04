package br.com.springboot.thymeleaf.exemplothymeleaf.repository;

import br.com.springboot.thymeleaf.exemplothymeleaf.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>
{

}
