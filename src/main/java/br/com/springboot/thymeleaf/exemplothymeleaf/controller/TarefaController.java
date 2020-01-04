package br.com.springboot.thymeleaf.exemplothymeleaf.controller;

import br.com.springboot.thymeleaf.exemplothymeleaf.model.Tarefa;
import br.com.springboot.thymeleaf.exemplothymeleaf.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TarefaController
{
    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @RequestMapping("/lista-tarefas")
    public String listaTarefas(Model model)
    {
        List<Tarefa> tarefas = tarefaService.recuperarTarefasCadastradas();

         model.addAttribute("listaDeTarefas", tarefas );

        return "listatarefas";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarNovaTarefa(@RequestParam String titulo,
                                   @RequestParam String descricao,
                                   Model model)
    {
        //Utilizando JPA para salvar novo objeto no banco de dados
        LocalDateTime dataVigente = LocalDateTime.now();
        Tarefa novaTarefa = new Tarefa(titulo, descricao, "N", dataVigente);
        tarefaService.salvarNovaTarefa(novaTarefa);

        //Reload da lista de tarefas
        List<Tarefa> tarefas = tarefaService.recuperarTarefasCadastradas();
        model.addAttribute("listaDeTarefas", tarefas );

        return "listatarefas";
    }
}
