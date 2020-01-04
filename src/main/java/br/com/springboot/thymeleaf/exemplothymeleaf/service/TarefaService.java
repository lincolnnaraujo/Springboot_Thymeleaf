package br.com.springboot.thymeleaf.exemplothymeleaf.service;

import br.com.springboot.thymeleaf.exemplothymeleaf.model.Tarefa;
import br.com.springboot.thymeleaf.exemplothymeleaf.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService
{
    TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> recuperarTarefasCadastradas(){
        return tarefaRepository.findAll();
    }

    public void salvarNovaTarefa(Tarefa _tarefa)
    {
        tarefaRepository.save(_tarefa);
    }
}
