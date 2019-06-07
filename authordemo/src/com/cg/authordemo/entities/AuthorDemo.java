package com.cg.authordemo.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AuthorDemo {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();

		Author author = new Author();
		author.setFname("solanki");
		author.setMname("rajput");
		author.setLname("arya");
		author.setPhoneno("89456362");
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
		System.out.println("Addedauthor to database.");

	int id = 22;
		author = em.find(Author.class, id);
		author.setFname("john");
		em.getTransaction().begin();
		em.merge(author);
		em.getTransaction().commit();
		System.out.println("Update author to database.");

		id = 22;
		author = em.find(Author.class, id);
		em.getTransaction().begin();
		em.remove(author);
		em.getTransaction().commit();
		System.out.println("Remove author from database.");

		em.close();
		factory.close();
	}
}
