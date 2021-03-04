package ws9;

public class Deposit extends Thread {
		private Account m_account;
		private double[] m_balance;
		private String[] m_currency;
		

		public Deposit(Account account, double[] balance,String[] currency) {
			m_account = account;
			m_balance = balance;
			m_currency = currency;
		}

		public void run() {
			for(int i = 0; i < m_balance.length; i++) {
				synchronized(m_account) {
					while(m_account.getBalance() != 0) {
						try {
							m_account.wait();							
						} catch(InterruptedException e) {
							e.getMessage();
							Thread.currentThread().interrupt();
						}
					}		
					System.out.println("DEPOSITS: ");
					m_account.deposit(m_balance[i], m_currency[i]);	
					m_account.notify();
				}
			} 
		}
}
