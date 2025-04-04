package com.service.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("fees")
public class Fee {

    @Id
    private String id;

    private String userId;
    private String stockName;
    private int quantity;
    private double price;
    private double fee;
    
	public Fee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fee(String id, String userId, String stockName, int quantity, double price, double fee) {
		super();
		this.id = id;
		this.userId = userId;
		this.stockName = stockName;
		this.quantity = quantity;
		this.price = price;
		this.fee = fee;
	}

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

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	
    
    
}
