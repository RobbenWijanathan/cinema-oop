package model;

public class Seat {
	private String id;
	private boolean booked;
	private int row;
	private int column;
	private String ticketId;
	private String scheduleId;
	public Seat(String id, boolean booked, int row, int column) {
		super();
		this.id = id;
		this.booked = booked;
		this.row = row;
		this.column = column;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
}
