package com.xworkz.tv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="tv_channel")
public class TVChannel {
	@Id
	@Column(name="channel_id")
	private int channelId;
	@Column(name="channel_name")
	private String channelName;
	private String language;
	private double price;
	@Column(name="is_free")
	private boolean isFree;
}
