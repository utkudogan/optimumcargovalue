package com.udogan.optimumcargovalue;

import java.util.ArrayList;
import java.util.Iterator;

public class Optimization {
	
	private ArrayList<Item> bestItemCombination = new ArrayList<Item>();
	private ArrayList<Item> tempItemList = new ArrayList<Item>();
	
	public void findBestItemCombination(ArrayList<Item> cargos, float neededTotalWeight) {
		ArrayList<ArrayList<ArrayList<Item>>> combinations = new ArrayList<ArrayList<ArrayList<Item>>>();
		ArrayList<Item> itemList = cloneItemList(cargos);
		float totalWeight = neededTotalWeight;
		
		ArrayListAllCombinations(combinations, itemList);
		compareItemCombinations();
	}

	private void ArrayListAllCombinations(ArrayList<ArrayList<ArrayList<Item>>> combinationAll, ArrayList<Item> itemList) {
		if (itemList.size() == 0) {
			return;
		}

		
		ArrayList<ArrayList<Item>> combinationType = new ArrayList<ArrayList<Item>>();
		ArrayList<Item> combinationSingle = new ArrayList<Item>();
		
		if () {

		}
		
		Iterator<ArrayList<ArrayList<Item>>> iteratorAll = combinationAll.iterator();
		Iterator<ArrayList<Item>> iteratorType = combinationType.iterator();		
		Iterator<Item> iteratorSingle = itemList.iterator();
		
		while (combinationAll.get(combinationAll.size() - 1).get(0).size() == itemList.size()) {
			while (iteratorSingle.hasNext()) {				
				if (combinationAll.size() == 0) {
					for (Item item : itemList) {
						combinationSingle.add(new Item(item));
					}			
					combinationType.add(combinationSingle);
					combinationAll.add(combinationType);
				}
				else {
					Item item = (Item) iteratorSingle.next();
					ArrayList<Item> itemCombination = new ArrayList<Item>();
					
					int allCombinationsCollectionSize = allCombinations.size();
					itemCombination = cloneItemList(allCombinations.get(allCombinationsCollectionSize - 1));
					Iterator<Item> iteratorAllCombinations = itemCombination.iterator();
					while (iteratorAllCombinations.hasNext()) {
						while (iteratorItemlist.hasNext()) {
							if (!itemCombination.contains(iteratorItemlist.next())) {
								itemCombination.add(iteratorItemlist.next());	
							}											
						}					
					}
					allCombinations.add(itemCombination);
					
					if (allCombinations.size() == itemList.size()) {
						return;
					}
				}			
			}						
		}
	}

	private void compareItemCombinations() {

		if (bestItemCombination.size() == 0) {
			bestItemCombination = cloneItemList(allCombinations.get(0));
		}
		
		for (ArrayList<Item> arrayList : allCombinations) {
			for (Item item : arrayList) {
				
			}
		}

		float bestCombinationWeight = 0;
		float tempCombinationWeight = 0;

		for (Item item : bestItemCombination) {
			bestCombinationWeight += item.getWeight();
		}

		for (Item item : tempItemList) {
			tempCombinationWeight += item.getWeight();
		}

		if (bestCombinationWeight > tempCombinationWeight) {
			return;
		} else if (bestCombinationWeight < tempCombinationWeight) {
			bestItemCombination = cloneItemList(tempItemList);
		} else {
			float bestCombinationValue = 0;
			float tempCombinationValue = 0;

			for (Item item : bestItemCombination) {
				bestCombinationValue += item.getValue();
			}

			for (Item item : tempItemList) {
				tempCombinationValue += item.getValue();
			}

			if (bestCombinationValue >= tempCombinationValue) {
				return;
			} else if (bestCombinationValue < tempCombinationValue) {
				bestItemCombination = cloneItemList(tempItemList);
			}
		}
	}

	public ArrayList<Item> cloneItemList(ArrayList<Item> itemList) {
		ArrayList<Item> clonedList = new ArrayList<Item>(itemList.size());

		for (Item item : itemList) {
			clonedList.add(new Item(item));
		}

		return clonedList;
	}
	
	@Override
	public String toString() {
		String bestCombination = "";
		
		for (Item item : bestItemCombination) {
			bestCombination = bestCombination + item.toString();
		}
		return super.toString();
	}

}
