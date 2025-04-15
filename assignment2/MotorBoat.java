package assignment2;

/**
 * MotorBoat class extends Boat
 * @author Mah_LiYuan_B2000511
 *
 */
public class MotorBoat extends Boat{
	private double horsePower;
	
	/**
	 * MotorBoat Constructor
	 * @param owner
	 * @param height
	 * @param length
	 * @param width
	 * @param boatValue
	 * @param chargeRate
	 * @param horsePower
	 */
	public MotorBoat(Owner owner, double height, double length, double width, double boatValue, double chargeRate, double horsePower)
	{
		super(owner, height, length, width, boatValue, chargeRate);
		setHorsePower(horsePower);
	}

	/**
	 * this function does not apply to this class
	 * the value remain as zero
	 * due to its abstract function from the superclass boat
	 * @return 0
	 */
	@Override
	public double sailDryingCharge() {
		return 0;
	}
	
	/**
	 * multiply horsePower value by 10%
	 * and return the sum
	 * @return double
	 */
	public double insuranceCharge()
	{
		return getHorsePower() * 0.1; 
	}
	
	/**
	 * multiply boat value by 0.05%
	 * and return the sum
	 * @return double
	 */
	public double levyRate()
	{
		return super.getBoatValue() * 0.005;
	}
	
	/**
	 * multiply BoatValue by 10%
	 * and return the sum
	 * @return double
	 */
	public double fireRate()
	{
		return super.getBoatValue() * 0.1;
	}
	
	/**
	 * Setter function
	 * set HorsePower
	 */
	public void setHorsePower(double horsePower)
	{
		this.horsePower = horsePower;
	}
	
	/**
	 * Getter Function
	 * @return double
	 */
	public double getHorsePower()
	{
		return horsePower;
	}
	
	/**
	 * print total value of all the charges
	 * such as insuranceCharge, levyRate, fireRate and ChargeRate
	 * @return double 
	 */
	public double totalMonthlyCharge()
	{
		return super.getChargeRate() + insuranceCharge() + levyRate() + fireRate();
	}
}
