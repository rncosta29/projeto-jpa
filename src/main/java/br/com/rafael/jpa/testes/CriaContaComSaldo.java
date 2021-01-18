package br.com.rafael.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rafael.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Marcia");
		conta.setNumero(1056726);
		conta.setAgencia(4364);
		conta.setSaldo(100.0);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		
		System.out.println("Id conta da marcia = " + conta.getId());
		conta.setSaldo(500.0);
		
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();
	}
}
