package br.com.springboot.thymeleaf.exemplothymeleaf;

import java.util.List;

import br.com.springboot.thymeleaf.exemplothymeleaf.model.Tarefa;
import br.com.springboot.thymeleaf.exemplothymeleaf.repository.TarefaRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExemploThymeleafApplicationTests {

	private static Logger LOGGER = LoggerFactory.getLogger(ExemploThymeleafApplicationTests.class);

	@Autowired
	TarefaRepository tarefaRepository;

	@Test
	public void _1_Listar_Todas_As_Tarefas()
	{
		List<Tarefa> lista = tarefaRepository.findAll();

		for (Tarefa obj : lista)
		{
			LOGGER.info("Título: {} / Descrição: {}", obj.getTituloTarefa(), obj.getDscTarefa());
		}

		Assert.notNull(lista, "A lista não pode estar vazia");
	}
}
