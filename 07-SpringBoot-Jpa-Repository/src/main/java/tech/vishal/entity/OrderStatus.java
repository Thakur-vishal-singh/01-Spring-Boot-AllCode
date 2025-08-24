package tech.vishal.entity;

public enum OrderStatus {

	ORDERED("ordered"),
	PROCESSED("processed"),
	DELIVERED("delivered"),
	REFUNDED("refunded"),
	CANCELED("cancled");
	
	private final String value;
	
	private OrderStatus(String value){
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
	
	
}
