package teste;

public class Contador implements Runnable{

	
	@Override
	public void run() {
		for (int i = 10; i > -1; i--) {
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			System.out.println("Contador "+i);
			
		}
		
	}
}
