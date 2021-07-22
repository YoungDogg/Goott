package threadEx2;

public class Account {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void withdraw(int money) {
		synchronized (this) {
			System.out.println(Thread.currentThread() + " : " + money);
			if (this.balance >= money) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				System.out.println("인출 성공");
				this.balance -= money;
			} else {
				System.out.println("no money");
			}
			System.out.println(this.balance);
		}
	}
}
