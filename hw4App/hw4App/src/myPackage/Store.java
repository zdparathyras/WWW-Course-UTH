package myPackage;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
	@Id
	private String email;
	private String sname;
	private String manager_fname;
	private String manager_lname;
	private String sphone;
	private String address;
	private String adm_area;
	private String spassword;
	private boolean reservations;
	private String category;
	private int minutes; //mesos xronos anamonis
	private int minimun; //elaxisto kostos paraggelias
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getManager_fname() {
		return manager_fname;
	}
	public void setManager_fname(String manager_fname) {
		this.manager_fname = manager_fname;
	}
	public String getManager_lname() {
		return manager_lname;
	}
	public void setManager_lname(String manager_lname) {
		this.manager_lname = manager_lname;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdm_area() {
		return adm_area;
	}
	public void setAdm_area(String adm_area) {
		this.adm_area = adm_area;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public boolean isReservations() {
		return reservations;
	}
	public void setReservations(boolean reservations) {
		this.reservations = reservations;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getMinimun() {
		return minimun;
	}
	public void setMinimun(int minimun) {
		this.minimun = minimun;
	}
}
	
