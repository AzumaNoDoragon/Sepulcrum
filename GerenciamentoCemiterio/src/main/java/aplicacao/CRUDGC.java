package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Cadastro;

public class CRUDGC {
	public void create() {
		// Ordem de criação = id, pessoaPublica, cemiterio, nome, quadra, rua, numero,
		// certidaoObito, dataNascimento, dataObito;
		Cadastro p1 = new Cadastro(null, true, "Santo Antonio", "Carlos da Silva", "Alamedas", "A22", 12, 99999,
				"10/10/1999", "10/10/2010");
		Cadastro p2 = new Cadastro(null, false, "Santo Antonio", "Ana da Silva", "Alamedas", "A22", 17, 99998,
				"01/02/1995", "10/10/2015");
		Cadastro p3 = new Cadastro(null, false, "Santo Antonio", "Maria da Silva", "Alamedas", "A22", 19, 99997,
				"02/05/1990", "10/10/2020");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastro");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();

		System.out.println("Pronto!");

		em.close();
		emf.close();
	}

	public void read() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastro");
		EntityManager em = emf.createEntityManager();

		Cadastro p = em.find(Cadastro.class, 2);
		System.out.println(p);

		em.close();
		emf.close();
	}

	public void update(Cadastro cadastro) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastro");
		EntityManager em = emf.createEntityManager();

		Cadastro u = em.find(Cadastro.class, 1);
		em.getTransaction().begin();
		em.merge(u);
		cadastro.setPessoaPublica(false);
		cadastro.setCemiterio("São José");
		cadastro.setQuadra("a34");
		cadastro.setRua("Jose Cardoso");
		cadastro.setNumero(222);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public void pa() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastro");
		EntityManager em = emf.createEntityManager();

		Cadastro r = em.find(Cadastro.class, 3);
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
