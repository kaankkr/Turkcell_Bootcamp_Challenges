package main;

import interfaces.Phone;

public class Main {

	public static void main(String[] args) {
		
		
		Phone myphone = new Phone();
		
		myphone.startMusic();
		myphone.next();
		myphone.takePhoto();
		myphone.recordVideo();
		myphone.deletePhoto();
		myphone.stopMusic();
	}

}
