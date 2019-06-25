package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Thread2 implements Runnable{
	
	public Thread2() {
		super();
	}

	@Override
	public void run() {
			String result= new String("");
			Battle<Character, Character> game = new Battle<Character, Character>();
			Character playerOne=Json.bringUpCharacter(StaticSemaphore.choosed);
			Character playerTwo=Json.bringUpCharacter("Thanos");

			StaticSemaphore.lifeUser.setFont(new Font("Lucida Calligraphy", 1,20));
			StaticSemaphore.lifeUser.setText(""+playerOne.lifeLeft());
			StaticSemaphore.lifeEnemy.setFont(new Font("Lucida Calligraphy", 1,20));
			StaticSemaphore.lifeEnemy.setText(""+playerTwo.lifeLeft());
			result=game.fightToDeath(playerOne, playerTwo);

			StaticSemaphore.lifeUser.setText(""+playerOne.lifeLeft());
			StaticSemaphore.lifeEnemy.setText(""+playerTwo.lifeLeft());
		
			
            try {
				
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StaticSemaphore.lifeUser.setFont(new Font("Lucida Calligraphy", 1,15));
			StaticSemaphore.lifeEnemy.setFont(new Font("Lucida Calligraphy", 1,15));
			if(result == "jugador1")
			{
				StaticSemaphore.lifeUser.setText("WINNER");
				StaticSemaphore.lifeEnemy.setText("LOSER");
			}else {
				if(result == "jugador2")
				StaticSemaphore.lifeEnemy.setText("WINNER");
				StaticSemaphore.lifeUser.setText("LOSER");
			}
			
			PlayersFile.writeFile(result);
			try {
				
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.exit(0);
			
	}
		
}
	


