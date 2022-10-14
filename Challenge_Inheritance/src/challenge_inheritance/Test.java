package challenge_inheritance;

public class Test {

	public static void main(String[] args) {

		Camera cam1 = new Camera("CAM1","Nikon","4K");
		
		
		System.out.println("Camera Bilgileri: ");
		System.out.println(cam1.getSerialNo() + "-" + cam1.getMake() + "-" + cam1.getResolution() + "-" + cam1.getMemory());
		
		cam1.setMemory(20);
		System.out.println("");
		System.out.println("Camera Bilgileri: ");
		System.out.println(cam1.getSerialNo() + "-" + cam1.getMake() + "-" + cam1.getResolution() + "-" + cam1.getMemory());
		
		
		DigitalCamera cam2 = new DigitalCamera("CAM2","Kodak","HD",30);
		
		System.out.println("");
		System.out.println("Camera Bilgileri: " );
		System.out.println(cam2.getSerialNo() + "-" + cam2.getMake() + "-" + cam2.getResolution());
		System.out.println(cam2.getMemory() + "-" + cam2.isNightMode() + "-" + cam2.getVideofps());
		
		cam2.setMemory(300);
		cam2.takePhoto();
		cam2.takeVideo(5);
		cam2.deletePhoto();
		
		System.out.println("");
		System.out.println("Camera Bilgileri: " );
		System.out.println(cam2.getSerialNo() + "-" + cam2.getMake() + "-" + cam2.getResolution());
		System.out.println(cam2.getMemory() + "-" + cam2.isNightMode() + "-" + cam2.getVideofps());
		
		
		
		AnalogCamera cam3 = new AnalogCamera("CAM3","Nikon","4K");
		
		System.out.println("");
		System.out.println("Camera Bilgileri: " );
		System.out.println( cam3.getSerialNo() + "-" + cam2.getMake() + "-" + cam2.getResolution());
		System.out.println(cam3.getFilmCount());
		
		cam3.reloadFilm();
		cam3.takePhoto();
		cam3.takePhoto();
		
		System.out.println("");
		System.out.println("Camera Bilgileri: " );
		System.out.println( cam3.getSerialNo() + "-" + cam2.getMake() + "-" + cam2.getResolution());
		System.out.println(cam3.getFilmCount());
		
		
		
		IpCamera cam4 = new IpCamera("CAM4","Samsung","HD",30);
		
		System.out.println("");
		System.out.println("Camera Bilgileri: ");
		System.out.println( cam4.getSerialNo() + "-" + cam4.getMake() + "-" + cam4.getResolution());
		System.out.println(cam4.getMemory() + "-" + cam4.isNightMode() + "-" + cam4.getVideofps());
		System.out.println(cam4.getLiveBroadcast() + "-" + cam4.getAngle());
		
		cam4.setMemory(300);
		cam4.takePhoto();
		cam4.takeVideo(4);
		cam4.setLiveBroadcast(true);
		cam4.deleteVideo(1);
		
		System.out.println("");
		System.out.println("Camera Bilgileri: ");
		System.out.println( cam4.getSerialNo() + "-" + cam4.getMake() + "-" + cam4.getResolution());
		System.out.println(cam4.getMemory() + "-" + cam4.isNightMode() + "-" + cam4.getVideofps());
		System.out.println(cam4.getLiveBroadcast() + "-" + cam4.getAngle());
		
		
		
		
		
		
		
		
	}

}
