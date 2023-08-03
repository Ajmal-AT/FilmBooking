package com.film.demo.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	private long uid;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<seat> seat;
	
	@OneToOne(mappedBy = "user",  fetch = FetchType.EAGER)
	private OrderHistory history;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public OrderHistory getHistory() {
		return history;
	}

	public void setHistory(OrderHistory history) {
		this.history = history;
	}

	public List<seat> getSeat() {
		return seat;
	}

	public void setSeat(List<seat> seat) {
		this.seat = seat;
	}

	public user(long uid, String name, String email, String password, List<com.film.demo.beans.seat> seat,
			OrderHistory history) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.seat = seat;
		this.history = history;
	}

	
	public user(String name, String email, String password, List<com.film.demo.beans.seat> seat, OrderHistory history) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.seat = seat;
		this.history = history;
	}

	public user() {
		super();
	}

	@Override
	public String toString() {
		return "user [uid=" + uid + ", name=" + name + ", email=" + email + ", password=" + password + ", seat=" + seat
				+ ", history=" + history + "]";
	}
	
}
