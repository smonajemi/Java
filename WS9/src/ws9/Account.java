package ws9;

public class Account {
	
	private double m_balance;
	private String m_currency;
	
	// Constructor
	Account(double balance, String currency) {
		m_balance = balance;
		m_currency = currency;
	}
	
	// Balance
	public void setBalance(double balance) {
		m_balance = balance;
	}
	public double getBalance() {
		return m_balance;
	}
	
	// Currency
	public void setCurrency(String currency) {
		m_currency = currency;
	}	
	public String getCurrency() {
		return m_currency;
	}
	
	// Deposits
	public synchronized void deposit(double balance, String currency) {
		while(getBalance() != 0) {
			try {				
				wait();
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}				
		setCurrency(currency);
		setBalance(m_balance += balance);
		System.out.println("Deposited: " + String.format("%.2f", getBalance()) + " " + getCurrency());
		System.out.println("Balance: " + String.format("%.2f", getBalance()) + " " + getCurrency() + "\n");
		notify();
	}
	
	// Withdrawal
	public synchronized void withdraw(double balance) {
		while(getBalance() < balance) {
			try {
				System.out.println("ERROR-Insufficient Funds!\n");
				wait();
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}		
		setBalance(m_balance -= balance);
		System.out.println("Withdrew: " + String.format("%.2f", balance) + " " + getCurrency());	
		System.out.println("Balance: " + String.format("%.2f", getBalance()) + " " + getCurrency() + "\n");
		notify();
	}		
}
