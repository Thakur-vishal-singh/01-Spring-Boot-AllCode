package tech.vishal.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tech.vishal.model.Orders;

@Repository
public class ApplicationRepo {

     @Autowired
	JdbcTemplate jdbc;
	
	public void save(Orders order) {
		String query = " insert into orders values(?,?,?)";
		jdbc.update(query,order.getOrderId(),order.getOrderName(),order.getOrderQuentity());
	}
	
	
	public void findById(int id) {
		String query = "select * from orders where orderId = ?";
		Map<String, Object> values = jdbc.queryForMap(query,id);
		values.forEach((K,V) -> System.out.println(K+" :"+V));
	}
	
	
	public void findByAll() {
		List<Map<String, Object>> values = jdbc.queryForList("select * from orders");
		System.out.println("all order now show");
		for(Map<String, Object> val : values) {
			val.forEach((K,V) -> System.out.println(K+" : "+V) );
			System.out.println("==".repeat(20));
		}
		System.out.println("all order now show end");
	}
	
	
	
	public void updateQuentity(int orderId, int quentity) {
		int i = jdbc.update("update orders set orderQun = ? where orderId =?",quentity,orderId);
		System.out.println(i);
	}
	
	public int deleteById(int empId) {
		String query = "delete from Orders where orderId = ?";
		int i = jdbc.update(query,empId);
		return i;
	}
	
	
	
}
