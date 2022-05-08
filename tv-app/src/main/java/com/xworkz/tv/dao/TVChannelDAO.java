package com.xworkz.tv.dao;

import com.xworkz.tv.entity.TVChannel;

public interface TVChannelDAO {
	public void saveChannel(TVChannel tvChannel);
	public void getChannel();
	public TVChannel getChannelbyId(Integer channelId);
	public void updateChannelById(Double price,Integer channelId);
	public void deleteById(Integer channelId);
	public String getChannelNameById(Integer channelId);
	public void updateChannelPriceByChannelName(Double price,String channelName);
	public void deleteChannelById(Integer channelId);
}
