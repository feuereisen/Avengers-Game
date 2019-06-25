package game;

import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author Agustin Bulzomi
 * @version 0.2
 * This class is an specification of class weapon that overwrite  method @see {@link Weapon#causeHarm()} and @see {@link Weapon#defend()}
 *	It contains method that genrate a value for that atack method and a the defnd method
 */
public class InfinityGauntlet extends Weapon{
	private ArrayList<Stone> infinityStones;
	
	
	
	
	private ArrayList<Stone> getInfinityStones() {
		return infinityStones;
	}


	private void setInfinityStones(ArrayList<Stone> infinityStones) {
		this.infinityStones = infinityStones;
	}


	public InfinityGauntlet() {
		super("InfinityGauntlet");
		setInfinityStones(new ArrayList<Stone>());
	}
	
	public InfinityGauntlet(ArrayList<Stone> stoneForTheGauntlet) {
		super("InfinityGauntlet");
		setInfinityStones(stoneForTheGauntlet);
	}
	
	public InfinityGauntlet(String nameOfWeaponPassed, int maxDam, int minDam, int maxDef, int minDef,ArrayList<Stone> stoneForTheGauntlet) {
		super(nameOfWeaponPassed,maxDam,minDam,maxDef,minDef);
		setInfinityStones(stoneForTheGauntlet);
	}
	
	
	private int generateValueAtack() throws ArithmeticException{
		if (getInfinityStones().size()==0) {
			throw new ArithmeticException();
		}
		return getInfinityStones().get(new Random().nextInt(getInfinityStones().size())).produceAtack();
	}
	
	
	
	private int generateValueDefend() throws ArithmeticException{
		if (getInfinityStones().size()==0) {
			throw new ArithmeticException();
		}
		return getInfinityStones().get(new Random().nextInt(getInfinityStones().size())).blockAtack();
	}
	
	@Override
	public int causeHarm() {
		int harmToCause=0;
		try {
			harmToCause=generateValueAtack();
		}catch (ArithmeticException e) {
			harmToCause=0;
		}
		return harmToCause+2*getInfinityStones().size();
	}
	
	@Override
	public int defend() {
		int harmBlocked=0;
		try {
			harmBlocked=generateValueDefend();
		}catch (ArithmeticException e) {
			harmBlocked=0;
		}
		return harmBlocked+2*getInfinityStones().size();
	}
	
	@Override
		public String toString() {
			String strToReturn=""+getInfinityStones().size();
			return super.toString()+" "+strToReturn;
		}
	
	@Override
		public boolean equals(Object obj) {
			boolean isEqual=false;
			if (obj != null && obj instanceof InfinityGauntlet) {
				InfinityGauntlet temporary=(InfinityGauntlet) obj;
				if (temporary.toString().equals(this.toString())) {
					isEqual=true;
				}
			}
			return isEqual;
		}
	
	@Override
	public JSONObject getJsonFormat() {
		JSONObject upper=super.getJsonFormat();
		try {
			
			JSONArray stones= new JSONArray();
			for (int i = 0; i < getInfinityStones().size(); i++) {
				stones.put(getInfinityStones().get(i).getJsonFormat());
			} 
			upper.put("Stones", stones);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return upper;
	}
}
