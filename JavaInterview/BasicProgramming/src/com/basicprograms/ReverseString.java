package com.basicprograms;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * String str = "Vijayalaxmi";
		 */
		System.out.println("Enter a string to reverse: ");
		String str = sc.next();

		StringBuilder str2 = new StringBuilder();

		str2 = str2.append(str);
		str2 = str2.reverse();

		System.out.println(str2);

	}

}
