package TheCalcLib;

import java.util.Scanner;

public class TheCalcLib {

	public static void main(String[] args) {
		
		TheCalc();

		
		

	}
	
	public static double TheCalc() {
		
	//belirli bir süre dongude donecek ve sectigim islemlere gore girdiğim degerle
		//o islemin sonucunu bana dondurecek. Her adımda double1'e sum degerını atayacagım.
		//ilk adımdan sonra sadece 2. degeri gireceğim.
		double input1 = 0;
		double input2 = 0;
		boolean flag = false;
		double sum = 0;
		
		Scanner myScanner = new Scanner(System.in);
		
		while(true) {
			
			
			
			System.out.println("1 - Sum ___ 2 - Minus ___ 3 - Multiply ___ 4 - Divide ");
			
			int action = myScanner.nextInt();
			
			
			
			if(!flag) {
				
				input1 = myScanner.nextDouble();
				
				input2 = myScanner.nextDouble();
			}
			
			else {
				input1 = sum;
				input2 = myScanner.nextDouble();
			}
			
			switch(action) {
			
			case 1 :
				sum= sum(input1 , input2);
				System.out.println(sum);
				flag = true;
				break;
				
			case 2 :
				sum= minus(input1 , input2);
				System.out.println(sum);
				flag = true;
				break;

				
			case 3 :
				sum= multiply(input1 , input2);
				System.out.println(sum);	
				flag = true;
				break;

			case 4 :
				sum= divide(input1 , input2);
				System.out.println(sum);
				flag = true;
				break;

			}
			
				
			
		}
	}
	
	public static double sum(double double1 , double double2) {
		
		return double1 + double2;
		
	}
	
	public static double minus(double double1 , double double2) {
		
		return double1 - double2;
		
	}
	
	public static double multiply(double double1 , double double2) {
		
		return double1 * double2;
		
	}
	
	public static double divide(double double1 , double double2) {
		
		if(double2 == 0) {
			return 0;
		}
		
		return double1 / double2;
	}

}
