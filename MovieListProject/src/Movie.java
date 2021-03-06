
public class Movie {
	//instance variables
	private String title;
	private String category;
	
	//constructors
	public Movie() {
		
	}
	public Movie(String title) {
		setTitle(title);
	}
	public Movie(String title, String category) {
		setTitle(title);
		setCategory(category);
	}
	
	//getters and setters
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	
	//other methods
	@Override
	public String toString() {
		return "Movie title = " + title + ", category = " + category + ".";
	}
}
