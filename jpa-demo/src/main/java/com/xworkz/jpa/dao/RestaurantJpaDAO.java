package com.xworkz.jpa.dao;

import com.xworkz.jpa.entity.RestaurantJpaEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RestaurantJpaDAO {
	public void saveData(RestaurantJpaEntity restaurant) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("new-persistence");
		EntityManager entitymanager=emf.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(restaurant);//adding the instance in the context
		entitymanager.getTransaction().commit();
		entitymanager.clear();
		System.out.println("Record inserted successfully");
		
	}
}
