package interfaces;


public class Phone implements Camera, MusicPlayer{

	public Phone() {
		
	}

	@Override
	public void startMusic() {
		System.out.println("Playing Music...");
		
	}

	@Override
	public void stopMusic() {
		System.out.println("Stopping Music...");
		
	}

	@Override
	public void next() {
		System.out.println("Playing the Next Song...");
		
	}

	@Override
	public void previous() {
		System.out.println("Playing the Previous Song...");
		
	}

	@Override
	public void takePhoto() {
		System.out.println("Took a Photo...");
		
	}

	@Override
	public void deletePhoto() {
		System.out.println("Deleted a Photo...");
		
	}

	@Override
	public void recordVideo() {
		System.out.println("Recorded a Video...");
		
	}

	@Override
	public void deleteVideo() {
		System.out.println("Deleted a Video...");
		
	}
	
	

}
