package net.thanon.ai;

import java.util.ArrayList;

public class Network {
    ArrayList<Neuron> input = new ArrayList<Neuron>();
    ArrayList<Neuron> hidden = new ArrayList<Neuron>();
    ArrayList<Neuron> hidden2 = new ArrayList<Neuron>();
    ArrayList<Neuron> output = new ArrayList<Neuron>();
    public Network(int input, int hidden, int output) {
        for(int i = 0; i < input; i++){
            this.input.add(new Neuron(this.hidden));
        }
        for(int i = 0; i < input; i++){
            this.input.add(new Neuron(this.hidden2));
        }
        for(int i = 0; i < hidden; i++){
            this.input.add(new Neuron(this.output));
        }
        for(int i = 0; i < output; i++){
            this.input.add(new Neuron(null));
        }
    }
    public int[] compute(double[] inputVek) {
        int[] inputResult = new int[this.input.size()];
        int[] hiddenResult = new int[this.input.size()];
        int[] hiddenResult2 = new int[this.input.size()];
        int[] outputResult = new int[this.input.size()];
        for(int i = 0; i < this.input.size(); i++) {
            inputResult[i] = this.input.get(i).fire(inputVek);
        }
        for(int i = 0; i < this.hidden.size(); i++) {
            inputResult[i] = this.hidden.get(i).fire(inputResult);
        }
        for(int i = 0; i < this.hidden2.size(); i++) {
            inputResult[i] = this.hidden2.get(i).fire(hiddenResult);
        }
        for(int i = 0; i < this.output.size(); i++) {
            inputResult[i] = this.output.get(i).fire(hiddenResult2);
        }
        return outputResult;
    }
}
