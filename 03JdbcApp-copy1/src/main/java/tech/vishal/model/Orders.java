package tech.vishal.model;

public class Orders{

	
	private Integer OrderId;
	
	private String OrderName;
	
	private Integer OrderQuentity;

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public Integer getOrderQuentity() {
		return OrderQuentity;
	}

	public void setOrderQuentity(Integer orderQuentity) {
		OrderQuentity = orderQuentity;
	}

	public Orders(Integer orderId, String orderName, Integer orderQuentity) {
		super();
		OrderId = orderId;
		OrderName = orderName;
		OrderQuentity = orderQuentity;
	}

	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", OrderName=" + OrderName + ", OrderQuentity=" + OrderQuentity + "]";
	}
	
}
