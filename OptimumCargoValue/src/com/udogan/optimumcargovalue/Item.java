package com.udogan.optimumcargovalue;

public class Item {
	private int id;
	private float weight;
	private float value;
	private double valueToWeightRatio;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public void setValueToWeightRatio() {
		this.valueToWeightRatio = this.value / this.weight;
	}
	public double getValueToWeightRatio() {
		return valueToWeightRatio;
	}
	
	public Item(Item item){
		this.id = item.id;
		this.weight = item.weight;
		this.value = item.value;
		setValueToWeightRatio();
	}
	
	@Override
	public String toString() {
		return "id: " + this.id + " weight: " + this.weight + " value: " + this.value + " v/w: " + this.valueToWeightRatio;
	}
}