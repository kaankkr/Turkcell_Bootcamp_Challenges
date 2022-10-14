package challenge_inheritance;

public class DigitalCamera extends Camera{
	
	
	private int videofps;
	private boolean nightMode;
	private int timer;
	
	public DigitalCamera(String serialNo, String make, String resolution, int videofps) {
		super(serialNo, make, resolution);
		this.videofps = videofps;
		
	}
	
	public int getVideofps() {
		return videofps;
	}
	public void setVideofps(int videofps) {
		this.videofps = videofps;
	}

	public boolean isNightMode() {
		return nightMode;
	}
	public void setNightMode(boolean nightMode) {
		this.nightMode = nightMode;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	
	public void takeVideo(int time) {
		setMemory(getMemory() - (videofps * time));
	
	}
	public void deleteVideo(int time) {
		setMemory(getMemory() + (videofps * time));
	}


}