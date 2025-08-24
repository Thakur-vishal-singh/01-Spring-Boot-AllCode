package tech.vishal.entity;

public enum OrderStatus {

	ORDERED("orderded"),
	DELIVERED("delivered"),
	REFUNDED("refunded"),
	CANCELED("canceled"),
	PROCESSED("processed");
	
	
	private final String value;
	
	OrderStatus(String value){
		this.value=value;
	}
	
	
	public String getValue() {
		return value;
	}
	
	
}
