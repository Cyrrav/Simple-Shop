package assignment1;

/**
 * 
 * @author Dale Morrell
 *
 */

public enum Rating 
{
	GENERAL(0), PARENTALGUIDANCE(12), MATURE(16); // Film Rating System elements
	private int minAge;
	
	private Rating(int age) // Minimum age variable constructor
	{
		this.minAge = age;
	}

	public int getAge() // Getters and Setters
	{
		return minAge;
	}

	public void setAge(int age) 
	{
		this.minAge = age;
	}
	
	public String toString() // toString representation
	{
		if (this.minAge == 0) // Conditions based on minimum ages/film rating guidelines
		{
			return "G";
		}
		
		if (this.minAge == 12)
		{
			return "PG-" + this.minAge;
		}
		
		else
		{
			return "M-" + this.minAge;
		}
	}
}
