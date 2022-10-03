package turkcell_bootcamp;

import java.util.Scanner;

public class Challenge_1 {

	public static void main(String[] args) {
		
		System.out.print("Merhaba isminizi girin : ");
		
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		
		//System.out.println(" name : " + name);
		
		char[] name_chars = name.toCharArray();
		
		for( int i = 0; i < name.length() ; i++) {
			
			if( name_chars[i] == 'a' || name_chars[i] == 'A' ) {
				
				name_chars[i] = '1';
				
			}
			else if( name_chars[i] == 'e' || name_chars[i] == 'E' ) {
				
				name_chars[i] = '2';
				
			}
			else if( name_chars[i] == 'ı' || name_chars[i] == 'I') {
				
				name_chars[i] = '3';
				
			}
			else if( name_chars[i] == 'i' || name_chars[i] == 'İ') {
				
				name_chars[i] = '4';
				
			}
			else if( name_chars[i] == 'o' || name_chars[i] == 'O') {
				
				name_chars[i] = '5';
				
			}
			else if( name_chars[i] == 'ö' || name_chars[i] == 'Ö') {
				
				name_chars[i] = '6';
				
			}
			else if( name_chars[i] == 'u' || name_chars[i] == 'U') {
				
				name_chars[i] = '7';
				
			}
			else if( name_chars[i] == 'ü' || name_chars[i] == 'Ü') {
				
				name_chars[i] = '8';
				
			}
			
		}
		
		name = String.valueOf(name_chars);
		
		System.out.println(" Yeni isim: " + name);

	}

}
