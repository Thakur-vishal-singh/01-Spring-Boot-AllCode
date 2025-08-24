package tech.vishal.entity;

public enum OrderStatus {

	ORDERED("ordered"),
	PROCESSED("processed"),
	DELIVERED("delivered"),
	REFUNDED("refunded"),
	CANCELED("canceled");
	
	// this all are the public static final variables and we can not use setter that because final we will use in the contractor  
	
	private String value;
	
	private OrderStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
