package com.Adam.bankingapplication.DTO;



public class CustomerDTO {


	private int id;

	private String name;

	private String email;

	private String mobileNumber;

	private String password;

	private String role;

	private String createDt;

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

	public String getCreateDt () {
		return createDt;
	}

	public void setCreateDt (String createDt) {
		this.createDt = createDt;
	}


	@Override
	public String toString () {
		return "CustomerDTO{" +
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


