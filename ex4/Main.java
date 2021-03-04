package ws9;

public class Main {
	public static void main(String[] args) {
		
		double[] balance = {1,2,3};
		String[] currency = {"Dollar","Euro(s)","Pound(s)"};
		
		Account account = new Account(0,"");		
		Thread deposit = new Thread(new Deposit(account,balance,currency));
		Thread withdraw = new Thread(new Withdraw(account,balance));
		
		deposit.start();
		withdraw.start();
		
		try {
			deposit.join();
			withdraw.join();
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}

	}

}
