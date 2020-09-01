package com.dailypractice;

//Swapping two variables
//========================
//The simplest method to swap two variables is to use a third temporary variable 
//     define swap(a, b)
//     temp := a
//     a := b
//     b := temp


public class SwappingDemo {

	public static void main(String[] args) {

		int a, b, temp;
		a = 15;
		b = 27;
		System.out.println("Before swapping : a, b = " + a + ", " + +b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("After swapping : a, b = " + a + ", " + +b);
	}
}
