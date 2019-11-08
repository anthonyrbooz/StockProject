package com.stock;

public class DividendStock extends Stock {

	private Double dividendPaid;
	
	public DividendStock(String stockSymbol, Integer numberOfShares, Double stockPrice, Double dividendPaid) {
		super(stockSymbol, numberOfShares, stockPrice);
		// TODO Auto-generated constructor stub
		this.dividendPaid = dividendPaid;
	}

	public Double getDividendPaid() {
		return dividendPaid;
	}

	public void setDividendPaid(Double dividendPaid) {
		this.dividendPaid = dividendPaid;
	}

}
