package edu.sn.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/**
 * Opisuje wszystkie statystyki gracza
 * @author Zibi
 *
 */
public class PlayerData extends LinkedHashMap<String, Double>{
	public final static String STONE="Stone";
	public final static String GRASS="Grass";
	public final static String WATER="Water";
	public final static String SAND="Sand";
	public final static String FOREST="Forest";
	public final static String CARNIVORE="Carnivore";
	public final static String HERBIVORE="Herbivore";
	public final static int NUMBER_OF_STATS=7; //bo zakret, czasami trzeba cos z palca wpisac
	
	private static List<String> ADAPTATIONS;
	/**
	 * Zwraca liste nazw wszystkich statystyk.
	 * @return lista nazw
	 */
	public static List<String> getADAPTATIONS(){
		return ADAPTATIONS;
	}
	
	static{
		ADAPTATIONS=new ArrayList<String>();
		ADAPTATIONS.add(STONE);
		ADAPTATIONS.add(GRASS);
		ADAPTATIONS.add(WATER);
		ADAPTATIONS.add(SAND);
		ADAPTATIONS.add(FOREST);
		ADAPTATIONS.add(CARNIVORE);
		ADAPTATIONS.add(HERBIVORE);	
	}
	
	/**
	 * Tworzy nowy obiekt z losowymi wartosciami dla kazdego atrybutu
	 */
	public PlayerData(){
		Random rand=new Random();
		for(String s : ADAPTATIONS)
			this.put(s,rand.nextDouble());
	}
	
}
