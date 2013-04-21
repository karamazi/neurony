package edu.sn.app;

import edu.sn.data.PlayerData;
import edu.sn.neural.NeuralNetwork;

public class Main {
	public static void main(String[] args){
		NeuralNetwork a=new NeuralNetwork();
		PlayerData levelData=new PlayerData();
		PlayerData playerData=new PlayerData();
		a.sendSignal(playerData, levelData);
	}
}
