package edu.sn.neural;

import java.util.ArrayList;
import java.util.List;

import edu.sn.data.PlayerData;

/**
 * Siec neuronowa 2 warstwowa.
 * Kazda warstwa ma tyle neuronow ile jest statystyk gracza
 * W pierwszej warstwie wchodza parami te same staty. 1 z statystyk gracza a drugi z statystyk poziomu (level data)
 * W drugiej warstwie jest wszystko ze wszystkim. Kazde wyjscie z pierwszej warstwy wchodzi do kazdego neuronu w drugiej warstwie
 * 
 * @author Zibi
 *
 */
//TODO: Ustawic tresholdy
//TODO: Ustawic wagi

public class NeuralNetwork {
	private List<Neuron> firstLayer;
	private List<Neuron> secondLayer;
	
	public NeuralNetwork(){
		int adaptations=PlayerData.getADAPTATIONS().size();
		firstLayer=new ArrayList<Neuron>();
		secondLayer=new ArrayList<Neuron>();
		
		//ustawic tresholdy i wagi
		for(int i=0;i<adaptations;i++){
			firstLayer.add(new Neuron());
			secondLayer.add(new Neuron());
		}
		
		setInitialWeights();
	}
	
	public void setInitialWeights(){
		for(int i=0;i<PlayerData.getADAPTATIONS().size();i++){
			firstLayer.get(i).getWeights().add(0.3);
			firstLayer.get(i).getWeights().add(0.6);
			for(int j=0;j<PlayerData.getADAPTATIONS().size();j++){
				secondLayer.get(i).getWeights().add(i/10.0);
					
			}
		}
	}
	public void setInitialWeight(double[][] firstLayer, double[][] secondLayer){
		
	}
	
	public void sendSignal(PlayerData playerAdaptations, PlayerData levelData){
		for(int i=0;i<PlayerData.getADAPTATIONS().size();i++){
			firstLayer.get(i).getInputs().clear();
			secondLayer.get(i).getInputs().clear();
		}
		
		for(int i=0;i<PlayerData.getADAPTATIONS().size();i++){
			firstLayer.get(i).getInputs().add(playerAdaptations.get(PlayerData.getADAPTATIONS().get(i)));
			firstLayer.get(i).getInputs().add(levelData.get(PlayerData.getADAPTATIONS().get(i)));
			double output=firstLayer.get(i).calculateOutput();
			
			for(int j=0;j<PlayerData.getADAPTATIONS().size();j++){
				secondLayer.get(j).getInputs().add(output);
			}
		}
		for(int i=0;i<secondLayer.size();i++){
			double output=secondLayer.get(i).calculateOutput();
			System.out.println("out"+i+" -> "+output);
		}
		
		
	}
}
