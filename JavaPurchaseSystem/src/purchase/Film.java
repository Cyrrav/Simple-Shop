package assignment1;

/**
 * 
 * @author Dale Morrell
 *
 */

public class Film // Movie titles and ratings
{
	private String title; // Variables/Encapsulation
	private Rating rating;
	
	public Film(String title, Rating parentalguidance) // Default Constructor
	{
		this.title = title;
		this.rating = parentalguidance;
	}
	
	public String toString() // toString, to return a representation
	{
		return this.title + " Rating: " + this.rating;
	}

	public int getRating() // Get minimum age rating
	{
		return this.rating.getAge();
	}
}
