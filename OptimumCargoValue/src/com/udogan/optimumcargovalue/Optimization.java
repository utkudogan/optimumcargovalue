package com.udogan.optimumcargovalue;

import java.util.ArrayList;
import java.util.Iterator;

public class Optimization {
	private ArrayList<ArrayList<Item>> allCombinations = new ArrayList<ArrayList<Item>>();
	private ArrayList<Item> bestItemCombination = new ArrayList<Item>();
	private ArrayList<Item> tempItemList = new ArrayList<Item>();
	
	public void findBestItemCombination(ArrayList<Item> cargos, float neededTotalWeight) {

		ArrayList<Item> itemList = cloneItemList(cargos);
		float totalWeight = neededTotalWeight;
		
		ArrayListAllCombinations(itemList);
		compareItemCombinations();
		
		/*

		for (Item i : itemList) {
			Item item = new Item(i);

			if (item.getWeight() < totalWeight) {
				totalWeight -= item.getWeight();
				tempItemList.add(item);
				compareItemCombinations(bestItemCombination, tempItemList);
				itemList.remove(item);
				findBestItemCombination(itemList, totalWeight);
				
				
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
				
				
				totalWeight += item.getWeight();
				tempItemList.remove(item);
				findBestItemCombination(itemList, totalWeight);
				
			} else {
				itemList.remove(item);
				findBestItemCombination(itemList, totalWeight);
			}
		}	
		*/	
	}

	private void ArrayListAllCombinations(ArrayList<Item> itemList) {
		Iterator<Item> iteratorItemlist = itemList.iterator();
		
		while (iteratorItemlist.hasNext()) {
			Item item = (Item) iteratorItemlist.next();
			ArrayList<Item> itemCombination = new ArrayList<Item>();
			
			if (allCombinations.size() == 0) {
				itemCombination.add(item);
				if (itemCombination.size() == itemList.size()) {
					allCombinations.add(itemCombination);
				}
			}
			else {
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
