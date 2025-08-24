package tech.vishal.entity;

public enum PersonGender {

	
	MALE("male"),
	FEMALE("female"),
	TRANGENDER("trangender");
	
	private String value;
	
	private PersonGender(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
	
	
}
