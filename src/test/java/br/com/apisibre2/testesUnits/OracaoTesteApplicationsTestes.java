package br.com.apisibre2.testesUnits;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.apisibre2.Apisibre2Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Apisibre2Application.class)
@TestPropertySource(locations = "classpath:application.properties")
public class OracaoTesteApplicationsTestes {
	
	@Test
	void contextLoads() {
	}

}
