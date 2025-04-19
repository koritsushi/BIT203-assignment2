package assignment2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * BoatStorage Class
 * @author Mah_LiYuan_B2000511
 *
 */
public class BoatStorage implements Serializable {
	private ArrayList<Owner> Owners;
	private ArrayList<Boat> Boats; 
	
	/**
	 * BoatStorage Constructor
	 */
	public BoatStorage()
	{
		setOwners(new ArrayList<>());
		setBoats(new ArrayList<>());
	}
	
	/**
	 * setter
	 * initialize owners list in boatStorage class
	 * @param owners
	 */
	public void setOwners(ArrayList<Owner> owners)
	{
		this.Owners = owners;
	}
	
	/**
	 * setter
	 * initialize boats list in boatStorage class
	 * @param boats
	 */
	public void setBoats(ArrayList<Boat> boats)	
	{
		this.Boats = boats;
	}
	
	/**
	 * getter
	 * gets owners list from boatStorage class
	 * @return Owners
	 */
	public ArrayList<Owner> getOwners()
	{
		return Owners;
	}
	
	/**
	 * getter
	 * gets boats list from boatStorage class
	 * @return Boats
	 */
	public ArrayList<Boat> getBoats()
	{
		return Boats;
	}
	
	/**
	 * add owner to owners list from boatStorage class
	 * @param o
	 */
	public void addOwner(Owner o)
	{
		Owners.add(o);
	}
	
	/**
	 * add boat to boats list from boatStorage class
	 * @param b
	 */
	public void addBoat(Boat b)
	{
		Boats.add(b);
	}
	
	/**
	 * Search through the list and find owner id Number same as the parameter
	 * and return back the match idNumber owner object
	 * @param idNumber
	 * @return specified owner
	 */
	public Owner getspecifiedOwner(int idNumber)
	{
		return getOwners().stream()
				.filter(o ->  o.getIdNumber() == idNumber)
				.findAny()
				.orElse(null);
	}
	
	
	/**
	 * Search through the list and find owner id Number same as the parameter
	 * and update the match idNumber owner object
	 * @param idNumber
	 * @param owner
	 */
	public void updatespecifiedOwner(int idNumber, Owner owner)
	{
		getspecifiedOwner(idNumber).setName(owner.getName());;
		getspecifiedOwner(idNumber).setAddress(owner.getAddress());;
	}
	
	/**
	 * Search through the list and find owner id Number same as the parameter
	 * and return back the match idNumber owner object
	 * @param idNumber
	 * @return
	 */
	public Boat getspecifiedBoat(int idNumber)
	{
		return getBoats().stream()
				.filter(b -> b.getIdNumber() == idNumber)
				.findAny()
				.orElse(null);
	}
	
	/**
	 * get Owner list back as non sorted list
	 * @return owners
	 */
	public String nonSortedOwner()
	{
		return getOwners()
				.stream()
				.map(Owner::toName)
				.collect(Collectors.joining("\n"));
	}
	
	/**
	 * get Owner list back as sorted list sorted by name
	 * @return owners
	 */
	public String sortedOwnerNames()
	{
		return getOwners()
				.stream()
				.sorted(Comparator.comparing(Owner::getName))
				.map(Owner::toName)
				.collect(Collectors.joining("\n"));
	}
	
	/**
	 * get Owner list back as sorted list sorted by total monthly charge
	 * @return owners
	 */
	public String sortedOwnerTotalChargePayments()
	{
		return getOwners()
				.stream()
				.sorted(Comparator.comparing(Owner::totalOwnerCharge))
				.map(Owner::toName)
				.collect(Collectors.joining("\n"));
	}
	
	/**
	 *  get Owner list back as sorted list sorted by name
	 * @return owners ArrayList<>
	 */
	public ArrayList<Owner> sortedOwnerNameObjects()
	{
		return (ArrayList<Owner>) getOwners()
									.stream()
									.sorted(Comparator.comparing(Owner::getName))
									.collect(Collectors.toList());
	}

	/**
	 * get Owner list back as sorted list sorted by total monthly charge
	 * @return owners ArrayList<>
	 */
	public ArrayList<Owner> sortedOwnerTotalMonthlyChargeObjects()
	{
		return (ArrayList<Owner>) getOwners()
									.stream()
									.sorted(Comparator.comparing(Owner::totalOwnerCharge))
									.collect(Collectors.toList());
	}
	
	/**
	 * get MotorBoat Count from Boats list
	 * @return boats
	 */
	public int getTotalMotorBoat()
	{
		return (int) getBoats().stream()
				.filter(b -> b instanceof MotorBoat)
				.count();
	}
	
	/**
	 * get SailBoat count from Boats list
	 * @return boats
	 */
	public int getTotalSailBoats()
	{
		return (int) getBoats().stream()
				.filter(b -> b instanceof SailBoat)
				.count();
	}
	
	/**
	 * get total sail drying charge by all SailBoat type class
	 * @return double
	 */
	public double totalSailDryingCharge()
	{
		return getBoats().stream()
				.filter(sb -> sb instanceof SailBoat)
				.mapToDouble(sb -> sb.sailDryingCharge())
				.sum();
	}
	
	/**
	 * get total insurance charge by all MotorBoat type class
	 * @return double
	 */
	public double totalInsuranceCharge()
	{
		return getBoats().stream()
				.filter(mb -> mb instanceof MotorBoat)
				.mapToDouble(mb -> mb.insuranceCharge())
				.sum();
	}
	
	/**
	 * get total levyRate charge by all MotorBoat type class
	 * @return double
	 */
	public double totalLevyRate()
	{
		return getBoats().stream()
				.filter(mb -> mb instanceof MotorBoat)
				.mapToDouble(mb -> mb.levyRate())
				.sum();
	}
	
	/**
	 * get total fireRate charge by all MotorBoat type class
	 * @return double
	 */
	public double totalFireRate()
	{
		return getBoats().stream()
				.filter(mb -> mb instanceof MotorBoat)
				.mapToDouble(mb -> mb.fireRate())
				.sum();
	}
	
	/**
	 * get total charge from all owners with the sum collected by the boat they owner
	 * @return double
	 */
	public double getTotalCharges()
	{
		return getOwners().stream()
				.mapToDouble(Owner::totalOwnerCharge)
				.sum();
	}
}
