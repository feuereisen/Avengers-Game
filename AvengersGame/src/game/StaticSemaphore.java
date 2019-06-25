package game;

import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

public class StaticSemaphore {
	public static String nameOfWeaponChoosedByUser;
	public static Semaphore mutex;
	public static Semaphore validString;
	public static Semaphore usedString;
	public static String choosed;
	public static Thread t1;
	public static JLabel lifeUser;
	public static JLabel lifeEnemy;
}
