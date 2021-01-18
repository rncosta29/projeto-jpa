package br.com.rafael.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rafael.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Rafael");
		conta.setNumero(1258456);
		conta.setAgencia(4567);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	}
}
