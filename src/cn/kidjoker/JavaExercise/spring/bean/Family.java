package cn.kidjoker.JavaExercise.spring.bean;

import java.util.List;

public class Family {

	private List<Person> persons;
	
	private String familyName;

	public Family(List<Person> persons, String familyName) {
		super();
		this.persons = persons;
		this.familyName = familyName;
	}

	@Override
	public String toString() {
		return "Family [person=" + persons + ", familyName=" + familyName + "]";
	}
	
}
