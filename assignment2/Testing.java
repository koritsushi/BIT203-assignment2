package assignment2;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Owner owner = new Owner("doe", "lot 10");
		MotorBoat mb = new MotorBoat(owner, 100, 100, 100, 100, 100, 100);
		MotorBoat mb1 = new MotorBoat(owner, 100, 100, 100, 100, 100, 100);
		SailBoat sb = new SailBoat(owner, 100, 100, 100, 100, 100, 100, 100);
		owner.addBoat(mb);
		owner.addBoat(mb1);
		owner.addBoat(sb);
		Owner owner1 = new Owner("doe", "lot 10");
		MotorBoat m1 = new MotorBoat(owner1, 100, 100, 100, 100, 100, 100);
		MotorBoat m2 = new MotorBoat(owner1, 100, 100, 100, 100, 100, 100);
		SailBoat sb1 = new SailBoat(owner1, 100, 100, 100, 100, 100, 100, 100);
		owner1.addBoat(m1);
		owner1.addBoat(m2);
		owner1.addBoat(sb1);
		System.out.println(owner.ToString());
		System.out.println(owner1.ToString());
	}

}
