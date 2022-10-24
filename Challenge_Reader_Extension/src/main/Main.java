package main;
import java.io.FileNotFoundException;
import java.io.IOException;

import reader_extension.Reader_extension;

public class Main {


	public static void main(String[] args) {
		try {
		
		Reader_extension myreader=new Reader_extension("/Users/kaankaracengel/eclipse-workspace/Testout.txt");    
            
		myreader.readWords("/Users/kaankaracengel/eclipse-workspace/Testout.txt");
		
		myreader.printList();
		
		//String satir = myreader.readLineAt(1);
		
		myreader.close(); 
        
        //System.out.println(satir);
        
		} catch(FileNotFoundException fnfe) {
			System.err.println("Dosya bulunamadı...");
			
			
		} catch (IOException ioe) {
			System.err.println("Dosya açılamadı...");

		}
	}

}
