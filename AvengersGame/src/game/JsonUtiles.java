package game;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonUtiles {
	public static void grabar(JSONArray array) {
		try {
			FileWriter file = new FileWriter("test1.json");
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void grabar(JSONObject object) {
		try {
			FileWriter file = new FileWriter("test1.json");
			file.write(object.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void grabar(JSONObject object, String urlToFile) {
		try {
			FileWriter file = new FileWriter(urlToFile+".json");
			file.write(object.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void grabar(JSONArray array, String urlToFile) {
		try {
			FileWriter file = new FileWriter(urlToFile+".json");
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static String leer() 
	{
		String contenido = "";
		try 
		{
			contenido = new String(Files.readAllBytes(Paths.get("test.json")));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return contenido;
	}
	
	public static String leer(String urlToFile) 
	{
		String contenido = "";
		try 
		{
			contenido = new String(Files.readAllBytes(Paths.get(urlToFile+".json")));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return contenido;
	}
}
