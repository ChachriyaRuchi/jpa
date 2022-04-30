package com.xworkz.clothesapp.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.xworkz.clothesapp.entity.ClothesEntity;

public interface ClothesDAO {
	public void saveData(ClothesEntity clothesEntity);
	public ClothesEntity getClothesById(Integer id);
	public void updateClotheBrandAndPriceById(String brand,Double price,Integer id);
	public void updateManufacturedYearById(Calendar manufacturedYear,Integer id);
	public void deleteById(Integer id);
}
