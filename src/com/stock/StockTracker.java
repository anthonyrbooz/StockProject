package com.stock;
import java.util.Scanner;

public class StockTracker {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		printIntro();
		
		StockAccount account = collectAccountInfo();
		printAccountSummary(account);
		
		while(true) {
			System.out.println("Press 'b' to buy stock, and press 's' to sell. Press 'q' to quit.");
			String doNext = scan.next();
			
			if (doNext.equalsIgnoreCase("b")) {
				System.out.println("You will now be buying stock. Have fun!");
				Stock InfoBuy = collectStockInfo();	
				account.buyStock(InfoBuy);
				printAccountSummary(account);
			} else if (doNext.equalsIgnoreCase("s")) {
				System.out.println("You will now be selling stock. Have fun!");
				Stock InfoSell = collectStockInfo();
				account.sellStock(InfoSell);
				printAccountSummary(account);
			} else if (doNext.equalsIgnoreCase("q")) {
				break;
			} else {
				System.out.println("Not a valid character entry. Please try again.");
			}
		}
		
		scan.close();
		
	}

	private static StockAccount collectAccountInfo() {
		//Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your FULL name and hit <ENTER>(We will not track first and last name separately):");
		String name = scan.nextLine();
		
		System.out.println("Welcome, " + name + "! Please enter the initial balance of your stock account and hit <ENTER>:");
		Double balance = scan.nextDouble();
		
		StockAccount account;
		
		if (balance < 0) {
			System.out.println("\nYou entered a negative balance. Your balance is initialized to $1000.0.");
			account = new StockAccount(name);
			return account;
		} else {
			account = new StockAccount(name, balance);
			return account;
		}
	}

	private static void printAccountSummary(StockAccount account) {
		System.out.println("\nYour account details:"
				+ "\nName: " + account.getName()
				+ "\nAccount Balance: " + account.getBalance());
		if (account.getAccountStock() != null) {
			System.out.println("You own " + account.getAccountStock().getNumberOfShares() 
			+ " shares of " + account.getAccountStock().getStockSymbol() + " valued at " + account.getAccountStock().getStockPrice() + ".");
		} else {
			System.out.println("You do not own any stock.\n");
		}
	}

	private static void printIntro() {
		System.out.println("Hello! Welcome to the Stock Tracker program!"
				+ "\nThis program will help you track information"
				+ "\nabout your investments.\n");
	}
	
	private static Stock collectStockInfo() {
		scan.nextLine();
		System.out.println("Please enter the stock symbol, then press <ENTER>: ");
		String symbol = scan.nextLine();
		
		System.out.println("Please enter the desired number of shares as a whole number, then press <ENTER>: ");
		Integer shares = scan.nextInt();
		
		System.out.println("Please enter the price of the stock, then press <ENTER>: ");
		Double price = scan.nextDouble();
		
		System.out.println("Is this a dividend stock? (y) or (n) and hit <ENTER>:");
		String isDividend = scan.nextLine();
		
		Double dividend;
		if (isDividend.toLowerCase().equals("y")) {
			System.out.println("Please enter the amount of the dividend and hit <ENTER>");
			dividend = scan.nextDouble();
			
			DividendStock dividendStock = new DividendStock(symbol, shares, price, dividend);
			return dividendStock;
		}
		
		Stock stock = new Stock(symbol, shares, price);
		
		return stock;	
	}

}
