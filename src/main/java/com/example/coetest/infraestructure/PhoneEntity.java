package com.example.coetest.infraestructure;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

@Entity
@Table(name = "phones")
@Getter
public class PhoneEntity {
	private final static Logger logger = LoggerFactory.getLogger(PhoneEntity.class);
	@Id
	private UUID id;
	private String number;
	@Column(name="countrycode")
	private String countryCode;
	@Column(name="citycode")
	private String citycode;
	public PhoneEntity() {}
	
	public PhoneEntity(String number, String countryCode, String citycode) {
		this.id= UUID.randomUUID();
		logger.debug("ID Phone generated: "+ this.id.toString());
		this.number = number;
		this.countryCode = countryCode;
		this.citycode = citycode;
	}
}
