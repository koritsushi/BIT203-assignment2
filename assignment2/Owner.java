package assignment2;

import java.util.ArrayList;

/**
 * Owner Class
 * @author Mah_LiYuan_B2000511
 *
 */
public class Owner {
	private static int idCounter = 1;
	private int idNumber;
	private String name;
	private String address;
	private ArrayList<Boat> Boats;
	
	/**
	 * Owner Constructor function
	 * @param name
	 * @param address
	 */
	public Owner(String name, String address)
	{
		setIdNumber(setIdNumberGen());
		setName(name);
		setAddress(address);
		setBoats(new ArrayList<>());
	}
	
	/**
	 * setter function
	 * set idNumber
	 * @param idNumber
	 */
	private void setIdNumber(int idNumber)
	{
		this.idNumber = idNumber;
	}
	
	/**
	 * setter function
	 * idCounter value starts at 1
	 * return idNumber value for Owner IdNumber
	 * then increment idCounter
	 * so the idNumber is Unique
	 * @return idNumber
	 */
	private int setIdNumberGen()
	{
		return idCounter++;
	}
	
	/**
	 * setter function
	 * set name
	 * @param name
	 */
	private void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * setter function
	 * set address
	 * @param address
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	/**
	 * setter function
	 * initialize List of Boat for Owner
	 * @param boats
	 */
	public void setBoats(ArrayList<Boat> boats)	
	{
		this.Boats = boats;
	}
	
	/**
	 * getter function
	 * get idNumber
	 * @return idNumber
	 */
	public int getIdNumber()
	{
		return idNumber;
	}
	
	/**
	 * getter function
	 * get name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * getter function
	 * get address 
	 * @return address
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * getter function
	 * get 
	 * @return Boats
	 */
	public ArrayList<Boat> getBoats()
	{
		return Boats;
	}
	
	/**
	 * add boat into owner boat collection
	 * @param b
	 */
	public void addBoat(Boat b)
	{
		Boats.add(b);
	}
	
	/**
	 * collect all boats own by owner totalSailDryingCharge charge as sum
	 * @return totalSailDryingCharge
	 */
	public double totalSailDryingCharge()
	{
		return getBoats().stream()
				.filter(sb -> sb instanceof SailBoat)
				.mapToDouble(sb -> sb.sailDryingCharge())
				.sum();
	}
	
	/**
	 * collect all boats own by owner insurance charge as sum
	 * @return totalInsuranceCharge
	 */
	public double totalInsuranceCharge()
	{
		return getBoats().stream()
				.filter(mb -> mb instanceof MotorBoat)
				.mapToDouble(mb -> mb.insuranceCharge())
				.sum();
	}
	
	/**
	 * collect all boats own by owner totalLevyRate as sum
	 * @return totalLevyRate
	 */
	public double totalLevyRate()
	{
		return getBoats().stream()
				.filter(mb -> mb instanceof MotorBoat)
				.mapToDouble(mb -> mb.levyRate())
				.sum();
	}
	
	/**
	 * collect all boats own by owner totalFireRate as sum
	 * @return totalFireRate
	 */
	public double totalFireRate()
	{
		return getBoats().stream()
				.filter(mb -> mb instanceof MotorBoat)
				.mapToDouble(mb -> mb.fireRate())
				.sum();
	}
	
	/**
	 * collect all boat own by owner  total Monthly Charge as sum 
	 * @return totalOwnerCharge
	 */
	public double totalOwnerCharge()
	{
		return getBoats().stream()
				.mapToDouble(Boat::totalMonthlyCharge)
				.sum();
	}
	
	/**
	 * return Owner ID number and name as String
	 * @return String
	 */
	public String toName()
	{
		return "ID:" + getIdNumber() + ", Name:" + getName();
	}
	
	/**
	 * return Owner ID number, name
	 * total sail drying charge, total insurance charge,
	 * total levy charge, totalfirerate
	 * and total Monthly Charge as String
	 * @return String
	 */
	public String ToString()
	{
		return "ID:" + getIdNumber() + ", Name:" + getName() 
			+ "\ntotalSailDryingCharge:" + totalSailDryingCharge()
			+ "\ntotalInsuranceCharge:" + totalInsuranceCharge() 
			+ "\ntotalLevyCharge:" + totalLevyRate()
			+ "\ntotalFireRate:" + totalFireRate()
			+ "\ntotalMontlyCharge:" + totalOwnerCharge();
	}
}
