package br.com.rafael.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rafael.jpa.modelo.Cliente;
import br.com.rafael.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cliente = new Cliente();
		cliente.setNome("João");
		cliente.setEndereco("Rua Palmeiras, 660");
		cliente.setProfissao("Professor");
		cliente.setConta(conta);
		
		em.getTransaction().begin();
		em.persist(cliente);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
