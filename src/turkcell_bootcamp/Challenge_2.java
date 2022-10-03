package turkcell_bootcamp;

public class Challenge_2 {

	public static void main(String[] args) {
		
		int[][] matrix = new int[][] { {1,2,3} , {4,5,6} , {7,8,9} };
		

		
		//arr_flip( matrix);

		arr_flip2( matrix);
		
		/*
		Scanner my_scan = new Scanner(System.in);
		
		System.out.println("Metin giriniz: ");
		
		String user_text = my_scan.nextLine();
		
		zip(user_text);
		
		*/
		
		
	}
	
	public static void arr_print(int[][] old_array) {
		
		for(int i = 0; i <3  ; ++i) {
			
			for(int j = 0; j < 3; ++j) {
				
				
				
				System.out.print(old_array[i][j]+" ");
				
				
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public static void arr_flip(int[][] old_array) {
		
		arr_print(old_array);
		
		
		for(int i = 2; i >= 0 ; --i) {
			
			for(int j = 2; j >= 0; --j) {
				
				
				
				System.out.print(old_array[i][j]+" ");
				
				
			}
			System.out.println();
		}
	}
	
	public static void arr_flip2( int[][] old_array) {
		
		arr_print(old_array);
		
		for(int j = 0; j < 3 ; ++j) {
			
			for(int i = 2; i >= 0; --i) {
				
				
				
				System.out.print(old_array[i][j]+" ");
				
				
			}
			System.out.println();
		}
		
	}
	
	public static void zip(String strix) {
		
		int count = 1;
		
		for(int i = 0; i < strix.length() - 1 ; ++i) {

			
			//Elemanları sırayla karsılastırıyoruz. Eger i+1. karakter i.'den farklı ise i'yi ve sayısını ekrana bastırıyoruz.
			if(strix.charAt(i) != strix.charAt(i+1) ) {
				
				System.out.print(strix.charAt(i));

				if( strix.charAt(i) == ' ') {//Bosluk krkt.'nin sayısını ekrana basmadan devam etmek icin.
					
				}
				else {
					
					System.out.print(count );
				}
				
				count = 1;
				
				
			}
			else { //Eger i. ile i+1. eleman ayni ise sayac degiskenini arttırıyoruz
				count += 1;
			}
			
			if(i == (strix.length() - 2) ) { // son elemanın da ekrana yazdırılabılmesı için eklendi.
				System.out.print(strix.charAt(i+1));
				System.out.print(count);
				
				
				
			}
			
		}
	}

}
