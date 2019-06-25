package game;

import javax.swing.plaf.SliderUI;

/**
 * 
 * @author Agustin Bulzomi
 * This class is meant to be used for making two objects fight each other to death.
 * It has two methods, fightToDeath(T playerOne, K playerTwo ) which returns a string, and OneAtackEach(T playerOne, K playerTwo ).
 *
 * @param <T> Whatever implements icombat
 * @param <K> Whatever implements icombat
 */
public class Battle <T extends  Icombat, K extends Icombat> {
	
	

	public Battle() {
		super();
	}
	/**
	 * This class compares the lifeleft() of the two characters. While both of them still have life, they will keep fighting.
	 * @param playerOne
	 * @param playerTwo
	 * @return The winner 
	 */
	public String fightToDeath(T playerOne, K playerTwo ) {
		
		String winner="";
		while(playerOne.lifeLeft()>0 && playerTwo.lifeLeft()>0) {
			OneAtackEach(playerOne, playerTwo);
			/*System.out.println("Player1: "+playerOne.lifeLeft());
			System.out.println("Player2: "+playerTwo.lifeLeft());*/
		
		}
		
		if (playerOne.lifeLeft()<=0&&playerTwo.lifeLeft()<=0) {
			winner="tie";
		}else {
			if (playerOne.lifeLeft()<=0) {
				winner="jugador2";
			}else {
				winner="jugador1";
			}
				
		}
		
		
		return winner;
	}
	/**
	 * This class produce each attack, and uses Semaphore to maintain the concurrence. 
	 * @param playerOne
	 * @param playerTwo
	 */
	private void OneAtackEach(T playerOne, K playerTwo ) {
		playerTwo.getAtacked(playerOne.atack());
		StaticSemaphore.lifeUser.setText(""+playerOne.lifeLeft());
		playerOne.getAtacked(playerTwo.atack());
		StaticSemaphore.lifeEnemy.setText(""+playerTwo.lifeLeft());
	}

}
