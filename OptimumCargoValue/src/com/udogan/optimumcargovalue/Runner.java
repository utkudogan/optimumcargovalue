package com.udogan.optimumcargovalue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import jdk.nashorn.internal.objects.annotations.Where;

public class Runner {


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
		
		Optimization o = new Optimization();
		o.findBestItemCombination(cargos, neededTotalWeight);
	}


}