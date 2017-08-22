package cn.kidjoker.JavaExercise.spring.bean;

public class Family {

	private Person person;
	
	private String familyName;

	public Family(Person person, String familyName) {
		super();
		this.person = person;
		this.familyName = familyName;
	}

	@Override
	public String toString() {
		return "Family [person=" + person + ", familyName=" + familyName + "]";
	}
	
}
