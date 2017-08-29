package cn.kidjoker.JavaExercise.spring.bean;

import java.util.List;

public class Family {

	private List<Person> persons;
	
	private String familyName;

	public Family() {
	}
	
	public Family(List<Person> persons, String familyName) {
		super();
		this.persons = persons;
		this.familyName = familyName;
	}
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Override
	public String toString() {
		return "Family [person=" + persons + ", familyName=" + familyName + "]";
	}
	
}
