package game;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 * @author Martin fernandez & Celeste Masmut
 * This class is meant to write a file to save the player who wins the fight;
 * It uses exceptions because the method close() and constructor of FileOutputStream() throw them.
 *
 */

public class PlayersFile {

	public static void writeFile(String player) {
		FileOutputStream fco = null;
		DataOutputStream pkm = null;
		try {
			fco = new FileOutputStream("Players.bin", true); // use boolean to keep writing without deleting.
			pkm = new DataOutputStream(fco);
			pkm.writeUTF(player);  //Writes the String player in the file
			pkm.close();
			fco.close();
		} catch (IOException e) {
			e.printStackTrace(); //Just in case that close() method throw an exception
		}
	}

	public static ArrayList<String> readFile() {
		ArrayList<String> players = new ArrayList<String>(); //Create an ArrayList of players to fill it with the String we collect from the file 
		String player = "";
		FileInputStream myfile = null;
		DataInputStream mydata = null;
		try {
			myfile = new FileInputStream("Players.bin");
			mydata = new DataInputStream(myfile);
			while (true) {
				player = mydata.readUTF(); //This line of code assign the String red from the file in player (String variable)

				players.add(player); //Add player to the arraylist 
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
		} finally {
			try {
				if (myfile != null) {
					myfile.close();
				}
				if (mydata != null) {
					mydata.close();
				}
			} catch (IOException e) { 
				e.printStackTrace(); //Just in case that close() method throw an exception
			}
		}
		
		return players;

	}
	
	
}