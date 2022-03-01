package com.main.learn.string;

public class StringUtils {
	public static String strRev(String str){
		char temp;
		char[] chars = str.toCharArray();

		for(int i=0,j=str.length()-1;i<j;i++,j--){
			temp= chars[j];
			chars[j]=chars[i];
			chars[i]=temp;			
		}
	 return	String.valueOf(chars);
	}
	
	static String recursiveMethod(String str)
    {
         if ((str == null) || (str.length() <= 1))
            return str;
         
         String revStr= recursiveMethod(str.substring(1)) + str.charAt(0);
         return revStr;
    }
	
	public static void main(String[] args) {
		
		String reverse= "BUSHRA";

		System.out.println("Through Char Swap: "+strRev(reverse));
		System.out.println("Through Recursive Method: "+recursiveMethod(reverse));
	}

}