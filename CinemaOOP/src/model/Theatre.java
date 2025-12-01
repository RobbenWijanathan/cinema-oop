package model;

import java.util.ArrayList;

public class Theatre {
	private String id;
	private String name;
	private ArrayList<Studio> studios;
	public Theatre(String id, String name, ArrayList<Studio> studios) {
		super();
		this.id = id;
		this.name = name;
		this.studios = studios;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Studio> getStudios() {
		return studios;
	}
	public void setStudios(ArrayList<Studio> studios) {
		this.studios = studios;
	}
}
