package com.xworkz.tv.dao;

import org.hibernate.Transaction;

import com.xworkz.tv.entity.TVChannel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TVChannelDAOImpl implements TVChannelDAO{
	EntityManagerFactory emf=null;
	EntityManager em=null;
	EntityTransaction tnx=null;
	@Override
	public void saveChannel(TVChannel tvChannel) {
		
		try {
		emf=Persistence.createEntityManagerFactory("one-persistence");
		em=emf.createEntityManager();
		tnx=em.getTransaction();
		tnx.begin();
		em.persist(tvChannel);
		tnx.commit();
		
		
		}
		catch(Exception e) {
			tnx.rollback();
			e.printStackTrace();
		}
		finally {
			if(emf!=null) {
				emf.close();
			}
			if(em!=null) {
				em.close();
			}
		}
	}
	/*
	public void getChannel()
	{
	
	}*/
	
	public void getChannel() {
		try {
			emf=Persistence.createEntityManagerFactory("one-persistence");
			em=emf.createEntityManager();
			TVChannel tvChannel =em.find(TVChannel.class, 1);
			System.out.println(tvChannel);
		}catch(Exception e) {
			e.printStackTrace();
		} 
		finally {
			if(emf!=null)
				emf.close();
			
		}	
		
	}
	
	
}
