package com.caps.beta;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.caps.beta.dto.Song;

public class StoreSongUsingHibernate
{
	public static void main(String[] args)
	{
		System.out.println("Enter a Song Name: ");
		Scanner in = new Scanner(System.in);
		Song s = new Song();
		s.setName(in.nextLine());
		System.out.println("Enter the Song ID: ");
		s.setId(Integer.parseInt(in.nextLine()));
		System.out.println("Enter the Song Singer: ");
		s.setSinger(in.nextLine());
		System.out.println("Enter the Song Genre: ");
		s.setGenre(in.nextLine());

		new StoreSongUsingHibernate().save(s);
		in.close();
	}

	public void save(Song song) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(song);
		tx.commit();
	}
}