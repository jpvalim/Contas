package br.com.jpv.contas.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.jpv.contas.entities.CartaoCredito;
import br.com.jpv.contas.entities.Categoria;
import br.com.jpv.contas.entities.Conta;
import br.com.jpv.contas.repositories.CartaoCreditoRepository;
import br.com.jpv.contas.repositories.CategoriaRepository;
import br.com.jpv.contas.repositories.ContaRepository;

@Configuration
public class Config implements CommandLineRunner {
	
	@Value("${spring.profiles.active}")
	String profile;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
		
	@Autowired
	private CartaoCreditoRepository cartaoRepository;
	

	@Override
	public void run(String... args) throws Exception {
		if (profile.equals("test")) {
			//Categorias
			Categoria c1 = new Categoria(null, "Contas da casa");
			Categoria c2 = new Categoria(null, "Transporte");
			Categoria c3 = new Categoria(null, "Carro");
			Categoria c4 = new Categoria(null, "Taxa");
			Categoria c5 = new Categoria(null, "Compra parcelada");
			Categoria c6 = new Categoria(null, "Alimentaçao fora");
			Categoria c7 = new Categoria(null, "Outros");
			Categoria c8 = new Categoria(null, "Acessórios");
			Categoria c9 = new Categoria(null, "Cuidados pessoais");
			Categoria c10 = new Categoria(null, "Alimentação café");
			Categoria c11 = new Categoria(null, "Saúde");
			Categoria c12 = new Categoria(null, "Mercado");
			Categoria c13 = new Categoria(null, "Telefonia");
			Categoria c14 = new Categoria(null, "Roupas");
			Categoria c15 = new Categoria(null, "Fatura cartão");
			Categoria c16 = new Categoria(null, "Investimento");
			Categoria c17 = new Categoria(null, "Pet");
			categoriaRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17));
			
			//TESTE CONTA
			Conta conta  = new Conta(null, "Itaú", "Jefferson",  118.57, 5430.00);
			Conta conta2 = new Conta(null, "Bradesco", "Jefferson", 1611.26, 3070.00);
			contaRepository.saveAll(Arrays.asList(conta, conta2));
					
			//TESTE CARTAO
			CartaoCredito cartao1 = new CartaoCredito(null, 2500d, "Cartão Itaú Digital", "Jefferson",LocalDate.parse("17/06/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/06/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 8 );
			CartaoCredito cartao2 = new CartaoCredito(null, 2500d, "Cartão Itau Multiplo Internacional","Jefferson", LocalDate.parse("12/06/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("21/06/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 8);	
			cartaoRepository.saveAll(Arrays.asList(cartao1, cartao2));
		}
		
		
			
	}

}
