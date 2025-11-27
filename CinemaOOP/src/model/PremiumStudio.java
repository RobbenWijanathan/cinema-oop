package model;

import java.util.ArrayList;

public class PremiumStudio extends Studio {
	public PremiumStudio(String id, int number, double basePrice, int seatCapacity, Movie movie,
			ArrayList<Schedule> schedules, Theatre theatre) {
		super(id, number, basePrice, seatCapacity, "Premium", movie, schedules, theatre);
		this.type = "Premium";
	}

}
