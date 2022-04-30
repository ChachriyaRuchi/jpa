package com.xworkz.clothesapp.runner;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.xworkz.clothesapp.dao.ClothesDAO;
import com.xworkz.clothesapp.dao.ClothesDAOImpl;
import com.xworkz.clothesapp.entity.ClothesEntity;

public class ClothesUtil {

	
	public static void main(String[] args) {
		ClothesEntity clothes=new ClothesEntity();
		
		 clothes.setId(8); clothes.setBrand("Reebok"); clothes.setPrice(2400.00);
		 clothes.setManufacturedYear(new GregorianCalendar(2015, 05, 11));
		 
		ClothesDAO dao=new ClothesDAOImpl();
		dao.saveData(clothes);
		
		dao.getClothesById(2);
		dao.updateClotheBrandAndPriceById("ZARA", 2400.00, 3);
		dao.updateManufacturedYearById(new GregorianCalendar(2017,Calendar.JANUARY,10),4);
		dao.deleteById(8);
		System.out.println("sucess");
	}

}
