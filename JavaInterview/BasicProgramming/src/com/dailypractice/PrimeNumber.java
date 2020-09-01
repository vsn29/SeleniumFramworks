package com.dailypractice;

import java.util.Scanner;

//Prime Number:

//====================

//Prime number is a number that is greater than 1 and divided by 1 or itself only.

//For example 2, 3, 5, 7, 11, 13, 17.... are the prime numbers.
public class PrimeNumber {

	public static void main(String args[]) {
		int i, m = 0, flag = 0;
		int n = 3;// it is the number to be checked
		
		Scanner sc = new Scanner(System.in);
		sc.hasNextLine();
		System.out.println("Enter a number to check ,it is a prime or not" +n);
		
		m = n / 2;
		if (n == 0 || n == 1) {
			System.out.println(n + " is not prime number");
		} else {
			for (i = 2; i <= m; i++) {
				if (n % i == 0) {
					System.out.println(n + " is not prime number");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(n + " is prime number");
			}
		} // end of else
	}

}
