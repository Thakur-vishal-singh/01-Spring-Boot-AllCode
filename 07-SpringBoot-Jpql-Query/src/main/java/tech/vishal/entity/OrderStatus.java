package tech.vishal.entity;

public enum OrderStatus {

	
	ORDERED("ordersed"),
	PROCESSED("processed"),
	CANCELED("canceled"),
	REFUNDED("refunded"),
	DELIVERED("delivered");
	
	private final String value;
	
	private OrderStatus(String value) {
		this.value=value;
	}
	
	public String getValue(){
		return value;
	}
	
}
