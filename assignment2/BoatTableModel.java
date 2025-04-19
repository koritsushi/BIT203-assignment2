package assignment2;

import javax.swing.table.AbstractTableModel;

public class BoatTableModel extends AbstractTableModel {

	static String[] title = {"ID", "Owner ID", "Height", "Length", "Width", "Mast Height", "Sail Area", "Horsepower", "Value", "Charge Rate"};
	private BoatStorage bs;
	
	public BoatTableModel(BoatStorage bs)
	{
		setBoatStorage(bs);
	}
	
	private void setBoatStorage(BoatStorage bs)
	{
		this.bs = bs;
	}
	
	public BoatStorage getBoatStorage()
	{
		return bs;
	}
	
	public String getColumnName(int col) {
		return title[col];
	}
	
	public int getColumnCount() {
		return title.length;
	}
	
	public int getRowCount()
	{
		return bs.getBoats().size();
	}
	
	public Object getValueAt(int row, int col) 
	{
		Boat boat = bs.getspecifiedBoat(row+1);
		if (boat == null)
			return null;
		switch (col)
		{
			case 0:
				return boat.getIdNumber();
			case 1:
				return boat.getOwner().getIdNumber();
			case 2:
				return boat.getHeight();
			case 3:
				return boat.getLength();
			case 4:
				return boat.getWidth();
			case 5:
				if (boat instanceof SailBoat sb)
					return sb.getMastHeight();
				else
					return "N/A";
			case 6:
				if (boat instanceof SailBoat sb)
					return sb.getSailArea();
				else
					return "N/A";
			case 7:
				if (boat instanceof MotorBoat mb)
					return mb.getHorsePower();
				else
					return "N/A";
			case 8:
				return boat.getBoatValue();
			case 9:
				return boat.getChargeRate();
		}
		return boat;
	}
}
