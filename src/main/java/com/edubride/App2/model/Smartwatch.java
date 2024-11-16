package com.edubride.App2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Smartwatch")
public class Smartwatch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Brand;
    private Integer Price ;
    private String colour;
    private String  ScreenSize;
	private String Weight;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public Integer getPrice() {
		return Price;
	}
	public void setPrice(Integer price) {
		Price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getScreenSize() {
		return ScreenSize;
	}
	public void setScreenSize(String screenSize) {
		ScreenSize = screenSize;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	@Override
	public String toString() {
		return "Smartwatch [id=" + id + ", Brand=" + Brand + ", Price=" + Price + ", colour=" + colour + ", ScreenSize="
				+ ScreenSize + ", Weight=" + Weight + "]";
	}
	
	
	

}
