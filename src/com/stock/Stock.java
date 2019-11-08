package com.stock;

public class Stock {
	private String stockSymbol;
	private Integer numberOfShares;
	private Double stockPrice;
	
	public Stock(String stockSymbol, Integer numberOfShares, Double stockPrice) {
		super();
		this.stockSymbol = stockSymbol;
		this.numberOfShares = numberOfShares;
		this.stockPrice = stockPrice;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public Integer getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(Integer numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public Double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}
	
}
