package br.com.rafael.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rafael.jpa.modelo.Categoria;
import br.com.rafael.jpa.modelo.Conta;
import br.com.rafael.jpa.modelo.Movimentacao;
import br.com.rafael.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = em.find(Conta.class, 2L);
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem ao Rio");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(400.0));
		movimentacao.setCategoria(Arrays.asList(categoria2, categoria));
		movimentacao.setConta(conta);
		
//		Movimentacao movimentacao2 = new Movimentacao();
//		movimentacao2.setDescricao("Viagem ao Rio");
//		movimentacao2.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
//		movimentacao2.setData(LocalDateTime.now());
//		movimentacao2.setValor(new BigDecimal(400.0));
//		movimentacao2.setCategoria(Arrays.asList(categoria2, categoria));
//		movimentacao2.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(movimentacao);
//		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		
		em.close();
	}
}