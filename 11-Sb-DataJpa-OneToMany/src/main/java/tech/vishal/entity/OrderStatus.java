package tech.vishal.entity;

public enum OrderStatus {

	ORDERED("ordered"),
	CANCELED("canceled"),
	PROCESSED("processed"),
	DELIVERED("delivered"),
	REFUNDED("refunded");
	
	private final String value;
	
    OrderStatus(String value) {
    	this.value=value;
    }
	
   public String setValue(){ 
    return value;
	}
	
 
	
	
}
