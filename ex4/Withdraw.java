package ws9;

public class Withdraw extends Thread {
	private Account m_account;
	private int m_deposits;
	
	public Withdraw(Account account, double[] balance) {
		m_account = account;
		m_deposits = balance.length;
	}
	
	public void run() {
		for(int i = 0; i <= m_deposits; i++) {
			synchronized(m_account) {
				while(m_account.getBalance() != 0) {
					System.out.println("WITHDRAWALS:");
					m_account.withdraw(1);					
				}				
				try {
					m_account.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				m_account.notify();
			}	
		}
	}
}

