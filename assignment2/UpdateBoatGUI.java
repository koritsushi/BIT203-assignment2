package assignment2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;


/**
 * @author Mah_LiYuan_B2000511
 * UpdateBoatGUI Class
 * this graphical user interface allow admin to update boat details by reference
 */
public class UpdateBoatGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private BoatStorage bs;
	private Boat boat;
	
	private JTextField tfBoatID;
	private JTextField tfOwnerID;
	private JTextField tfHeight;
	private JTextField tfLength;
	private JTextField tfWidth;
	private JTextField tfMastHeight;
	private JTextField tfSailArea;
	private JTextField tfHorsepower;
	private JTextField tfValue;
	private JTextField tfChargeRate;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnSailBoat;
	private JRadioButton rdbtnMotorBoat;
	
	private JButton btnUpdate;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			UpdateBoatGUI dialog = new UpdateBoatGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public UpdateBoatGUI() {
		bs = BoatStorageGUI.getBS();
		
		setBounds(100, 100, 450, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Update Boat Details");
			lblNewLabel.setBounds(166, 11, 115, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Boat ID:");
			lblNewLabel_1.setBounds(56, 39, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Owner ID:");
			lblNewLabel_2.setBounds(54, 104, 88, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Boat Type:");
			lblNewLabel_3.setBounds(54, 143, 88, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Height:");
			lblNewLabel_4.setBounds(54, 175, 88, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Length:");
			lblNewLabel_5.setBounds(54, 200, 88, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Width:");
			lblNewLabel_6.setBounds(54, 225, 88, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Mast Height:");
			lblNewLabel_7.setBounds(54, 250, 88, 14);
			contentPanel.add(lblNewLabel_7);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Sail Area:");
			lblNewLabel_8.setBounds(54, 275, 88, 14);
			contentPanel.add(lblNewLabel_8);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("Horsepower:");
			lblNewLabel_9.setBounds(54, 300, 78, 14);
			contentPanel.add(lblNewLabel_9);
		}
		{
			JLabel lblNewLabel_10 = new JLabel("Value:");
			lblNewLabel_10.setBounds(56, 328, 78, 14);
			contentPanel.add(lblNewLabel_10);
		}
		{
			tfBoatID = new JTextField();
			tfBoatID.setBounds(166, 36, 220, 20);
			contentPanel.add(tfBoatID);
			tfBoatID.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(164, 132, 222, 30);
			contentPanel.add(panel);
			{
				rdbtnSailBoat = new JRadioButton("SailBoat");
				rdbtnSailBoat.setSelected(true);
				rdbtnSailBoat.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						RBactivity();
					}
				});
				buttonGroup.add(rdbtnSailBoat);
				panel.add(rdbtnSailBoat);
			}
			{
				rdbtnMotorBoat = new JRadioButton("MotorBoat");
				buttonGroup.add(rdbtnMotorBoat);
				panel.add(rdbtnMotorBoat);
			}
		}
		{
			tfOwnerID = new JTextField();
			tfOwnerID.setBounds(166, 101, 220, 20);
			contentPanel.add(tfOwnerID);
			tfOwnerID.setColumns(10);
		}
		{
			tfHeight = new JTextField();
			tfHeight.setBounds(166, 172, 220, 20);
			contentPanel.add(tfHeight);
			tfHeight.setColumns(10);
		}
		{
			tfLength = new JTextField();
			tfLength.setBounds(166, 197, 220, 20);
			contentPanel.add(tfLength);
			tfLength.setColumns(10);
		}
		{
			tfWidth = new JTextField();
			tfWidth.setBounds(166, 222, 220, 20);
			contentPanel.add(tfWidth);
			tfWidth.setColumns(10);
		}
		{
			tfMastHeight = new JTextField();
			tfMastHeight.setBounds(166, 247, 220, 20);
			contentPanel.add(tfMastHeight);
			tfMastHeight.setColumns(10);
		}
		{
			tfSailArea = new JTextField();
			tfSailArea.setBounds(166, 272, 220, 20);
			contentPanel.add(tfSailArea);
			tfSailArea.setColumns(10);
		}
		{
			tfHorsepower = new JTextField();
			tfHorsepower.setBounds(166, 297, 220, 20);
			contentPanel.add(tfHorsepower);
			tfHorsepower.setColumns(10);
		}
		{
			tfValue = new JTextField();
			tfValue.setBounds(166, 322, 220, 20);
			contentPanel.add(tfValue);
			tfValue.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 393, 434, 37);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton btnClear = new JButton("Clear");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clearText();
					}
				});
				btnClear.setBounds(246, 5, 84, 23);
				btnClear.setActionCommand("Cancel");
				buttonPane.add(btnClear);
			}
			{
				//update boat details by reference
				btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Owner owner;
						
						String id = tfOwnerID.getText();
						if (id.isEmpty())
						{
							JOptionPane.showMessageDialog(UpdateBoatGUI.this, "Please enter an Owner ID!");
							tfOwnerID.requestFocus();
							return ;
						}
						try 
						{
							owner = bs.getspecifiedOwner(Integer.parseInt(id));
							if (owner == null)
							{
								JOptionPane.showMessageDialog(UpdateBoatGUI.this, 
										"Please Enter a existing Owner ID!");
								return ;
							}
						}
						catch (NumberFormatException IDex)
						{
							JOptionPane.showMessageDialog(UpdateBoatGUI.this, 
									"Please Enter Numeric Value for the OwnerID!");
							return ;
						}
						
						String height = tfHeight.getText();
						String length = tfLength.getText();
						String width = tfWidth.getText();
						String value = tfValue.getText();
						String chargeRate = tfChargeRate.getText();
						
						if (height.isEmpty() || length.isEmpty() || width.isEmpty() || value.isEmpty() || chargeRate.isEmpty())
						{
							JOptionPane.showMessageDialog(UpdateBoatGUI.this, "Please enter numeric value in all fields");
						}
						else
						{
							try 
							{
								double nheight =  Double.parseDouble(height);
								double nlength = Double.parseDouble(length);
								double nwidth = Double.parseDouble(width);
								double nValue = Double.parseDouble(value);
								double nChargeRate = Double.parseDouble(chargeRate);
								
								
								if (rdbtnSailBoat.isSelected())
								{
									String mastHeight = tfMastHeight.getText();
									String sailArea = tfSailArea.getText();
									if (mastHeight.isEmpty())
									{
										JOptionPane.showMessageDialog(UpdateBoatGUI.this, 
												"Please enter the value for mast height!");
										tfMastHeight.requestFocus();
										return ;
									}
									else if (sailArea.isEmpty())
									{
										JOptionPane.showMessageDialog(UpdateBoatGUI.this, 
												"Please enter the value for mast height!");
										tfSailArea.requestFocus();
										return ;
									}
									double nmastHeight = Double.parseDouble(mastHeight);
									double nsailArea = Double.parseDouble(sailArea);
									
									//boat.setOwner(owner);
									boat.setHeight(nheight);
									boat.setLength(nlength);
									boat.setWidth(nwidth);
									boat.setBoatValue(nValue);
									boat.setChargeRate(nChargeRate);
									((SailBoat) boat).setMastHeight(nmastHeight);
									((SailBoat) boat).setSailArea(nsailArea);
								}
								else
								{
									String horsePower = tfHorsepower.getText();
									if (horsePower.isEmpty())
									{
										JOptionPane.showMessageDialog(UpdateBoatGUI.this, 
												"Please enter the value for horsePower!");
										tfHorsepower.requestFocus();
										return ;
									}
									double nHorsePower = Double.parseDouble(horsePower);
									
									//boat.setOwner(owner);
									boat.setHeight(nheight);
									boat.setLength(nlength);
									boat.setWidth(nwidth);
									boat.setBoatValue(nValue);
									boat.setChargeRate(nChargeRate);
									((MotorBoat) boat).setHorsePower(nHorsePower);
								}
								JOptionPane.showMessageDialog(UpdateBoatGUI.this, "Successfully update boat id:" 
										+ boat.getIdNumber() + " to owner:" + owner.getIdNumber() + "!");
								clearText();
								init();
							} catch (NumberFormatException UGB) {
								JOptionPane.showMessageDialog(UpdateBoatGUI.this, 
										"Please Enter Numeric Value for all of the field!");
							}
						}
					}
				});
				btnUpdate.setBounds(338, 5, 91, 23);
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton btnBack = new JButton("Back to Main Menu");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UpdateBoatGUI.this.dispose();
					}
				});
				btnBack.setBounds(10, 5, 158, 23);
				buttonPane.add(btnBack);
			}
		}
		{
			JLabel lblNewLabel_11 = new JLabel("Charge Rate:");
			lblNewLabel_11.setBounds(56, 356, 76, 14);
			contentPanel.add(lblNewLabel_11);
		}
		{
			tfChargeRate = new JTextField();
			tfChargeRate.setBounds(166, 353, 220, 20);
			contentPanel.add(tfChargeRate);
			tfChargeRate.setColumns(10);
		}
		{	//find boat details and check boat id validity
			JButton btnGetBoat = new JButton("Get Boat Details");
			btnGetBoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String boatID = tfBoatID.getText();
					if (boatID.trim().isEmpty())
					{
						JOptionPane.showMessageDialog(UpdateBoatGUI.this, "Enter a value for BoatID!");
						tfBoatID.requestFocus();
						return ;
					}
					try
					{
						int id = Integer.parseInt(boatID);
						boat = bs.getspecifiedBoat(id);
						if (boat == null)
						{
							JOptionPane.showMessageDialog(UpdateBoatGUI.this, "Enter a valid BoatID!");
							tfBoatID.setText("");
							tfBoatID.requestFocus();
							return ;
						}
					}
					catch (NumberFormatException ubgex)
					{
						JOptionPane.showMessageDialog(UpdateBoatGUI.this, "Enter a numeric value for BoatID!");
						tfBoatID.setText("");
						tfBoatID.requestFocus();
						return ;
					}
					enableTF();
					setDetails();
				}
			});
			btnGetBoat.setBounds(166, 67, 140, 23);
			contentPanel.add(btnGetBoat);
		}
		
	}
	
	//disabled all the textfield and radiobutton
	//except boatid
	public void init()
	{
		tfOwnerID.setEnabled(false);
		tfHeight.setEnabled(false);
		tfLength.setEnabled(false);
		tfWidth.setEnabled(false);
		tfMastHeight.setEnabled(false);
		tfSailArea.setEnabled(false);
		tfValue.setEnabled(false);
		tfChargeRate.setEnabled(false);
		rdbtnSailBoat.setEnabled(false);
		rdbtnMotorBoat.setEnabled(false);
		tfMastHeight.setEnabled(false);
		tfSailArea.setEnabled(false);
		tfHorsepower.setEnabled(false);
		btnUpdate.setEnabled(false);
	}
	
	private void RBactivity()
	{
		if (rdbtnSailBoat.isSelected())
		{
			tfMastHeight.setEnabled(true);
			tfSailArea.setEnabled(true);
			tfHorsepower.setEnabled(false);
			tfHorsepower.setText("");
		}
		else
		{
			tfMastHeight.setEnabled(false);
			tfSailArea.setEnabled(false);
			tfMastHeight.setText("");
			tfSailArea.setText("");
			tfHorsepower.setEnabled(true);
		}
	}
	
	//allocate boat details to textfield for admin to edit
	private void setDetails()
	{
		tfOwnerID.setText(Integer.toString(boat.getOwner().getIdNumber()));
		tfHeight.setText(Double.toString(boat.getHeight()));;
		tfLength.setText(Double.toString(boat.getLength()));;
		tfWidth.setText(Double.toString(boat.getWidth()));;
		if (boat instanceof SailBoat sb)
		{
			rdbtnSailBoat.setSelected(true);
			tfMastHeight.setText(Double.toString(sb.getMastHeight()));
			tfSailArea.setText(Double.toString(sb.getSailArea()));
		}
		else if (boat instanceof MotorBoat mb)
		{
			rdbtnMotorBoat.setSelected(true);
			tfHorsepower.setText(Double.toString(mb.getHorsePower()));
		}
				
		tfValue.setText(Double.toString(boat.getBoatValue()));
		tfChargeRate.setText(Double.toString(boat.getChargeRate()));
	}
	
	//emable textfield if user enter a valid boat id
	private void enableTF()
	{
		//tfOwnerID.setEnabled(true);
		tfHeight.setEnabled(true);
		tfLength.setEnabled(true);
		tfWidth.setEnabled(true);
		tfMastHeight.setEnabled(true);
		tfSailArea.setEnabled(true);
		tfHorsepower.setEnabled(true);
		tfValue.setEnabled(true);
		tfChargeRate.setEnabled(true);
		//rdbtnSailBoat.setEnabled(true);
		//rdbtnMotorBoat.setEnabled(true);
		RBactivity();
		btnUpdate.setEnabled(true);
	}
	
	//clear all textfield
	public void clearText() {
		tfBoatID.setText("");
		tfOwnerID.setText("");
		tfHeight.setText("");;
		tfLength.setText("");;
		tfWidth.setText("");;
		tfMastHeight.setText("");
		tfSailArea.setText("");
		tfHorsepower.setText("");
		tfValue.setText("");
		tfChargeRate.setText("");
	}

}
