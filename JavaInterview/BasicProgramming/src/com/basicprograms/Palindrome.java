package com.basicprograms;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {

		int r, sum = 0, temp, n = 454;
		/*
		 * 
		 * System.out.println("Enter a number to check the no. is palindrome or not");
		 * Scanner sc = new Scanner(System.in); sc.nextLine();
		 */
		temp = n;
		while (n > 0) {

			r = n % 10;

			sum = (sum * 10) + r;

			n = n / 10;
		}

		if (temp == sum) {

			System.out.println("The no. is palindrome: "  +temp);
		} else {
			System.out.println("The no is not a palindrome: " +temp);
		}
	}

}
