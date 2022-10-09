package Challenge_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge_ArrayList {

	public static void main(String[] args) {
		
		//arrayListZipper();
		
		
		arrayListZipperWithCount();
		
	}

public static void arrayListZipperWithCount() {
	
	System.out.println("Input: ");
	
	Scanner scn = new Scanner(System.in);
	
	String input = scn.nextLine();
	
	
	ArrayList<Character> stringlist = new ArrayList<Character>();
	
	int addcount = 0;
	
	for(int i = 0 ; i < input.length() ; ++i) {
		
		
		if(!stringlist.contains(Character.toLowerCase(input.charAt(i))) && !stringlist.contains(Character.toUpperCase(input.charAt(i)))) {
		
			int count = 1;
			
			for(int j = i + 1;  j < input.length() ; ++j) {
				
				if( (input.charAt(i)+ "").toLowerCase().equals( (input.charAt(j)+ "").toLowerCase()) ) {
					count++ ;
				}
				
			}
			stringlist.add(input.charAt(i));
			System.out.print(stringlist.get(addcount) +"" +count);
			addcount++;
			
		}

	}
scn.close();
}

public static void arrayListZipper() {
	System.out.println("Input: ");
	
	Scanner scn = new Scanner(System.in);
	
	String input = scn.nextLine();
	
	
	ArrayList<Character> stringlist = new ArrayList<Character>();
	
	
	for(int i = 0 ; i < input.length() ; ++i) {
		
		int count = 1;
		
		if(!stringlist.contains(Character.toLowerCase(input.charAt(i)))) {
			
			for(int j = i + 1;  j < input.length() ; ++j) {
				
				if( (input.charAt(i)+ "").toLowerCase().equals( (input.charAt(j)+ "").toLowerCase()) ) {
					count++ ;
				}
				
			}
			stringlist.add(input.charAt(i));
			
		}
		
	
	

	}
	
	for(int i = 0; i < stringlist.size() ; ++i) {
		System.out.print(stringlist.get(i) +"" );
	}
	
	scn.close();
}

}