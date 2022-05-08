package com.xworkz.tv.dao;

import org.hibernate.Transaction;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.xworkz.tv.entity.TVChannel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TVChannelDAOImpl implements TVChannelDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("one-persistence");

	@Override
	public void saveChannel(TVChannel tvChannel) {
		EntityManager em = null;
		EntityTransaction tnx = null;
		try {

			em = emf.createEntityManager();
			tnx = em.getTransaction();
			tnx.begin();
			em.persist(tvChannel);
			tnx.commit();

		} catch (Exception e) {
			tnx.rollback();
			e.printStackTrace();
		} finally {

			if (em != null) {
				em.close();
			}
		}
	}

	public void getChannel() {
		try {

			EntityManager em = emf.createEntityManager();
			TVChannel tvChannel = em.find(TVChannel.class, 1);

			System.out.println(tvChannel);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public TVChannel getChannelbyId(Integer channelId) {
		EntityManager em = null;
		TVChannel tvChannel = null;
		try {

			em = emf.createEntityManager();
			tvChannel = em.find(TVChannel.class, channelId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tvChannel;
	}

	@Override
	public void updateChannelById(Double price, Integer channelId) {
		EntityManager em = null;
		TVChannel tvChannel = null;
		EntityTransaction transaction = null;
		try {
			em = emf.createEntityManager();
			tvChannel = em.find(TVChannel.class, channelId);
			if (tvChannel != null) {
				transaction = em.getTransaction();
				transaction.begin();
				tvChannel.setPrice(price);
				em.merge(tvChannel);
				transaction.commit();
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}

	}

	@Override
	public void deleteById(Integer channelId) {
		EntityManager em = null;
		EntityTransaction transaction = null;
		TVChannel tvChannel = null;
		try {
			em = emf.createEntityManager();
			tvChannel = em.find(TVChannel.class, channelId);
			if (tvChannel != null) {
				transaction = em.getTransaction();
				transaction.begin();
				em.remove(tvChannel);
				transaction.commit();
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();

		}

	}

	@Override
	public String getChannelNameById(Integer channelId) {
		EntityManager em=null;
		
		String channelName=null;
		
		try {
			em=emf.createEntityManager();
			Query query=em.createQuery("SELECT channelName FROM TVChannel WHERE channelId=:id");
			query.setParameter("id", channelId);
			channelName=(String) query.getSingleResult();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(em!=null)
				em.close();
		}
		return channelName;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateChannelPriceByChannelName(Double price, String channelName) {
		EntityManager em=null;
		EntityTransaction et=null;
		TVChannel tvChannel=null;
		
		try {
			em = emf.createEntityManager();
		
			et=em.getTransaction();
			et.begin();
			Query query=em.createQuery("UPDATE  TVChannel SET price= :price WHERE channelName=:channelName");
			query.setParameter("price", price);
			query.setParameter("channelName", channelName);
			query.executeUpdate();
		
			et.commit();
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(em!=null) {
					em.close();
				}
			}
		
	}

	@Override
	public void deleteChannelById(Integer channelId) {
		EntityManager em=null;
		EntityTransaction et=null;
		try {
			em=emf.createEntityManager();
			et=em.getTransaction();
			et.begin();
			Query query=em.createQuery("DELETE FROM TVChannel WHERE channelId=:id");
			query.setParameter("id", channelId);
			query.executeUpdate();
			et.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(em!=null)
				em.close();
		}
		
		
	}

}
