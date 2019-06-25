package game;
/**
 * 
 * @author Agustin Bulzomi 
 * This interface is to garantece that objects who implments this interface have methods to fight.
 * It contains 4  methods:
 * 			atack: return int of the amount of damage is to be caused;
 * `		defenceYopurself: return an int of who can your defend yourself from an atack;
 * 			getAtacked: this method is to be used as a way to cause harm to an object.
 *			lifeleft: this metod is used to know how much life left does an object have.
 */
public interface Icombat {
	int atack();
	int defendYourself();
	void getAtacked(int damageRecieved);
	int lifeLeft();
}
