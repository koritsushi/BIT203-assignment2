package assignment2;

/**
 * Abstract Class Boat
 * @author Mah_LiYuan_B2000511
 *
 */
public abstract class Boat {
	private Owner owner;
	private double height;
	private double length;
	private double width;
	private double boatValue;
	private double chargeRate;
	
	/**
	 * Boat Constructor
	 * @param owner
	 * @param height
	 * @param length
	 * @param width
	 * @param boatValue
	 * @param chargeRate
	 */
	public Boat(Owner owner, double height, double length, double width, double boatValue, double chargeRate)
	{
		setOwner(owner);
		setHeight(height);
		setLength(length);
		setWidth(width);
		setBoatValue(boatValue);
		setChargeRate(chargeRate);
	}
	
	public abstract double totalMonthlyCharge();
	
	public abstract double sailDryingCharge();
	
	public abstract double insuranceCharge();
	
	public abstract double levyRate();
	
	public abstract double fireRate();
	
	/**
	 * setter function
	 * set owner
	 * @param owner
	 */
	public void setOwner(Owner owner)
	{
		this.owner = owner;
	}
	
	/**
	 * setter function
	 * set boat height
	 * @param height
	 */
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	/**
	 * setter function
	 * set boat length
	 * @param length
	 */
	public void setLength(double length)
	{
		this.length = length;
	}
	
	/**
	 * setter function
	 * set boat width
	 * @param width
	 */
	public void setWidth(double width)
	{
		this.width = width;
	}

	/**
	 * setter function
	 * set boat value
	 * @param boatValue
	 */
	public void setBoatValue(double boatValue)
	{
		this.boatValue = boatValue;
	}
	
	/**
	 * setter function
	 * set boat charge rate
	 * @param chargeRate
	 */
	public void setChargeRate(double chargeRate)
	{
		this.chargeRate = chargeRate;
	}
	
	/**
	 * getter function
	 * get owner
	 * @return owner
	 */
	public Owner getOwner()
	{
		return owner;
	}
	
	/**
	 * getter function
	 * get boat height
	 * @return height
	 */
	public double getHeight()
	{
		return height;
	}
	
	/**
	 * getter function
	 * get boat length
	 * @return length
	 */
	public double getLength()
	{
		return length;
	}
	
	/**
	 * getter function
	 * get boat width 
	 * @return width
	 */
	public double getWidth()
	{
		return width;
	}
	
	/**
	 * getter function
	 * get boat value
	 * @return boatValue
	 */
	public double getBoatValue()
	{
		return boatValue;
	}
	
	/**
	 * getter function
	 * get boat charge rate
	 * @return chargeRate
	 */
	public double getChargeRate()
	{
		return chargeRate;
	}
}
