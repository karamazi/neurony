package edu.sn.neural;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
	private List<Double> weights;
	private List<Double> inputs;
	private double output;
	
	public Neuron(){
		weights=new ArrayList<Double>();
		inputs=new ArrayList<Double>();
	}
	
	public List<Double> getWeights() {
		return weights;
	}
	public void setWeights(List<Double> weights) {
		this.weights = weights;
	}
	public List<Double> getInputs() {
		return inputs;
	}
	public void setInputs(List<Double> inputs) {
		this.inputs = inputs;
	}
	public double getOutput() {
		return output;
	}
	
	public double calculateOutput(){
		if(weights.size()!=inputs.size())
			System.err.println("Inputs list and weights list must be of equal size");
		output=0;
		for(int i=0;i<weights.size();i++)
			output+=inputs.get(i)*weights.get(i);
		
		return activationFunction(output);
	}
	
	private double activationFunction(double t){
		return 1.0/(1.0+Math.exp(-t));
	}
}
