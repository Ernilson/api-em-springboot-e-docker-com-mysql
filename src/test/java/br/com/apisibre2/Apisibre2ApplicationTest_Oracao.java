package br.com.apisibre2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.apisibre2.model.OracaoModel;
import br.com.apisibre2.serviceImpl.OracaoServiceImpl;

@SpringBootTest
public class Apisibre2ApplicationTest_Oracao {
	
	@Autowired
	private OracaoServiceImpl som;
	
	@Test
	public void adcinar() {
		OracaoModel om = new OracaoModel();
		om.setNome("teste2");
		om.setEmail("ernilson25@gmail.com");
		om.setMsg("teste de oração");
		
		som.saveOrUpdate(om);
	}

}
