package threadEx2;

public class Family implements Runnable {
	Account account = new Account();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(account.getBalance() > 0) {
			int money = (int)(Math.random()*5 + 1) * 100;
			account.withdraw(money);
		}
	}

}
