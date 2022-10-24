package reader_extension;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;



public class Reader_extension extends FileReader {

	ArrayList<String> arlist = new ArrayList<String>() ;
	String temp = "";
	String line = "";
	String fileName;
	
	
	public Reader_extension(String fileName) throws FileNotFoundException {
	
			super(fileName);
			this.fileName = fileName;
		
	}

	public void readWords(String s) throws IOException {
		int i;

		
		while((i = read()) != -1) {
		
			
			if(Character.isLetterOrDigit(i)) {
				temp = temp + (char) i;
			}
			else if(i == -1 || !Character.isLetterOrDigit(i)) {
				arlist.add( temp);
				temp = "";
			}
		}
		//Stream'in son kellimesini eklemek için eklendi.
		arlist.add( temp);
		temp = null;
	}
	
	public String readLineAt(int i) throws IOException {
		
		line = Files.readAllLines(Paths.get(fileName)).get(i-1);
		
		return line;
	}
	
	public void printList() {
		//System.out.println(arlist.size());
		for(int i = 0; i < arlist.size() ; ++i) {
			System.out.println(arlist.get(i));
		}
	}
}
