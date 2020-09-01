package com.basicprograms;

import java.util.Scanner;

public class SwappingNumbers {

	public static void main(String args[]) {

		int x, y, temp;
		System.out.println("enter 2 numbers to swap");
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		System.out.println("Before swapping :" + x + y);
		temp = x;
		x = y;
		y = temp;

		System.out.println("After swapping :" + x + y);

	}
}
