package model;

import java.util.ArrayList;

public class IMAXStudio extends Studio {
	public IMAXStudio(String id, int number, double basePrice, int seatCapacity,Movie movie, ArrayList<Schedule> schedules,
			Theatre theatre) {
		super(id, number, basePrice, seatCapacity, "IMAX", movie, schedules, theatre);
		this.type = "IMAX";
	}
}
