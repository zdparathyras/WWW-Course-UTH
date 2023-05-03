package myPackage;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class food {
	@Id
	private String name;  // food's name
	private String sname; //store's name
	private String category; //food's category
	private Double cost;  // food's cost
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
}
