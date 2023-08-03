package com.film.demo.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "current_date_operation")
public class dateoperation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "date_id")
	private long DateId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "show_date")
	private Date showDate;
	
	@Column(nullable = true)
	private String movieName;
	
	@Column(name = "show_time")
	private String showTime;
	
	@OneToMany(mappedBy = "operation", fetch = FetchType.EAGER)
	private List<seat> seat;

	public long getDateId() {
		return DateId;
	}

	public void setDateId(long dateId) {
		DateId = dateId;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public List<seat> getSeat() {
		return seat;
	}

	public void setSeat(List<seat> seat) {
		this.seat = seat;
	}

	public dateoperation(long dateId, Date showDate, String movieName, String showTime,
			List<com.film.demo.beans.seat> seat) {
		super();
		DateId = dateId;
		this.showDate = showDate;
		this.movieName = movieName;
		this.showTime = showTime;
		this.seat = seat;
	}

	public dateoperation(Date showDate, String movieName, String showTime, List<com.film.demo.beans.seat> seat) {
		super();
		this.showDate = showDate;
		this.movieName = movieName;
		this.showTime = showTime;
		this.seat = seat;
	}
	
	public dateoperation() {
		super();
	}

	@Override
	public String toString() {
		return "dateoperation [DateId=" + DateId + ", showDate=" + showDate + ", movieName=" + movieName + ", showTime="
				+ showTime + ", seat=" + seat + "]";
	}
	
}
