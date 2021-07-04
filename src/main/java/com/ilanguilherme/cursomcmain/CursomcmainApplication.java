package com.ilanguilherme.cursomcmain;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ilanguilherme.cursomcmain.domain.Categoria;
import com.ilanguilherme.cursomcmain.domain.Cidade;
import com.ilanguilherme.cursomcmain.domain.Cliente;
import com.ilanguilherme.cursomcmain.domain.Endereco;
import com.ilanguilherme.cursomcmain.domain.Estado;
import com.ilanguilherme.cursomcmain.domain.Produto;
import com.ilanguilherme.cursomcmain.domain.enums.TipoCliente;
import com.ilanguilherme.cursomcmain.repositories.CategoriaRepository;
import com.ilanguilherme.cursomcmain.repositories.CidadeRepository;
import com.ilanguilherme.cursomcmain.repositories.ClienteRepository;
import com.ilanguilherme.cursomcmain.repositories.EnderecoRepository;
import com.ilanguilherme.cursomcmain.repositories.EstadoRepository;
import com.ilanguilherme.cursomcmain.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcmainApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcmainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia", est1);
		Cidade c2 = new Cidade(null,"São Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
				
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva","maria@email.com", "11122233344", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("115541515","46556123"));
		
		Endereco e1 = new Endereco(null, "Rua Flore","300","Apto 300","Jardim", "444444", cli1, c1);
		Endereco e2 = new Endereco(null, "Av Mato","105","Sala 800","Centro", "555555", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}
	

}
