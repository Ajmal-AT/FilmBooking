package com.film.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.film.demo.beans.MovieDetails;
import com.film.demo.beans.OrderHistory;
import com.film.demo.beans.dateoperation;
import com.film.demo.beans.seat;
import com.film.demo.beans.user;

@Component
public class CustomerDAO {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Autowired
	private SeatRepo seatrepo;
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private HistoryRepo histrepo;
	
	public int save(user user) {
		userrepo.save(user);
		return 1;
	}
	
	public user login(String email, String password) {
		user customer = userrepo.findByEmailAndPassword(email, password);
		return customer;
	}
	
	public int saveSeat(seat seat, user user,String movieName, Date date, String time){
		List<seat> list = new ArrayList<seat>();
		list.add(seat);
		user.setSeat(list);
		dateoperation cdo= new dateoperation();
		cdo.setShowDate(date);
		cdo.setShowTime(time);
		cdo.setSeat(list);
		
		seat.setOperation(cdo);
		seat.setOperation(cdo);
		seat.setUser(user);
		seat save = seatrepo.save(seat);
		return 1;
	}
	
	public List<seat> getSeats(long id){
		List<seat> list = seatrepo.getAllSeat(id);
		return list;
	}
	
	public List<user> getAll(){
		List<user> findAll = userrepo.findAll();
		return findAll;
	}
	
	public OrderHistory saveHistory(OrderHistory history, user user) {
		user.setHistory(history);
		OrderHistory save = histrepo.save(history);
		return save;
	}
	
	public List<OrderHistory> getAllHistory(long id){
		List<OrderHistory> list = histrepo.getAllHistory(id);		
		return list;
	}
	
	public List<seat> getAllSeat(LocalDate date, String time){
		List<seat> list = seatrepo.getAllByDate(date, time);
		return list;
	}
	
	public void delete(long id) {
		seatrepo.deleteById(id);
	}
	
	public int updateDetail(user user) {
		userrepo.save(user);
		return 1;
	}
	
	public List<MovieDetails> getAllMovie(){
		List<MovieDetails> list = this.movieRepo.findAll();
		return list;
	}
	
	public List<MovieDetails> getAllMovieByMovieName(String movieName){
		List<MovieDetails> list = this.movieRepo.findAllBymovieName(movieName);
		return list;
	}
}
