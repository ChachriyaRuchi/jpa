package com.xworkz.clothesapp.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.xworkz.clothesapp.entity.ClothesEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ClothesDAOImpl implements ClothesDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("two-persistence");

	@Override
	public void saveData(ClothesEntity clothesEntity) {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(clothesEntity);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}finally {
			if(em!=null)
				em.close();
		}
	}

	@Override
	public ClothesEntity getClothesById(Integer id) {
		EntityManager em=emf.createEntityManager();
		ClothesEntity entity=null;
		try{
			entity=em.find(ClothesEntity.class, id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public void updateClotheBrandAndPriceById(String brand, Double price, Integer id) {
	  EntityManager em=null;
	  EntityTransaction et=null;
	  ClothesEntity clothesEntity=null;
	  try {
		  em=emf.createEntityManager();
		  clothesEntity=em.find(ClothesEntity.class, id);
		  if(clothesEntity!=null) {
			
			  et=em.getTransaction();
			  et.begin();
			  clothesEntity.setBrand(brand);
			  clothesEntity.setPrice(price);
			  em.merge(clothesEntity);
			  et.commit();
		  }
	  }catch(Exception e) {
		  et.rollback();
		  e.printStackTrace();
	  }finally {
		  if(em!=null)
			  em.close();	  
	  }  
	}

	@Override
	public void updateManufacturedYearById(Calendar manufacturedYear, Integer id) {
		EntityManager em=null;
		EntityTransaction et=null;
		ClothesEntity clothesEntity=null;
		try {
			em=emf.createEntityManager();
			clothesEntity=em.find(ClothesEntity.class, id);
		if(clothesEntity!=null) {
			
			et=em.getTransaction();
			et.begin();
			clothesEntity.setManufacturedYear(manufacturedYear);
			em.merge(clothesEntity);
			et.commit();
		}
		}catch(Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		finally {
			if(em!=null)
				em.close();
		}
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em=null;
		EntityTransaction et=null;
		ClothesEntity clothesEntity=null;
		try {
			
			em=emf.createEntityManager();
			clothesEntity=em.find(ClothesEntity.class, id);
			if(clothesEntity!=null) {
			et=em.getTransaction();
			et.begin();
			em.remove(clothesEntity);
			et.commit();
			}
		}catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}

	}

}
