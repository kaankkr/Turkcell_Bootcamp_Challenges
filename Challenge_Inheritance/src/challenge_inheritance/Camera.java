package challenge_inheritance;

public class Camera {

	private String serialNo;
	private String make;
	private String resolution;
	private int memory;
	
	
	
	public Camera(String serialNo, String make, String resolution) {
		
		this.serialNo = serialNo;
		this.make = make;
		this.resolution = resolution;
		
	}
	
	
	public String getSerialNo() {
		return serialNo;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	
	public void takePhoto() {
		setMemory(getMemory() - 1);

	}
	public void deletePhoto() {
		setMemory(getMemory() + 1);
	}

}
