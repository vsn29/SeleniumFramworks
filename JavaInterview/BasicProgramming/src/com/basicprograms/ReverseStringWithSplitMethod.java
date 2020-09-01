package com.basicprograms;

import java.util.Scanner;

public class ReverseStringWithSplitMethod {
	
	
	public static void main(String[] args)
	{
		String str;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string to reverse :");
		str = sc.nextLine();
		String[] arr= str.split("");
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr.length);
		
		for(int i=arr.length-1;i>=0;i--) {
			
			System.out.print(arr[i] + "");
		}
		
		
		
		
		
	}

}
