package tech.vishal.entity;

public enum OrderStatus {

	
	ORDERED("ordered"),
	PROCESSED("processed"),
	CANCELED("canceled"),
	REFUNDED("refunded"),
	DELIVERED("delivered");
	
	private String value;
	
	
	private  OrderStatus(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
	
}
