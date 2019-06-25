package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

/**
 * 
 *
 * This is the main class, this class it's just for makeing the game start
 *
 */
public class Main {

	public static void main(String[] args) {
		
		
		Welcome welcome=new Welcome();
		StaticSemaphore.mutex=new Semaphore(1);
		StaticSemaphore.validString= new Semaphore(0);
		StaticSemaphore.usedString=new Semaphore(1);
		StaticSemaphore.nameOfWeaponChoosedByUser="";
		StaticSemaphore.choosed="";
		StaticSemaphore.lifeUser= new JLabel("");
		StaticSemaphore.lifeEnemy= new JLabel("");
		

	}

}
