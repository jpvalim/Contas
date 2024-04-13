package br.com.jpv.contas;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import br.com.jpv.contas.entities.Categoria;
import br.com.jpv.contas.services.CategoriaService;


@WebMvcTest
@ExtendWith(SpringExtension.class)

@SpringBootTest
public class TestCategoriaResource {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CategoriaService service;
		
	@Test
	public void testeInt() throws Exception {
		
		
		RequestBuilder requisicao = get("/categoria");
		MvcResult resultado = mvc.perform(requisicao).andReturn();
		System.out.println(resultado.getResponse().getContentAsString());
	}
	
}

@TestConfiguration 
class TestConfig {

  @Bean
  public Categoria categoria() {
    return new Categoria(1L, "Teste");
  }

}
