package Challenge_HashMap;


import java.util.LinkedHashMap;
import java.util.Scanner;

public class Challenge_HashMap {

	public static void main(String[] args) {
		
		//hashMapZipperWithCount();
		hashMapZipper();
	}
	
	public static void hashMapZipperWithCount() {
		
		System.out.println("Input: ");
		
		Scanner scn = new Scanner(System.in);
		
		String input = scn.nextLine();
		
		
		LinkedHashMap<Character , Integer> map = new LinkedHashMap<Character , Integer>();
		
		
		for(int i = 0 ; i < input.length() ; ++i) {
			
			
			if(!map.containsKey(Character.toLowerCase(input.charAt(i))) && !map.containsKey(Character.toUpperCase(input.charAt(i)))) {
				
				int count = 1;
				
				for(int j = i + 1;  j < input.length() ; ++j) {
					
					if( (input.charAt(i)+ "").toLowerCase().equals( (input.charAt(j)+ "").toLowerCase()) ) {
						
						 map.put(input.charAt(i), ++count) ;
					}
					
				}
				
			}	
			

		scn.close();
		}
		
		for(var entry : map.entrySet()) {
			System.out.print(entry.getKey()+ "" +entry.getValue());
		}
	}

	public static void hashMapZipper() {
		
		System.out.println("Input: ");
		
		Scanner scn = new Scanner(System.in);
		
		String input = scn.nextLine();
		
		
		LinkedHashMap<Character , Integer> map = new LinkedHashMap<Character , Integer>();
		
		
		for(int i = 0 ; i < input.length() ; ++i) {
			
			
			if(!map.containsKey(Character.toLowerCase(input.charAt(i))) && !map.containsKey(Character.toUpperCase(input.charAt(i)))) {
				
				int count = 1;
				
				for(int j = i + 1;  j < input.length() ; ++j) {
					
					if( (input.charAt(i)+ "").toLowerCase().equals( (input.charAt(j)+ "").toLowerCase()) ) {
						
						 map.put(input.charAt(i), ++count) ;
					}
					
				}
				
			}	
			

		scn.close();
		}
		
		for(var entry : map.entrySet()) {
			System.out.print(entry.getKey());
		}
	}
	
}
