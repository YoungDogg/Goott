package threadEx1;

class ThreadExThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i = 0; i < 50; i++) {			
			System.out.println(this.getName());
		}
	}
}

class ThreadRunnable implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {			
			System.out.println(Thread.currentThread().getName());
		}
	};
}

public class ThreadEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadExThread exThread = new ThreadExThread();
		exThread.start();
		
		Runnable r = new ThreadRunnable();
		Thread th2 = new Thread(r);
		th2.start();
	}

}
