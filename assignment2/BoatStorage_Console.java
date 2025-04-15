package assignment2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Interative console terminal for BoatStorage
 * @author Mah_LiYuan_B2000511
 *
 */
public class BoatStorage_Console {
	private static BoatStorage boatStorage = new BoatStorage();
	static Scanner scanner;
	
	/**
	 * Main method that starts the application
	 * display main menu with option ranging 1 to 7
	 * then run the function based on user input 
	 * if user input an non numeric string value
	 * the switch case will return an error message
	 * @return none
	 */
	public static void main(String[] args) 
	{
		scanner = new Scanner(System.in);
		
		while (true) 
		{	

			String options;
			
			System.out.println("Boat Storage Management System");
			System.out.println("1. Register Owner");
			System.out.println("2. Register Boat");
			System.out.println("3. Display Owner's TotalCharge");
			System.out.println("4. Display Total Charge");
			System.out.println("5. Display Boat Count");
			System.out.println("6. Display All Owner");
			System.out.println("7. Update Owner's Boat Information");
			System.out.println("0. Exit");	
			System.out.println("Enter your choice:");
			
			options = scanner.nextLine();
			switch (options)
			{
				case "1":
					registerOwner();
					continue;
				case "2":
					registerBoat();
					continue;
				case "3":
					DisplayOwnerTotalCharge();
					continue;
				case "4":
					DisplayAllBoatTotalCharge();
					continue;
				case "5":
					DisplayBoatCount();
					continue;
				case "6":
					DisplayAllOwner();
					continue;
				case "7":
					UpdateBoatInfo();
					continue;
				case "0":
					System.out.println("\nExited Boat Storage Management System!");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("\nError! Select option from the list!\n");
					continue;
			}
		}
	}
	
	/**
	 * check str value is empty by using overload function .trim()
	 * and use .equals to check String == ""
	 * @param str
	 * @return 0 if str is not empty, else -1 if is empty
	 */
	public static int isEmptyStr(String str)
	{
		if (str.trim().equals(""))
		{
			System.out.println("Error! Invalid Input");
			return (-1);
		}
		return (0);
	}
	
	/**
	 * catch any exception cause by user input
	 * check scanner.nexLine() value contains only numeric char value
	 * parse string value from scanner into Int
	 * @param str
	 * @return scanner.nextLine() int numeric value if success, else -1 on error
	 */
	public static int isNumericInt(String str)
	{
		try
		{
			return Integer.parseInt(str);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Error! Please Enter an Numeric value from the option list!");
			return (-1);
		}
	}
	
	/**
	 * catch any exception cause by user input
	 * check scanner.nexLine() value contains only numeric char value
	 * parse string value from scanner into double
	 * @param str
	 * @return scanner.nextLine() double numeric value if success, else -1 on error
	 */
	public static double isNumericDouble(String str)
	{
		try
		{
			return Double.parseDouble(str);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Error! Please Enter an Numeric value from the option list!");
			return (-1);
		}
	}
	
	/**
	 * insert Owner object into boatStorage Owner ArrayList
	 * @return back to main, if name or address is empty
	 */
	public static void registerOwner()
	{		
		System.out.println("Register Owner Details");
		System.out.print("Owner Name:");
		String name = scanner.nextLine();
		if (isEmptyStr(name) == -1)
			return ;
		
		System.out.print("Owner Address:");
		String address = scanner.nextLine();
		if (isEmptyStr(address) == -1)
			return ;
		Owner o = new Owner(name, address);
		boatStorage.addOwner(o);
		System.out.println("\nSuccessfully Register Owner! Owner id: " + o.getIdNumber());
	}
	
	
	/**
	 * insert boat(Motorboat, sailboat) into boatStorage
	 * if non-numeric value is parse in, try catch has implement to catch
	 * NumberFormatException and InputMismatchException
	 * @return back to main, if try catch detect exception throw
	 */
	public static void registerBoat()
	{	
		if (DisplayAllOwner() == -1)
			return ;
		System.out.print("ID:");
		int id = isNumericInt(scanner.nextLine());
		if (id == -1)
			return ;
		Owner owner = boatStorage.getspecifiedOwner(id);
		if (owner == null)
		{
			System.out.println("\nError! incorrect ID for owner\n");
			return ;
		}
		
		System.out.println("Which type of boat?");
		System.out.println("1. Motor Boat");
		System.out.println("2. Sail Boat");
		System.out.print("Type:");
		int options = isNumericInt(scanner.nextLine());
		if (options == -1)
			return ;
		if (options < 1 && options > 2)
		{
			System.out.println("\nError! select an valid options.\n");
			return ;
		}
		
		try
		{
			System.out.print("Height?:");
			double height = scanner.nextDouble();
			System.out.print("Length?:");
			double length = scanner.nextDouble();
			System.out.print("Width?:");
			double width = scanner.nextDouble();
			System.out.print("Value?:");
			double boatValue = scanner.nextDouble();
			System.out.print("Charge Rate?:");
			double chargeRate = scanner.nextDouble();		
			if (options == 1)
			{
				System.out.print("HorsePower?:");
				double horsePower = scanner.nextDouble();
				MotorBoat mb = new MotorBoat(owner, height, length, width, boatValue, chargeRate, horsePower);
				owner.addBoat(mb);
				boatStorage.addBoat(mb);
			}
			else if (options == 2)
			{
				System.out.print("Mast Height?:");
				double mastHeight = scanner.nextDouble();
				System.out.print("Sail Area?:");
				double sailArea = scanner.nextDouble();
				SailBoat sb = new SailBoat(owner, height, length, width, boatValue, chargeRate, mastHeight, sailArea);
				owner.addBoat(sb);
				boatStorage.addBoat(sb);
			}
			else
			{
				System.out.println("\nError! enter option from the list!");
				return ;
			}
			System.out.println("\nSuccessfully registered boat to ID:" + owner.getIdNumber() + "\n");
			System.out.print("");
		}
		catch (NumberFormatException e)
		{
			System.out.println("\nError! Please Enter an Numeric value from the option list!");
			return ;
		}
		catch (InputMismatchException i)
		{
			System.out.println("\nError! Please Enter an Numeric value from the option list!");
			return ;
		}
	}
	
