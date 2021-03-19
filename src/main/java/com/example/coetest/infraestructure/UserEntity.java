package com.example.coetest.infraestructure;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.coetest.domain.Phones;
import com.example.coetest.domain.User;

@Entity
@Table(name = "usuarios")
public class UserEntity {
	private final static Logger logger = LoggerFactory.getLogger(UserEntity.class);
	
	@Id
	private UUID id;
	private String name;
	private String email;
	private String password;
	private Date created;
	private Date modified;
	@Column(name="LASTLOGIN")
	private LocalDateTime lastLogin;
	private String active;
	private String token;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	@JoinColumn(name = "id_user")
	private List<PhoneEntity> phones;
	
	public UserEntity() {
	}

	public UserEntity(User user) {
		this.id = UUID.randomUUID();
		logger.info("ID User: "+ this.id.toString());
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.created = new Date();
		this.modified = new Date();
		this.lastLogin = (LocalDateTime.now());
		this.active = "1";
		this.token = user.getToken().getToken();
		this.phones = transformPhones(user);
	}
	
	private List<PhoneEntity> transformPhones(User user) {
		List<PhoneEntity> phoneEntList = new ArrayList<PhoneEntity>();
		logger.info("phones: "+user.getPhones());
		for(Phones phones : user.getPhones()) {
			logger.info("llega2:"+phones.getCityCode());
			phoneEntList.add(new PhoneEntity(phones.getNumber(), phones.getCountryCode(), phones.getCityCode()));
		}
		return phoneEntList;
	}

	public String getToken() {
		return token;
	}

	public Date getCreated() {
		return created;
	}

	public Date getModified() {
		return modified;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public String getActive() {
		return active;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}