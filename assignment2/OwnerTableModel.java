package assignment2;

import javax.swing.table.AbstractTableModel;

public class OwnerTableModel extends AbstractTableModel{

	static String[] title = {"ID", "Name", "Address", "TotalMonthlyCharge"};
	private BoatStorage bs;
	
	public OwnerTableModel(BoatStorage bs)
	{
		this.bs = bs;
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
		Owner owner = bs.getspecifiedOwner(row);
		switch (col)
		{
			case 1:
				return owner.getIdNumber();
			case 2:
				return owner.getName();
			case 3:
				return owner.getAddress();
			case 4:
				return owner.totalOwnerCharge();
			default:
				return "N/A";
		}
	}
}
