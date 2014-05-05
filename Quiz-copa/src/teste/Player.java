package teste;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Player {
	public Player(BufferedInputStream bis) {
		// TODO Auto-generated constructor stub
	}

	public void playMe(){
		try{

		Player player;
		File file=new File("audio/Vinheta_Champions.mp3");
		FileInputStream fis     = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		player = new Player(bis);

		player.playMe();

		}catch(Exception e){
		System.out.print("ERROR "+e);
		}

		}
}
