package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * 
 * @author Celeste Masmut
 * 
 * This class is meant to be used to bring the information to create the characters
 *
 */
public class Json {
	public static Character bringUpCharacter(String nameOfCharacter) {
		String json=JsonUtiles.leer(nameOfCharacter);
		Character toReturn=null;
		try {
			JSONObject obj=new JSONObject(json);
			String name=obj.getString("Name");
			int life=obj.getInt("Life");
			int ambition=0;
			HashMap<String, Weapon> weaponsJava= new HashMap<String, Weapon>();
			JSONArray weapons=obj.getJSONArray("Weapons");
			String nameOfWeapon="";
			int MaxD, MinD, MaxDf,MinDf;
			for (int i = 0; i < weapons.length(); i++) {
				JSONObject weapon=weapons.getJSONObject(i);
				nameOfWeapon=weapon.getString("NameOfWeapon");
				MaxD=weapon.getInt("MaxDam");
				MinD=weapon.getInt("MinDam");
				MaxDf=weapon.getInt("MaxDef");
				MinDf=weapon.getInt("MinDef");
				
				if (weapon.has("Stones")) {
					ArrayList<Stone> stonesJava= new ArrayList<Stone>();
					JSONArray stones=weapon.getJSONArray("Stones");
					for (int j = 0; j < stones.length(); j++) {
						JSONObject stone =stones.getJSONObject(i);
						String nameOfStone=stone.getString("stoneName");
						int max=stone.getInt("Max");
						int min=stone.getInt("Min");
						stonesJava.add(new Stone(nameOfStone, max, min));
					}
					weaponsJava.put("InfinityGauntlet", new InfinityGauntlet("InfinityGauntlet",0,0,0,0,stonesJava));

				}else {
					weaponsJava.put(nameOfWeapon, new Weapon (nameOfWeapon, MaxD,MinD,MaxDf,MinDf));
				}
			}
			
			if (obj.has("ambition")) {
				ambition=obj.getInt("ambition");
				toReturn=new Villain(nameOfCharacter,life,weaponsJava,ambition);
			}else {
				toReturn=new Hero(nameOfCharacter, life, weaponsJava);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return toReturn;
		
	}
}
