package com.service.order;


import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("transactions")
public class Transaction {
    @Id
    private String id;

    private String userId;
    private String stockName;
    private int quantity;
    private String status;
//    private String orderType;             // BUY or SELL
    
    
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transaction(String id, String userId, String stockName, int quantity, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.stockName = stockName;
		this.quantity = quantity;
		this.status = status;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
//    
//	public String getOrderType() {
//        return orderType;
//    }
//
//    public void setOrderType(String orderType) {
//        this.orderType = orderType;
//    }

    
}

