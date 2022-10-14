package challenge_inheritance;

public class IpCamera extends DigitalCamera {
//canlı yayın ozellıgı
//saga sola donme ozellıgı
private boolean liveBroadcast;
private int angle;

public IpCamera(String serialNo, String make, String resolution, int videofps) {
	super(serialNo, make, resolution,videofps);
	
}

public int getAngle() {
	return angle;
}


public boolean getLiveBroadcast() {
	return liveBroadcast;
}
public void setLiveBroadcast(boolean live) {
	liveBroadcast = live;
}
public void turnRight() {
	angle += 1;
}
public void turnLeft() {
	angle -= 1;
}
}
