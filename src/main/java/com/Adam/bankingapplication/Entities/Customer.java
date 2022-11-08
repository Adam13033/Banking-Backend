package com.Adam.bankingapplication.Entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private int id;

	private String name;

	private String email;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private String role;

	@Column(name = "create_dt")
	private Date createDt;

	public Customer (String email, String password, String role, String mobileNumber, String name) {
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Customer() {}

	public Customer (String email, String password, String role, String mobileNumber, String name, Date createDt) {
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
		this.createDt = createDt;
	}

	public int getId () {
		return id;
	}

	public void setId (int id) {
		this.id = id;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getEmail () {
		return email;
	}

	public void setEmail (String email) {
		this.email = email;
	}

	public String getMobileNumber () {
		return mobileNumber;
	}

	public void setMobileNumber (String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String password) {
		this.password = password;
	}

	public String getRole () {
		return role;
	}

	public void setRole (String role) {
		this.role = role;
	}

	public Date getCreateDt () {
		return createDt;
	}

	public void setCreateDt (Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public String toString () {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", mobileNumber='" + mobileNumber + '\'' +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				", createDt='" + createDt + '\'' +
				'}';
	}
}
