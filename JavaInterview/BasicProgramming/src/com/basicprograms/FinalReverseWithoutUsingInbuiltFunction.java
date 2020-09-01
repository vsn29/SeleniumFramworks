package com.basicprograms;

public class FinalReverseWithoutUsingInbuiltFunction {
	
	public static void main(String args[]) {
		
		String str = "Nishanth";
		
		char chars[] = str.toCharArray();
		
		for(int i=chars.length-1; i>=0; i--) {
			
			System.out.print(chars[i]);
		}
		
		
		
	}

}
