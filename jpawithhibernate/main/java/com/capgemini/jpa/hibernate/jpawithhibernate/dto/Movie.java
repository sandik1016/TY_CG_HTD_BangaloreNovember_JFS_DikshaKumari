package com.capgemini.jpa.hibernate.jpawithhibernate.dto;
import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@Column(name="movieid")
	private int mid;
	@Column(name="moviename")
	private String mname;
	@Column
	private String rating;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}


}
