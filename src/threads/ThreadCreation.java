package threads;

class Runn extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
		System.out.println("Hello");
		try {
			Thread.sleep(10);
		}
			catch(InterruptedException e) { e.printStackTrace();}
		}
	
	}
}

class Sit extends Thread{
	public void run() {
		for(int i=0;i<50;i++) {
		System.out.println("Sittig");
		try {
			Thread.sleep(10);
		}
			catch(InterruptedException e) { e.printStackTrace();}
	}
	}
}

public class ThreadCreation {
	public static void main(String args[]) {
		
		Runn a = new Runn();
		Sit b = new Sit();
		a.setPriority(Thread.MAX_PRIORITY);
		a.start();
		try {
			Thread.sleep(10);
		}
			catch(InterruptedException e) { e.printStackTrace();}
		b.start();
		
	}

}
