package com.main.learn.numbers;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NumberUtils {

	public static boolean checkIfNumber(String number){
		try{
			Integer.parseInt(number);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}

	public static boolean checkIfBoolean(int number){
		int copyOfNumber= number;
		while (copyOfNumber != 0) {
			int temp = copyOfNumber%10; //Gives last digit of the number
			if(temp > 1) {
				return false;
			}
			else
				copyOfNumber = copyOfNumber/10;    //Removes last digit from the number
		}
		return true;
	}

	public static void generateRandomNumbers(){
		Random random = new Random();
		for(int i = 0; i < 5; i++) {
			System.out.println("Random Integers using Random class: "+random.nextInt());
			System.out.println("Random Integers using ThreadLocalRandom: "+ ThreadLocalRandom.current().nextInt());
		}
		System.out.println("-----------------------------");

		for(int i = 0; i < 5; i++) {
			System.out.println("Random Doubles using Random class: "+random.nextDouble());
			System.out.println("Random Integers using ThreadLocalRandom: "+ ThreadLocalRandom.current().nextDouble());
			System.out.println("Random Integers using Math.random: "+Math.random());
		}
		System.out.println("-----------------------------");

		for(int i = 0; i < 5; i++) {
			System.out.println("Random booleans using Random class: "+random.nextBoolean());
			System.out.println("Random Integers using ThreadLocalRandom: "+ ThreadLocalRandom.current().nextBoolean());
		}
	}
	public static int  secondLargestNumber(int[] numbers){
		int secondLargest= numbers[0];
		int largest= numbers[1];
		if(secondLargest>largest){
			secondLargest= numbers[1];
			largest= numbers[0];
		}
		for(int i=2; i<numbers.length; i++){
			if(numbers[i]>largest){
				secondLargest= largest;
				largest= numbers[i];
			}else if(numbers[i]>secondLargest && numbers[i]<largest)
				secondLargest=numbers[i];
		}
		return secondLargest;
	}

	public static void main(String[] args) {
		//Check if Number
		String alphanumeric= "12345678abcdef";
		boolean b= checkIfNumber(alphanumeric);
		if(b)
			System.out.println(alphanumeric+ " is a valid integer");
		else
			System.out.println(alphanumeric+" is not a valid integer");

		//Check if Boolean
		int number= 10110110;
		boolean isBinary= checkIfBoolean(number);
		if(isBinary)
			System.out.println(number+" is a binary number");
		else
			System.out.println(number+" is not a binary number");

		//Generate random numbers
		generateRandomNumbers();

		//Second largest number in an array
		//int[] numbers = {40, 10, 30, 60, 90};
		System.out.println("Second largest number is: "+secondLargestNumber(new int[]{-115,-40,10,30,60,90,50,110,-20}));
	}
}
