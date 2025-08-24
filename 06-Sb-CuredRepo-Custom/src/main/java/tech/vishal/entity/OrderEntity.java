////package tech.vishal.entity;
////
////import java.time.LocalDate;
////
////import jakarta.persistence.Column;
////import jakarta.persistence.Entity;
////import jakarta.persistence.EnumType;
////import jakarta.persistence.Enumerated;
////import jakarta.persistence.Id;
////import jakarta.persistence.Table;
////import lombok.AllArgsConstructor;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////
////
////@Entity
////@Table(name="orders2")
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
////public class OrderEntity {
////
////	@Id
////	@Column(name="ORDER_ID")
////	private Long orderId;
////
////	@Column(name="CUSTOMER_ID")
////	private Long customerId;
////
////	@Column(name="DATE_PURCHASED")
////	private LocalDate datePurchased;
////
////	@Enumerated(value = EnumType.STRING)
////	@Column(name ="STATUS")
////	private OrderStatus orderStatus;
////
////
////}
//package tech.vishal.entity;
//
//import java.time.LocalDate;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name ="ORDERS2")
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class OrderEntity {
//
//	@Id
//	@Column(name="ORDER_ID")
//	private Long orderId;
//	
//	@Column(name="CUSTOMER_ID")
//	private Long customerId;
//	
//	@Column(name="DATE_PURCHASED")
//	private LocalDate datePurchased;
//
//	@Enumerated(value = EnumType.STRING)
//	@Column(name ="STATUS")
//	private OrderStatus orderStatus;
//	
//}
package tech.vishal.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="ORDERS2")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {

	@Id
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	
	@Column(name="DATE_PURCHASED")
	private LocalDate datePurchased;

	@Enumerated(value = EnumType.STRING)
	@Column(name ="STATUS")
	private OrderStatus orderStatus;
	
}
