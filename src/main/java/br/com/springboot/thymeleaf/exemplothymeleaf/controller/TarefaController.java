package br.com.springboot.thymeleaf.exemplothymeleaf.controller;

import br.com.springboot.thymeleaf.exemplothymeleaf.model.Tarefa;
import br.com.springboot.thymeleaf.exemplothymeleaf.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
