package teste;

public class Teste {

	public static void main(String[] args) {
		
		Contador contador = new Contador();
		
		Thread t1  = new Thread(contador);
		t1.start();
	}
}
