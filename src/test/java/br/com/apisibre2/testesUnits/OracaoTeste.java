package br.com.apisibre2.testesUnits;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.apisibre2.controller.OracaoController;
import br.com.apisibre2.model.OracaoModel;

public class OracaoTeste extends OracaoTesteApplicationsTestes {

	private MockMvc mockMvc;

	@Autowired
	private OracaoController oracaoController;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(oracaoController).build();
	}

	@Test
	public void fazerOracaoCorreta_RetornaStatusCode201() throws Exception {
		OracaoModel om = new OracaoModel(null, "Ernilson", "ernilson25@gmail.com", "Peço ao Deus Altissimo sabedoria e grande discernimento");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(om);
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/oracao")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				)
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andExpect(MockMvcResultMatchers.header().string("location", Matchers.containsString("http://localhost:8080/oracao")));
	}
}
