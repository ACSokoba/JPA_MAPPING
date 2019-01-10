package org.sokoba.jpaserie2;

import static javax.persistence.Persistence.createEntityManagerFactory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = 
				createEntityManagerFactory("jpa-test");		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		//TEST D UNE REQUETE JPQL		
		Query query = entityManager.createQuery("select maire from Maire maire where maire.prenom = 'Daniel'");
		
		// exécution et récupération de la liste résultat
		List<Maire> maires = query.getResultList();
		
		// analyse du résultat (classique)
		
//		for (Object m : maires) {
//			// chaque élément est de type NameBean
//			Maire maire = (Maire)m ;
//			System.out.println(maire.getNom() +  " " + maire.getPrenom()) ;
//		}

		//		Departement ain = new Departement();
		//		ain.setCode("1");
		//		ain.setNom("AIN");
		//		System.out.println(ain.getNumberOfTown());

		/* ----------------------------------------------------------
		-------------------       EXERCICE 7      -------------------
		-------------------------------------------------------------*/
		
		
		/*//Quesiton1
		query = entityManager.createQuery("select commune from Commune commune where commune.nom = 'gauchy'");
		Commune c = (Commune)query.getSingleResult();
		System.out.println(c);*/

		//Question2
		query = entityManager.createQuery("select commune from Commune commune " + "where commune.maire.nom = ?1");
		query.setParameter(1, "martin");
		List<Commune> communes = query.getResultList();	
		System.out.println("nombre de communes "+communes.size()); 

		for (Object c : communes) {
		Commune commune = (Commune)c ;
		System.out.println(commune); 
	}	



	}

}
