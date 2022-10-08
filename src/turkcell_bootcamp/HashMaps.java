package turkcell_bootcamp;
import java.util.HashMap;
import java.util.Map;


public class HashMaps {

	public static void main(String[] args) {
		
		mapOrnek();
		
	}	

	public static void mapOrnek(){
	
	Map<Integer , Person> kisiler = new HashMap<>() ;
	
	kisiler.put(1, new Person(23 , "Kaan"));
	
	
	for (java.util.Map.Entry<Integer, Person> entry : kisiler.entrySet()) 
	{ 
		System.err.println(entry.getKey() + " - " + entry.getValue().getYas() + " - " + entry.getValue().getIsim());
	} 
	
	System.err.println("------------------"); 
	
	for (Integer key : kisiler.keySet()) 
	{ 
		System.err.println(key + " - " + kisiler.get(key).getYas() + " - " + kisiler.get(key).getIsim());
	}
}


}

class Person {


	private int Yas  ;
	private String Isim  ;
	
	public Person(int i, String string) {
		// TODO Auto-generated constructor stub
		this.Isim =  string;
		this.Yas = i;
	}
	public int getYas(){
		return Yas;
		
	}
	public String getIsim(){
		return Isim;
		
	}
	
}

