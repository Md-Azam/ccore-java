package threads;

public class ThreadsDay36 {

	public static void printTable(int n) throws InterruptedException {
		for(int i=0;i <=10;i++) {
		System.out.println(n + " * "+ i + " = "+ n*i);
		Thread.sleep(200);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
		Runnable t1 = ()->{
			try {
				printTable(2);
				System.out.println("Thread Name is: "+ Thread.currentThread().getName());
			}catch(InterruptedException e) {
				throw new RuntimeException(e);
			}
		};
		
		Runnable t2 =() -> {
			try {
				printTable(3);
				System.out.println("Thread Name is: "+ Thread.currentThread().getName());
			}catch(InterruptedException e) {
				throw new RuntimeException(e);
			}	
		};
		new Thread(t1).start();
		new Thread(t2).start();
		
	}
}
