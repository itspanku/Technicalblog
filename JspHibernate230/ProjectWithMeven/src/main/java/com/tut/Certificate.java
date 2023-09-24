package com.tut;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String cource;
	private String duration;
	
	public Certificate() {
		super();
	}
	public Certificate(String cource, String duration) {
		super();
		this.cource = cource;
		this.duration = duration;
	}
	public String getCource() {
		return cource;
	}
	public void setCource(String cource) {
		this.cource = cource;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	

}
