package com.stock;

public class StockAccount {
	private String name;
	private Double balance;
	private static final Double DEFAULT_BALANCE = 1000.0;
	private Stock accountStock;
	
	public StockAccount(String name) {
		// super();
		this(name, DEFAULT_BALANCE);
	}

	public StockAccount(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Stock getAccountStock() {
		return accountStock;
	}
	
	public void buyStock(Stock stock) {
		Double totalAmount = stock.getStockPrice() * stock.getNumberOfShares();
		Integer stockShares = stock.getNumberOfShares();
		if (totalAmount > balance) {
			System.out.println("You cannot buy that much stock. The max number of whole shares will be purchased.");
			stockShares = (int) (balance / stock.getStockPrice());
			totalAmount = stockShares * stock.getStockPrice();
		}
		
		balance = balance - totalAmount;
		System.out.println("You have bought " + stockShares + " share(s) of "
		+ stock.getStockSymbol() + " at $" + stock.getStockPrice() + " per share.");
		if (accountStock != null) {
			accountStock = new Stock(stock.getStockSymbol(), stockShares + accountStock.getNumberOfShares(), stock.getStockPrice());
		} else {
			accountStock = new Stock(stock.getStockSymbol(), stockShares, stock.getStockPrice());
		}
		
		//if (stock)
	}
	
	public void sellStock(Stock stock) {
		Double totalAmount = stock.getStockPrice() * stock.getNumberOfShares();
		Integer stockShares = stock.getNumberOfShares();
		
		if (accountStock == null) {
			System.out.println("You do not have any stock to sell.");
			return;
		}
		
		if (!stock.getStockSymbol().equals(accountStock.getStockSymbol())) {
			System.out.println("You don't own this stock.");
			return;
		}
		
		if (stock.getNumberOfShares() > accountStock.getNumberOfShares()) {
			System.out.println("You don't own this many shares of " + stock.getStockSymbol() + ". Selling max number of shares.");
			stockShares = accountStock.getNumberOfShares();
			totalAmount = stock.getStockPrice() * stockShares;
		}

		balance = balance + totalAmount;
		accountStock.setStockPrice(stock.getStockPrice());
		accountStock.setNumberOfShares(accountStock.getNumberOfShares() - stockShares);
		System.out.println("You have sold " + stockShares + " share(s) of "
		+ stock.getStockSymbol() + " at $" + stock.getStockPrice() + " per share.");
	}
	
}
