package com.Adam.bankingapplication.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "contact_messages")
public class Contact {
	@Id
	@Column(name = "contact_id", nullable = false, length = 50)
	private String id;

	@Column(name = "contact_name", nullable = false, length = 50)
	private String contactName;

	@Column(name = "contact_email", nullable = false, length = 100)
	private String contactEmail;

	@Column(name = "subject", nullable = false, length = 500)
	private String subject;

	@Column(name = "message", nullable = false, length = 2000)
	private String message;

	@Column(name = "create_dt")
	private Date createDt;

	public String getId () {
		return id;
	}

	public void setId (String id) {
		this.id = id;
	}

	public String getContactName () {
		return contactName;
	}

	public void setContactName (String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail () {
		return contactEmail;
	}

	public void setContactEmail (String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getSubject () {
		return subject;
	}

	public void setSubject (String subject) {
		this.subject = subject;
	}

	public String getMessage () {
		return message;
	}

	public void setMessage (String message) {
		this.message = message;
	}

	public Date getCreateDt () {
		return createDt;
	}

	public void setCreateDt (Date createDt) {
		this.createDt = createDt;
	}

	public void setContactId (String id) {
		this.id = id;
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (!(o instanceof Contact contact)) return false;

		if (getId() != null ? !getId().equals(contact.getId()) : contact.getId() != null) return false;
		if (getContactName() != null ? !getContactName().equals(contact.getContactName()) : contact.getContactName() != null)
			return false;
		if (getContactEmail() != null ? !getContactEmail().equals(contact.getContactEmail()) : contact.getContactEmail() != null)
			return false;
		if (getSubject() != null ? !getSubject().equals(contact.getSubject()) : contact.getSubject() != null)
			return false;
		if (getMessage() != null ? !getMessage().equals(contact.getMessage()) : contact.getMessage() != null)
			return false;
		return getCreateDt() != null ? getCreateDt().equals(contact.getCreateDt()) : contact.getCreateDt() == null;
	}

	@Override
	public int hashCode () {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getContactName() != null ? getContactName().hashCode() : 0);
		result = 31 * result + (getContactEmail() != null ? getContactEmail().hashCode() : 0);
		result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
		result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
		result = 31 * result + (getCreateDt() != null ? getCreateDt().hashCode() : 0);
		return result;
	}

	@Override
	public String toString () {
		return "Contact{" +
				"id='" + id + '\'' +
				", contactName='" + contactName + '\'' +
				", contactEmail='" + contactEmail + '\'' +
				", subject='" + subject + '\'' +
				", message='" + message + '\'' +
				", createDt=" + createDt +
				'}';
	}
}