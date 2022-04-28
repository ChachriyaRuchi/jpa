package com.xworkz.tv.runner;

import com.xworkz.tv.dao.TVChannelDAO;
import com.xworkz.tv.dao.TVChannelDAOImpl;
import com.xworkz.tv.entity.TVChannel;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TVChannel tv=new TVChannel();
		tv.setChannelId(1);
		tv.setChannelName("NDTV");
		tv.setLanguage("Hindi");
		tv.setPrice(130.99);
		tv.setFree(false);
		TVChannel tv1=new TVChannel();
		tv.setChannelId(2);
		tv.setChannelName("Times Now");
		tv.setLanguage("English");
		tv.setPrice(135.99);
		tv.setFree(false);
		TVChannelDAO tvdao=new TVChannelDAOImpl();
		tvdao.saveChannel(tv);
		tvdao.saveChannel(tv1);
		tvdao.getChannel();
		System.out.println("success");
	}

}
