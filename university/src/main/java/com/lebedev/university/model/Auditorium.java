package com.lebedev.university.model;

public class Auditorium {

	private String name;
	private AuditoriumType type;
	private int capacity;

	public Auditorium(String name, AuditoriumType type, int capacity) {
		this.name = name;
		this.type = type;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public AuditoriumType getType() {
		return type;
	}

	public int getCapacity() {
		return capacity;
	}

}
