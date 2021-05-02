package br.com.apisibre2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.apisibre2.model.ContatoModel;
import br.com.apisibre2.serviceImpl.ContatoServiceImpl;

@SpringBootTest
class Apisibre2ApplicationTests {
	
	@Autowired
	private ContatoServiceImpl cpl;

	@Test
	void contextLoads() {
		
		ContatoModel cm = new ContatoModel();
		
		cm.setNome("Ernilson Daniel Lima de Souza");
		cm.setEmail("ernilson25@gmail.com");
		cm.setAssuntoMsg("teste");
		cm.setConteudoMsg("Isto é um teste");
		
		cpl.saveOrUpdate(cm);
	}

}
