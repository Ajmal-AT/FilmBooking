package com.film.demo.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private long sId;
	
	@ElementCollection
	private List<String> seatNo;
	
	@ElementCollection
	private List<Double> price;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="total")
	private double total;
	
	@ManyToOne
	private user user;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private dateoperation operation;
	
	
	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public List<String> getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(List<String> seatNo) {
		this.seatNo = seatNo;
	}

	public List<Double> getPrice() {
		return price;
	}

	public void setPrice(List<Double> price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public dateoperation getOperation() {
		return operation;
	}

	public void setOperation(dateoperation operation) {
		this.operation = operation;
	}

	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	
	public seat(List<String> seatNo, List<Double> price, String movieName, double total,
			com.film.demo.beans.user user, dateoperation operation) {
		super();
		this.seatNo = seatNo;
		this.price = price;
		this.movieName = movieName;
		this.total = total;
		this.user = user;
		this.operation = operation;
	}

	public seat(long sId, List<String> seatNo, List<Double> price, String movieName, double total,
			com.film.demo.beans.user user, dateoperation operation) {
		super();
		this.sId = sId;
		this.seatNo = seatNo;
		this.price = price;
		this.movieName = movieName;
		this.total = total;
		this.user = user;
		this.operation = operation;
	}

	public seat() {
		super();
	}

	@Override
	public String toString() {
		return "seat [sId=" + sId + ", seatNo=" + seatNo + ", price=" + price + ", movieName=" + movieName + ", total="
				+ total + ", user=" + user + ", operation=" + operation + "]";
	}

		
	
}