	/**
	 * display all boat total charges with separation 
	 * such as sailDryingCharge, InsuranceCharge, LevyCharge and FireRate.
	 * totalMonthlyCharge is the sum up of all charges listed above
	 */
	public static void DisplayAllBoatTotalCharge()
	{
		System.out.println("\nBoat Storage System Monthly Charges"
				+ "\ntotalSailDryingCharge:" + boatStorage.totalSailDryingCharge()
				+ "\ntotalInsuranceCharge:" + boatStorage.totalInsuranceCharge() 
				+ "\ntotalLevyCharge:" + boatStorage.totalLevyRate()
				+ "\ntotalFireRate:" + boatStorage.totalFireRate()
				+ "\ntotalMonthlyCharge:" + boatStorage.getTotalCharges());
	}
	
	/**
	 * display an specify owner total monthly charge by input idNumber
	 * @return if no owner was registered or input for owner id is non-numeric
	 */
	public static void DisplayOwnerTotalCharge()
	{
		ArrayList<Owner> owners = boatStorage.getOwners();
		if (owners == null)
		{
			System.out.println("\nNo Owner has been registered yet.");
			return ;
		}
		
		DisplayOwnerSortOption(2);
		System.out.print("\nID:");
		int id = isNumericInt(scanner.nextLine());
		if (id == -1)
			return ;
		System.out.println("");
		Owner owner = boatStorage.getspecifiedOwner(id);
		System.out.println(owner.ToString());
		System.out.println("");
	}
	
	/**
	 * display total boat count, SailBoat and MotorBoat count individually
	 */
	public static void DisplayBoatCount()
	{
		System.out.println("\nMotorboat:" + boatStorage.getTotalMotorBoat());
		System.out.println("SailBoat:" + boatStorage.getTotalSailBoats());
		System.out.println("total:" + (boatStorage.getTotalMotorBoat() + boatStorage.getTotalSailBoats()));
		System.out.println("\n");
	}
	
	/**
	 * display sorted owner with option inserted by user 
	 * or programmer to use in a function 
	 */
	public static void DisplayOwnerSortOption(int sort)
	{
		switch (sort)
		{
			case 1:
				System.out.println("\nAll registered owners:\n" 
						+ boatStorage.nonSortedOwner());
				break;
			case 2:
				System.out.println("\nAll registered owners:\n" 
						+ boatStorage.sortedOwnerNames());
				break;
			case 3:
				System.out.println("\nAll registered owners:\n" 
						+ boatStorage.sortedOwnerTotalChargePayments());
				break;
			default:
				break;
		}
	}
	
	/**
	 * display all owner by not sorted, sorted names, total Monthly Charges
	 * @return 1 on success and -1 on error
	 */
	public static int DisplayAllOwner()
	{
		ArrayList<Owner> owners = boatStorage.getOwners();
		if (owners.size() == 0)
		{
			System.out.println("\nNo Owner has been registered yet.\n");
			return (-1);
		}
		
		System.out.println("\nDisplay all Owners, Sorting options");
		System.out.println("1. none");
		System.out.println("2. Name");
		System.out.println("3. total monthly charge");
		System.out.println("0. return");
		System.out.print("Options:");
		
		int choice = isNumericInt(scanner.nextLine());
		if (choice < 1 && choice > 3)
		{
			System.out.println("\nError! Select option from the list!\n");
			return (-1);
		}
			
		DisplayOwnerSortOption(choice);
		System.out.println("");
		return (0);
	}
	
	/**
	 * update boat info and pricing on specified owner idNumber 
	 */
	public static void UpdateBoatInfo()
	{
		
	}
}

