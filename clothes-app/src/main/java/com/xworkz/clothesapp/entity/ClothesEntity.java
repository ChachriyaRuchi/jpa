package com.xworkz.clothesapp.entity;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="clothes")
public class ClothesEntity {
	
	
	@Id
	@Column(name="clothes_id")
	private int id;
	@Column(name="clothes_brand")
	private String brand;

	private double price;
	private Calendar manufacturedYear;
	public void setManufacturedYear(Calendar manufacturedYear2) {
		this.manufacturedYear=manufacturedYear2;
		
	}
	
	 
	 
	
}
