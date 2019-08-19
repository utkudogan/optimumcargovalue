package com.udogan.optimumcargovalue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import jdk.nashorn.internal.objects.annotations.Where;

public class Runner {
	public static ArrayList<Item> bestItemCombination = new ArrayList<Item>();
	public static ArrayList<Item> tempItemList = new ArrayList<Item>();

	public static void main(String[] args) {
		ArrayList<Item> cargos = new ArrayList<Item>();

		for (int i = 0; i < 5; i++) {
			Item item = new Item();
			item.setId(i);
			item.setValue((float) (Math.random() * 20) + 1);
			item.setWeight((float) (Math.random() * 20) + 50);
			item.setValueToWeightRatio();
			cargos.add(item);
		}

		Collections.sort(cargos, new SortItemListByValueToWeight());

		for (Item item : cargos) {
			System.out.println(item);
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen kargonuzun toplamn aðýrlýðýný giriniz.");
		float neededTotalWeight = sc.nextFloat();
		findBestItemCombination(cargos, neededTotalWeight);
		
		for (Item item : bestItemCombination) {
			System.out.println("------------------------------------------------\n" + item);
		}
	}

	private static void findBestItemCombination(ArrayList<Item> cargos, float neededTotalWeight) {

		ArrayList<Item> itemList = cloneItemList(cargos);
		float totalWeight = neededTotalWeight;

		for (int i = 0; i < itemList.size(); i++) {
			Item item = itemList.get(i);

			if (item.getWeight() < totalWeight) {
				totalWeight -= item.getWeight();
				tempItemList.add(item);
				compareItemCombinations(bestItemCombination, tempItemList);
				itemList.remove(item);
				findBestItemCombination(itemList, totalWeight);
				
				/*
				Iterator<Item> iterator = itemList.iterator();

				while (iterator.hasNext()) {
					Item tempItem = iterator.next();
					if (tempItem.getWeight() < totalWeight) {
						totalWeight -= tempItem.getWeight();
						tempItemList.add(tempItem);
						compareItemCombinations(bestItemCombination, tempItemList);
						tempItemList.remove(tempItem);	
						totalWeight += tempItem.getWeight();
					}
				}
				*/
				
				totalWeight += item.getWeight();
				tempItemList.remove(item);
				findBestItemCombination(itemList, totalWeight);
				
			} else {
				itemList.remove(item);
				findBestItemCombination(itemList, totalWeight);
			}
		}		
	}

	private static void compareItemCombinations(ArrayList<Item> bestList, ArrayList<Item> tempList) {

		if (bestList.size() == 0) {
			bestItemCombination = cloneItemList(tempList);
			return;
		}

		float bestCombinationWeight = 0;
		float tempCombinationWeight = 0;

		for (Item item : bestList) {
			bestCombinationWeight += item.getWeight();
		}

		for (Item item : tempList) {
			tempCombinationWeight += item.getWeight();
		}

		if (bestCombinationWeight > tempCombinationWeight) {
			return;
		} else if (bestCombinationWeight < tempCombinationWeight) {
			bestItemCombination = cloneItemList(tempList);
		} else {
			float bestCombinationValue = 0;
			float tempCombinationValue = 0;

			for (Item item : bestList) {
				bestCombinationValue += item.getValue();
			}

			for (Item item : tempList) {
				tempCombinationValue += item.getValue();
			}

			if (bestCombinationValue >= tempCombinationValue) {
				return;
			} else if (bestCombinationValue < tempCombinationValue) {
				bestItemCombination = cloneItemList(tempList);
			}
		}
	}

	public static ArrayList<Item> cloneItemList(ArrayList<Item> itemList) {
		ArrayList<Item> clonedList = new ArrayList<Item>(itemList.size());

		for (Item item : itemList) {
			clonedList.add(new Item(item));
		}

		return clonedList;
	}
}