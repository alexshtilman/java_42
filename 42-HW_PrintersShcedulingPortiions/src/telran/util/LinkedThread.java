package telran.util;

public class LinkedThread extends Thread {

	private LinkedThread next;
	private int numbers;
	private int portion;
	private String threadName;
	
	
	public LinkedThread(int numbers, int portion, String threadName) {
		super();
		this.numbers = numbers;
		this.portion = portion;
		this.threadName = threadName;
	}

	public void setNext(LinkedThread next) {
		this.next = next;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.currentThread().join();
			} catch (InterruptedException e) {
				for(int i=0;i<portion&&numbers>0;i++) {
					numbers--;	
					System.out.printf(threadName);
				}
				System.out.println();
				next.interrupt();
				if(numbers<=0) return;
			}
		}
	}
}
