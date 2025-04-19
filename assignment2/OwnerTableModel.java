package assignment2;

import javax.swing.table.AbstractTableModel;

public class OwnerTableModel extends AbstractTableModel{

	static String[] title = {"ID", "Name", "Address", "Total Boats", "TotalMonthlyCharge"};
	private BoatStorage bs;
	
	public OwnerTableModel(BoatStorage bs)
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
	
	public int getRowCount() {
		return bs.getOwners().size();
	}
	
	public Object getValueAt(int row, int col) {
		Owner owner = bs.getspecifiedOwner(row+1);
		switch (col)
		{
			case 0:
				return owner.getIdNumber();
			case 1:
				return owner.getName();
			case 2:
				return owner.getAddress();
			case 3:
				return owner.getBoats().size();
			case 4:
				return owner.totalOwnerCharge();
			default:
				return "N/A";
		}
	}
}
