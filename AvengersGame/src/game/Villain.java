package game;

import java.util.HashMap;
import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author Agustin Bulzomi
 * @version 0.1
 * This class is meant to be use to create objects that are specifications of Character.
 * It extends from @see Character
 *
 */
public class Villain extends Character{
	private int ambition;

	private int getAmbition() {
		return ambition;
	}

	private void setAmbition(int ambition) {
		this.ambition = ambition;
	}
	
	
	public Villain() {
		super();
		setAmbition(0);
	}
	
	public Villain(String namePased, int lifePased, HashMap<String, Weapon> weaponsPassed,int ambitionPased) {
		super(namePased, lifePased, weaponsPassed);
		setAmbition(ambitionPased);
	}

	@Override
	public int atack() {
		int value=0;
		String []keys=super.getWeaponsKeys();
		if (keys.length >0) {
			
			String keySelected=keys[new Random().nextInt(keys.length)];
			Weapon ToUse=super.getWeapon(keySelected);
			value=ToUse.causeHarm();
		}
		
		return value;
	}

	@Override
	public int defendYourself() {
		int value=0;
		String []keys=super.getWeaponsKeys();
		if (keys.length >0) {
			String keySelected=keys[new Random().nextInt(keys.length)];
			Weapon ToUse=super.getWeapon(keySelected);
			value=ToUse.defend();
		}
		
		return value;
	}




	
	@Override
	public String toString() {
		
		return super.toString() +" "+ getAmbition();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isEqual=false;
		if (obj != null && obj instanceof Villain) {
			Villain temporary=(Villain) obj;
			if (temporary.toString().equals(this.toString())){
				isEqual=true;
			}
		}
		return super.equals(obj)&&isEqual;
	}
	
	@Override
	public JSONObject getJsonFormt() {
		JSONObject toReturn= super.getJsonFormt();
		try {
			toReturn.put("ambition", this.getAmbition());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toReturn;
	}
}
