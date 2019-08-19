package com.udogan.optimumcargovalue;

import java.util.Comparator;

public class SortItemListByValueToWeight implements Comparator<Item>{

	@Override
	public int compare(Item a, Item b) {
		if (a.getValueToWeightRatio() > b.getValueToWeightRatio()) {
			return -1;
		}
		else if (a.getValueToWeightRatio() == b.getValueToWeightRatio()) {
			if (a.getWeight() < b.getWeight()) {
				return 1;
			}
			else if (a.getWeight() > b.getWeight()) {
				return -1;
			}
			else {
				return 0;
			}
		}
		else {
			return 1;
		}
	}
}