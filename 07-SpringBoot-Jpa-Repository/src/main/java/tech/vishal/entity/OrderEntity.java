package tech.vishal.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders2")
public class OrderEntity {

	@Id
	private Long orderId;
	
	private Long customerId;
	
	private LocalDate datePurchased;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private OrderStatus orderStatus;
	
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public LocalDate getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(LocalDate datePurchased) {
		this.datePurchased = datePurchased;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderEntity(Long orderId, Long customerId, LocalDate datePurchased, OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.datePurchased = datePurchased;
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", customerId=" + customerId + ", datePurchased=" + datePurchased
				+ ", orderStatus=" + orderStatus + "]";
	}

	public OrderEntity() {
		super();
	}
	
	
	
}
