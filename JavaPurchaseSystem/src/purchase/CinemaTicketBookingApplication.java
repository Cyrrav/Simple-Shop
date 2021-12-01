package assignment1;
import java.util.Scanner;

/**
 * 
 * @author Dale Morrell
 *
 */

public class CinemaTicketBookingApplication 
{
	static Scanner scanner = new Scanner(System.in); // Initialize scanner
	private static final int NUMBER_OF_FILMS = 4; // Initialize amount of items in array
	static Film[] filmList = new Film[NUMBER_OF_FILMS]; // Initialize array

	private static Customer customerDetailsInput() // Gathers customer details and creates a customer object
	{
		String customername = null; // Initialize variables
		int customerage = 0;
		char student = 0;
		
		System.out.println("Please enter your name: "); // User input for Name, Age and "Is Student?"
		customername = scanner.nextLine();
		System.out.println("Please enter your age: ");
		customerage = scanner.nextInt();
		System.out.println("Are you a student? (Y/N)");
		student = scanner.next().charAt(0);
		
		if ((student == 'y') || (student == 'Y')) // To determine whether the user is a student or not
		{
			boolean isStudent = true; // Set "Is student?" to true
			Customer newCustomer = new Customer(customername, customerage, isStudent); // create customer object
			return newCustomer; // Return customer object
		}
		
		else
		{
			boolean isStudent = false; // Set "Is student?" to false
			Customer newCustomer = new Customer(customername, customerage, isStudent); // create customer object
			return newCustomer; // Return customer object
		}
	}
	
	private static Film filmSelection() // Returns user selection of Film
	{
		int filmSelect = 0; // Initialize variable
		
		System.out.println("Which film would you like to watch?: "); // Query
		System.out.println(filmList[0]);
		System.out.println(filmList[1]); // Print list of films
		System.out.println(filmList[2]);
		System.out.println(filmList[3]);
		filmSelect = scanner.nextInt() - 1; // Adjust input (Arrays start at 0)
		return filmList[filmSelect]; // Return selected film
	}
	
	public static Ticket issueTicket(Customer aCustomer, Film aFilm) // Constructs & Returns a ticket object
	{
		if (aCustomer.getAge() >= aFilm.getRating())
		{
			Ticket ticket = new Ticket(aCustomer, aFilm);
			return ticket; // Return ticket
		}
		
		else
		{
			return null; // Return null
		}
	}

	public static void main(String[] args) 
	{
		int ticketLoop = 1; // Initialize variable
		while (ticketLoop == 1) // Loop until the user would not like another ticket
		{
			System.out.println("Welcome to the CinemaTix Purchasing System!");
			
			Customer details = null; // Initialize as null
			details = customerDetailsInput(); // Saves function return to variable
		
			filmList[0] = new Film("#1: Spiderman", Rating.PARENTALGUIDANCE); // Initialize hard-coded array
			filmList[1] = new Film("#2: Overlord", Rating.PARENTALGUIDANCE);
			filmList[2] = new Film("#3: Alien", Rating.MATURE);
			filmList[3] = new Film("#4: Owls of Ga'hoole", Rating.GENERAL);
			Film pickedFilm = filmSelection(); // Saves function returns to variables
			Ticket nullCheck = issueTicket(details, pickedFilm); 
			
			if (nullCheck == null) // Movie Restriction Warning & Restart Ticket Loop
			{
				System.out.println("Sorry, cannot issue ticket for age-restricted film!");
				System.out.println("Issue another ticket? (Y/N)"); // Query User
				char ticketLoopCheck = scanner.next().charAt(0); // Accept user input
				
				if ((ticketLoopCheck == 'n') || (ticketLoopCheck == 'N')) // Continue Loop or End Loop
				{
					ticketLoop = 0; // Exit Loop
					scanner.nextLine(); // Clear buffer
				}
				else
				{
					ticketLoop = 1; // Continue Loop
					scanner.nextLine(); // Clear buffer
				}
			}
			
			else // Print Ticket & Restart Ticket Loop
			{ 
				System.out.println("------------------------------------------------------------");
				System.out.println("Film Ticket for: " + pickedFilm.toString());
				System.out.println(details.toString());
				System.out.println(nullCheck.toString());
				System.out.println("------------------------------------------------------------");

				
				System.out.println("Issue another ticket? (Y/N)"); // Query user
				char ticketLoopCheck = scanner.next().charAt(0); // User Input accepting
			
				if ((ticketLoopCheck == 'n') || (ticketLoopCheck == 'N')) // Continue or End loop
				{
					ticketLoop = 0; // Exit Loop
					scanner.nextLine(); // Clear buffer
				}
				else
				{
					ticketLoop = 1; // Continue Loop
					scanner.nextLine(); // Clear buffer
				}
			}
		}
	}
}
