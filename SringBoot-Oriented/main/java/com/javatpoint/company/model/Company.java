package com.javatpoint.company.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="company_details")
public class Company
{
@Override
	public String toString() {
		return "Company "+"\n"+"[id=" + id + ", company_name=" + company_name + ", phone=" + phone + ", email_id=" + email_id
				+ ", address=" + address + "]";
	}
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int id;
@Column
private String company_name;
@Column
private long phone;
@Column
private String email_id;
@Column
private String address;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getComapny_name() {
	return company_name;
}
public void setComapny_name(String company_name) {
	this.company_name = company_name;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}