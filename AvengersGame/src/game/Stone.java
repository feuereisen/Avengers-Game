package game;
import java.util.Random;
/**
 * 
 * @author Agustin Bulzomi
 * This class is meant to be used by the @see InifinityGauntlet to produceAtacks and blockthem.
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author Agustin Bulzomi, Celeste Masmut & Martin Fernandez
 * This class is meant to be used to powered the Infinity Gauntlet
 *
 */

public class Stone {
	private int minLimit;
	private int maxLimit;
	private Random value;
	private String stoneName;
	
	private int getMinLimit() {
		return minLimit;
	}
	private void setMinLimit(int minLimit) {
		this.minLimit = minLimit;
	}
	private int getMaxLimit() {
		return maxLimit;
	}
	private void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	private Random getValue() {
		return value;
	}
	private void setValue(Random value) {
		this.value = value;
	}
	private String getStoneName() {
		return stoneName;
	}
	private void setStoneName(String stoneName) {
		this.stoneName = stoneName;
	}
	
	
	public Stone() {
		setMaxLimit(100);
		setMinLimit(1);
		setStoneName("");
		setValue(new Random());
	}
	
	public Stone (String stoneNamePassed, int maxium, int minimun) {
		setStoneName(stoneNamePassed);
		setMaxLimit(maxium);
		setMinLimit(minimun);
		setValue(new Random());
	}
	
	public int produceAtack() {
		int atackGenerated=0;
		atackGenerated=getValue().nextInt(getMaxLimit())+getMinLimit();
		return atackGenerated;
	}
	
	public int blockAtack() {
		int actackBlocked=0;
		actackBlocked=getValue().nextInt(getMaxLimit())+getMinLimit();
		return actackBlocked;
	}
	
	@Override
		public String toString() {
			String strToReturn=getStoneName();
			return strToReturn;
		}
	
	@Override
		public boolean equals(Object obj) {
			boolean isEqual=false;
			if (obj != null && obj instanceof Stone) {
				isEqual=true;
			}
			return isEqual;
		}
	
	public JSONObject getJsonFormat() {
		JSONObject toReturn= new JSONObject();
		try {
			toReturn.put("stoneName",this.getStoneName());
			toReturn.put("Max", this.getMaxLimit());
			toReturn.put("Min", this.getMinLimit());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toReturn;
		
	}
}
