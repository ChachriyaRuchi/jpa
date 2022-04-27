package com.xworkz.jpa.runner;

import com.xworkz.jpa.dao.RestaurantJpaDAO;
import com.xworkz.jpa.entity.RestaurantJpaEntity;

public class RestaurantJpaUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestaurantJpaEntity jpe=new RestaurantJpaEntity();
		jpe.setRestaurantId(2);
		jpe.setName("A2B");
		jpe.setRating(4.6);
		jpe.setContactNo(8978475483L);
		RestaurantJpaDAO jpd=new RestaurantJpaDAO();
		jpd.saveData(jpe);
		}

}
