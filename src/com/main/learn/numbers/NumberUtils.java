package com.main.learn.numbers;

public class NumberUtils {

	public static boolean checkIfNumber(String number){
		try{
			Integer.parseInt(number);
			return true;
		} catch(NumberFormatException e)
		{
			return false;
		}
				 
	}
	public static void main(String[] args) {
		String number= "12345678abcdef";
		boolean b= checkIfNumber(number);
		if(b)
			System.out.println(number+ " is a valid integer");
		else
			System.out.println(number+" is not a valid integer");
	}

}
