package assignment1;

/**
 * 
 * @author Dale Morrell
 *
 */

public class Ticket 
{
	private Customer Customer; // Customer and Film object as attributes
	private Film Film;
	
	Ticket(Customer Customer, Film Film) // Constructor w/ inputs for class attributes
	{
		this.Customer = Customer;
		this.Film = Film;
	}

	public Customer getCustomer() // Getters (No setters due to immutable attributes)
	{
		return Customer;
	}

	public Film getFilm() 
	{
		return Film;
	}		
	
	public double Cost() // Calculate cost
	{
		if ((this.Customer.getAge() >= 18) && (!this.Customer.isStudent() == true)) // 18+ and NOT a student
		{
			if ((this.Customer.getAge() > 70) && (this.Customer.isStudent() == false))
			{
				return (10.0 - (0.05 * 10.0));
			}
			else
			{
			return 10.0;
			}
		}
		
		if ((this.Customer.getAge() >= 8) && (this.Customer.getAge() <= 20)) // Inclusive 8 to 20
		{
			if (this.Customer.getAge() >= 18) // If 18 and over
			{
				return (10.0 - (0.2 * 10.0));
			}
			
			else // If between the ages of 8 and 17
			{
				return (7.0 - (0.2 * 7.0));
			}
		}
		
		if ((this.Customer.getAge() > 25) && (this.Customer.isStudent() == true)) // if 25+ & a student
		{
			return (10.0 - (0.07 * 10.0));
		}
		
		else // None of the other conditions
		{
			return 7.0;
		}
	}
	
	public String toString() // toString representation
	{
		return "Total Cost: $" + this.Cost();
	}
}
