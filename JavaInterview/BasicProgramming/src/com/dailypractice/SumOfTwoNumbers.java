package com.dailypractice;

import java.util.Scanner;

public class SumOfTwoNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input the first number: ");
		int num1 = sc.nextInt();
		System.out.print("Input the second number: ");
		int num2 = sc.nextInt();
		int sum = num1 + num2;
		System.out.println();
		System.out.println("Sum: " + sum);
	}
}
