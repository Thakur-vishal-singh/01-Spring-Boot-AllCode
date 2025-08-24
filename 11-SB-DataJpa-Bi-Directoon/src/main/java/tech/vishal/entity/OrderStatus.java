package tech.vishal.entity;

public enum OrderStatus {
	
	DELIVERED("ordered"),
	CANCELED("canceled"),
	REFUNDED("refuened"),
	PROCESSED("processed"),
	ORDERED("ORDERED");
	
	private final String value;
	
  private OrderStatus(String value){
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
	
}
