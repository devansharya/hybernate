package com.cg.bookauthor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		// first define few products before we place order

		Book book1 = new Book();
		book1.setId(5);
		book1.setName("LED TV");
		book1.setPrice(40000);

		Book book2 = new Book();
		book2.setId(6);
		book2.setName("Face Wash");
		book2.setPrice(800);

		Book book3 = new Book();
		book3.setId(7);
		book3.setName("Pampers");
		book3.setPrice(150);

		Book book4 = new Book();
		book4.setId(8);
		book4.setName("CFL Bulb");
		book4.setPrice(2500);

		// now define first order and add few products in it
		Author firstOrder = new Author();
		firstOrder.setId(1005);
		firstOrder.setName("golu");

		firstOrder.addProduct(book3);
		firstOrder.addProduct(book1);
		firstOrder.addProduct(book2);

		// now define second order and add few products in it
		Author secondOrder = new Author();
		secondOrder.setId(1006);
		secondOrder.setName("title do");

		secondOrder.addProduct(book3);
		secondOrder.addProduct(book1);
		secondOrder.addProduct(book2);

		// save orders using entity manager

		em.persist(firstOrder);
		em.persist(secondOrder);

		System.out
				.println("Added orders along with order details to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
