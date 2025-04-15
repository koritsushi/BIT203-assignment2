package assignment2;

/**
 * SailBoat class extends Boat
 * @author Mah_LiYuan_B2000511
 *
 */
public class SailBoat extends Boat{
	private double mastHeight;
	private double sailArea;
	
	/**
	 * SailBoat Constructor
	 * @param owner
	 * @param height
	 * @param length
	 * @param width
	 * @param boatValue
	 * @param chargeRate
	 * @param mastHeight
	 * @param sailArea
	 */
	public SailBoat(Owner owner, double height, double length, double width, double boatValue, double chargeRate, double mastHeight, double sailArea)
	{
		super(owner, height, length, width, boatValue, chargeRate);
		setMastHeight(mastHeight);
		setSailArea(sailArea);
	}
	
	/**
	 * return SailBoat sail drying charge
	 * by multiply sail area by 10%
	 * @return double
	 */
	public double sailDryingCharge()
	{
		return getSailArea() * 0.1;
	}
	
	@Override
	public double insuranceCharge() {
		return 0;
	}

	@Override
	public double levyRate() {
		return 0;
	}

	@Override
	public double fireRate() {
		return 0;
	}
	
	/**
	 * setter function
	 * set mastHeight
	 * @param mastHeight
	 */
	public void setMastHeight(double mastHeight)
	{
		this.mastHeight = mastHeight;
	}
	
	/**
	 * setter function
	 * set sailArea
	 * @param sailArea
	 */
	public void setSailArea(double sailArea)
	{
		this.sailArea = sailArea;
	}
	
	/**
	 * getter function
	 * get mastHeight
	 * @return double
	 */
	public double getMastHeight()
	{
		return mastHeight;
	}
	
	/**
	 * getter function
	 * get SailArea
	 * @return double
	 */
	public double getSailArea()
	{
		return sailArea;
	}
	
	/**
	 * total monthly charge of SailBoat type
	 * @return double
	 */
	public double totalMonthlyCharge()
	{
		return super.getChargeRate() + sailDryingCharge();
	}
}
