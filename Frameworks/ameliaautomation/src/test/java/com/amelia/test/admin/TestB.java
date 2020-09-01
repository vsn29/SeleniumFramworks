package com.amelia.test.admin;

import java.util.ArrayList;
import java.util.Iterator;

public class TestB {

	public static void main(String[] args) {

		int array[] = { 1, 2, 3, 4, 5 };

		ArrayList list = new ArrayList();// creating old non-generic arraylist

		list.add("Karthik");
		list.add("Nishanth");
		list.add("Jay");
		list.add("Aanu");
		list.remove("Aanu");
		Iterator itr = list.iterator();
		System.out.println(list);

		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}

		/*
		 * System.out.println(array.length);
		 * 
		 * System.out.println(array[0]); System.out.println(array[1]);
		 * System.out.println(array[2]); System.out.println(array[3]);
		 * System.out.println(array[4]);
		 */

		for (int j = 0; j < array.length; j++) {

			System.out.println(array[j]);
		}

		System.out.println("=-----------------------------");
		for (int i = array.length - 1; i >= 0; --i) {

			System.out.println(array[i]);
		}
		
		System.out.println("Array Length :" +array.length);
		
		System.out.println("Arraylist Length :" +list.size());

	}

}
