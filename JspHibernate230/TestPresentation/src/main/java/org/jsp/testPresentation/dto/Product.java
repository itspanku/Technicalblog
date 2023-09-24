package org.jsp.testPresentation.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pName;
	private String bName;
	private double price;
	private LocalDateTime mnd;
	@ManyToOne(cascade = CascadeType.ALL)
	private Marchent mer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDateTime getMnd() {
		return mnd;
	}
	public void setMnd(LocalDateTime mnd) {
		this.mnd = mnd;
	}
	public Marchent getMer() {
		return mer;
	}
	public void setMer(Marchent mer) {
		this.mer = mer;
	}
	
	
	

}
