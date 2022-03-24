package com.main.learn.stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamUtils {

	public static void main(String[] args){
		
		String[] strArray= {"b", "u", "s", "h", "r", "a"};
		
		Stream<String> stream= Arrays.stream(strArray);
		stream.forEach(x -> {System.out.print(x);});   //stream.forEach(System.out::print);
		System.out.println();
		
		Integer[] intArray= {0,1,2,3,4,4};
		Stream<Integer> stream1= Stream.of(intArray);
		stream1.forEach(x -> {System.out.print(x);});
		System.out.println();
		
		List<String> list= new ArrayList<>();
		list.add("Java");
		list.add(".Net");
		list.add("Oracle");
		list.add("Angular");
		list.add("Phython");
		list.stream().forEach(x -> {System.out.println(x);});
		
		Stream<String> stream2 = Stream.generate(() -> "Hello Stream").limit(8);
		String[] strArr = stream2.toArray(String[]::new);
		System.out.println(Arrays.toString(strArr));
		
	}

	
}
