package com.main.learn.collectionUtils;
import java.util.HashMap;

public class DuplicatesUsingDiffMethods {
	
	public static void main(String[] args){
		int[] inputArray= {1,2,2,3,1,2};
		HashMap<Integer, Integer> intMap= duplicateInInteger(inputArray);
		System.out.println("Duplicate in Integer "+intMap);

		String name= "aabacbcca";
		HashMap<Character, Integer> charMap= duplicateInChar(name);
		System.out.println("Duplicate in string using "+charMap);

		HashMap<Character, Integer> charAtMap= duplicateInCharAt(name);
		System.out.println("Duplicate in string using "+charAtMap);

		String strArray= "Java Python CPP Java Javaa";
		HashMap<String, Integer> strMap= duplicateInString(strArray);
		System.out.println("Duplicate in string using split "+strMap);
	}
	
	static HashMap<String, Integer> duplicateInString(String strArray) {
		String[] words= strArray.split(" ");
		HashMap<String, Integer> word_map= new HashMap<>();
		
		for(String word: words){
			if(word_map.get(word) == null)
				word_map.put(word, 1);
			else
				word_map.put(word, word_map.get(word)+1);
			
		}
		return word_map;
	}

	static HashMap<Character, Integer> duplicateInCharAt(String name) {
		HashMap<Character ,Integer> map2=new HashMap<>();
		for(int i=0; i<name.length(); i++){
			char a = name.charAt(i);
			if(map2.get(a) == null)
				map2.put(a, 1);
			else
				map2.put(a, map2.get(a)+1); //name.charAt(i) ==
			
		}
		return map2;
	}

	static HashMap<Integer, Integer> duplicateInInteger(int[] inputArray){
		HashMap<Integer, Integer> map= new HashMap<>();
		for(int i: inputArray){
			if(map.get(i) == null)
				map.put(i, 1);
			else
				map.put(i, map.get(i)+1);
		} 
		return map;
	}

	static HashMap<Character, Integer> duplicateInChar(String name) {
		HashMap<Character ,Integer> map1=new HashMap<>();
		name.chars().forEach(x->{
			if(map1.get((char)x)==null)
				map1.put((char)x,1);
		 	else
		 		map1.put((char)x, map1.get((char)x)+1);
		});
		return map1;
	}
}
