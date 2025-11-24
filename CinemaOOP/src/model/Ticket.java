package model;

import java.util.ArrayList;

public class Ticket {
	private String id;
	private double ticketPrice;
	private ArrayList<Seat> seats;
	private Schedule schedule;
	private User user;
	public Ticket(String id, double ticketPrice, ArrayList<Seat> seats, Schedule schedule, User user) {
		super();
		this.id = id;
		this.ticketPrice = ticketPrice;
		this.seats = seats;
		this.schedule = schedule;
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
