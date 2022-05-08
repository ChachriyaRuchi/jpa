package com.xworkz.tv.runner;

import com.xworkz.tv.dao.TVChannelDAO;
import com.xworkz.tv.dao.TVChannelDAOImpl;
import com.xworkz.tv.entity.TVChannel;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TVChannel tv=new TVChannel();
		tv.setChannelId(8);
		tv.setChannelName("NDXW");
		tv.setLanguage("Hindi");
		tv.setPrice(130.99);
		tv.setFree(false);
		TVChannel tv1=new TVChannel();
		tv1.setChannelId(9);
		tv1.setChannelName("Time11");
		tv1.setLanguage("English");
		tv1.setPrice(141.99);
		tv1.setFree(false);
		TVChannel tv2=new TVChannel();
		tv2.setChannelId(10);
		tv2.setChannelName("Repddsd");
		tv2.setLanguage("Hindi");
		tv2.setPrice(120.99);
		tv2.setFree(false);
		TVChannel tv3=new TVChannel();
		tv3.setChannelId(11);
		tv3.setChannelName("Newsdks");
		tv3.setLanguage("Kannada");
		tv3.setPrice(154.99);
		tv3.setFree(false);
		TVChannelDAO tvdao=new TVChannelDAOImpl();
		//tvdao.saveChannel(tv);
		//tvdao.saveChannel(tv1);
	//	tvdao.saveChannel(tv2);
		//tvdao.saveChannel(tv3);
		tvdao.getChannel();
		System.out.println(tvdao.getChannelbyId(2));
		//tvdao.updateChannelById(178.00, 8);
	 	//tvdao.deleteById(4);
		
		System.out.println("success");
		String result=tvdao.getChannelNameById(3);
		System.out.println("Channel Name is :" +result);
		tvdao.updateChannelPriceByChannelName(361.00, "NDTV");
		tvdao.deleteChannelById(11);
		
	}

}
