package br.com.springboot.thymeleaf.exemplothymeleaf.controller;

import br.com.springboot.thymeleaf.exemplothymeleaf.model.Tarefa;
import br.com.springboot.thymeleaf.exemplothymeleaf.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class TarefaController
{

    @Autowired
    TarefaRepository tarefaRepository;

    @RequestMapping("/lista-tarefas")
    public String listaTarefas(Model model)
    {
        List<Tarefa> tarefas = tarefaRepository.findAll();

         model.addAttribute("listaDeTarefas", tarefas );

        return "listatarefas";
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvarNovaTarefa(@RequestParam String titulo,
                                   @RequestParam String descricao,
                                   Model model)
    {
        //Utilizando JPA para salvar novo objeto no banco de dados
        LocalDateTime dataVigente = LocalDateTime.now();
        Tarefa novaTarefa = new Tarefa(titulo, descricao, "N", dataVigente);
        tarefaRepository.save(novaTarefa);

        //Reload da lista de tarefas
        List<Tarefa> tarefas = tarefaRepository.findAll();
        model.addAttribute("listaDeTarefas", tarefas );

        return "listatarefas";
    }
}
