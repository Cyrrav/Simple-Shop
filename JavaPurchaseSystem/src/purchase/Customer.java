package assignment1;

/**
 * 
 * @author Dale Morrell
 *
 */

public class Customer // Customer details/information
{
	private String name; // Variables/Encapsulation
	private int age;
	private boolean isStudent;
	
	public Customer(String name, int age, boolean isStudent) // Constructor
	{
		this.name = name;
		this.age = age;
		this.isStudent = isStudent;
	}

	public String getName() // Getters and Setters
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public boolean isStudent() 
	{
		return isStudent;
	}

	public void setStudent(boolean isStudent) 
	{
		this.isStudent = isStudent;
	}
	
	public String toString() // toString, to return a representation
	{
		return "Name: " + this.name + " Age: " + this.age + " Student? " + this.isStudent;
	}
}
