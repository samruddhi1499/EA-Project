package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String userId;
    private String stockName;
    private int quantity;
    private double price;
    private String status;
    
    private User user;
    
    
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String userId, String stockName, int quantity, double price, String status, User user) {
		super();
		this.id = id;
		this.userId = userId;
		this.stockName = stockName;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.user = user;	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
    
    
    
}
