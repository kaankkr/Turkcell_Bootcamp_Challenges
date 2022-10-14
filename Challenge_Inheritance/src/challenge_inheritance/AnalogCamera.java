package challenge_inheritance;

public class AnalogCamera extends Camera{

	private int filmCount ;
	
	public AnalogCamera(String serialNo, String make, String resolution) {
		
		super(serialNo, make, resolution);
		
		
	}
	
	public int getFilmCount() {
		return filmCount;
	}

	public void setFilmCount(int filmCount) {
		this.filmCount = filmCount;
	}

	public void reloadFilm() {
		setFilmCount(30);
	}
	
	public void takePhoto() {
		setFilmCount(getFilmCount() - 1);

	}
	
}
