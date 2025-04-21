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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

/**
 * @author Mah_LiYuan_B2000511
 * RegisterBoatGUI class
 * this graphical user interface allow admin to register boat to owner
 */
public class RegisterBoatGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfOwnerID;
	private JTextField tfHeight;
	private JTextField tfLength;
	private JTextField tfWidth;
	private JTextField tfMastHeight;
	private JTextField tfSailArea;
	private JTextField tfHorsePower;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnSailBoat;
	private JRadioButton rdbtnMotorboat;
	
	private BoatStorage bs;
	private Owner owner;
	private JTextField tfValue;
	private JTextField tfChargeRate;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			RegisterBoatGUI dialog = new RegisterBoatGUI();
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
	public RegisterBoatGUI() {
		bs = BoatStorageGUI.getBS();
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 377, 434, 34);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				//register boat details to owner and add to boatstorage class
				JButton btnRegister = new JButton("Register");
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Boat boat;
						
						String id = tfOwnerID.getText();
						if (id.isEmpty())
						{
							JOptionPane.showMessageDialog(RegisterBoatGUI.this, "Please enter an Owner ID!");
							tfOwnerID.requestFocus();
							return ;
						}
						try 
						{
							owner = bs.getspecifiedOwner(Integer.parseInt(id));
							if (owner == null)
							{
								JOptionPane.showMessageDialog(RegisterBoatGUI.this, 
										"Please Enter a existing Owner ID!");
								return ;
							}
						}
						catch (NumberFormatException IDex)
						{
							JOptionPane.showMessageDialog(RegisterBoatGUI.this, 
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
							JOptionPane.showMessageDialog(RegisterBoatGUI.this, "Please enter numeric value in all fields");
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
										JOptionPane.showMessageDialog(RegisterBoatGUI.this, 
												"Please enter the value for mast height!");
										tfMastHeight.requestFocus();
										return ;
									}
									else if (sailArea.isEmpty())
									{
										JOptionPane.showMessageDialog(RegisterBoatGUI.this, 
												"Please enter the value for mast height!");
										tfSailArea.requestFocus();
										return ;
									}
									double nmastHeight = Double.parseDouble(mastHeight);
									double nsailArea = Double.parseDouble(sailArea);
									
									boat = new SailBoat(owner, nheight, nlength, nwidth, nValue, nChargeRate, nmastHeight, nsailArea);
									owner.addBoat(boat);
									bs.addBoat(boat);
								}
								else
								{
									String horsePower = tfHorsePower.getText();
									if (horsePower.isEmpty())
									{
										JOptionPane.showMessageDialog(RegisterBoatGUI.this, 
												"Please enter the value for horsePower!");
										tfHorsePower.requestFocus();
										return ;
									}
									double nHorsePower = Double.parseDouble(horsePower);
									boat = new MotorBoat(owner, nheight, nlength, nwidth, nValue, nChargeRate, nHorsePower);
									owner.addBoat(boat);
									bs.addBoat(boat);
								}
								JOptionPane.showMessageDialog(RegisterBoatGUI.this, "Successfully register boat id:" 
										+ boat.getIdNumber() + " to owner:" + owner.getIdNumber() + "!");
								clearText();
							} catch (NumberFormatException RGB) {
								JOptionPane.showMessageDialog(RegisterBoatGUI.this, 
										"Please Enter Numeric Value for all of the field!");
							}
						}
					}
				});
				btnRegister.setBounds(319, 5, 105, 23);
				btnRegister.setActionCommand("OK");
				buttonPane.add(btnRegister);
				getRootPane().setDefaultButton(btnRegister);
			}
			{
				JButton btnClear = new JButton("Clear");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnClear.setBounds(244, 5, 65, 23);
				btnClear.setActionCommand("Cancel");
				buttonPane.add(btnClear);
			}
			{
				JButton btnBack = new JButton("Back to Main Menu");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegisterBoatGUI.this.dispose();
					}
				});
				btnBack.setBounds(10, 5, 148, 23);
				buttonPane.add(btnBack);
			}
		}
		{
			JLabel label = new JLabel("Boat Type:");
			label.setBounds(49, 106, 109, 14);
			contentPanel.add(label);
		}
		
		JLabel lblNewLabel = new JLabel("Owner ID:");
		lblNewLabel.setBounds(49, 72, 109, 14);
		contentPanel.add(lblNewLabel);
		
		tfOwnerID = new JTextField();
		tfOwnerID.setBounds(183, 67, 210, 20);
		contentPanel.add(tfOwnerID);
		tfOwnerID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Height:");
		lblNewLabel_1.setBounds(49, 149, 88, 14);
		
		contentPanel.add(lblNewLabel_1);
		
		tfHeight = new JTextField();
		tfHeight.setBounds(183, 146, 210, 20);
		contentPanel.add(tfHeight);
		tfHeight.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Length:");
		lblNewLabel_2.setBounds(49, 174, 88, 14);
		contentPanel.add(lblNewLabel_2);
		
		tfLength = new JTextField();
		tfLength.setBounds(183, 171, 210, 20);
		contentPanel.add(tfLength);
		tfLength.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Width:");
		lblNewLabel_3.setBounds(49, 199, 88, 14);
		contentPanel.add(lblNewLabel_3);
		
		tfWidth = new JTextField();
		tfWidth.setBounds(183, 196, 210, 20);
		contentPanel.add(tfWidth);
		tfWidth.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mast Height:");
		lblNewLabel_4.setBounds(49, 224, 109, 14);
		contentPanel.add(lblNewLabel_4);
		
		tfMastHeight = new JTextField();
		tfMastHeight.setBounds(183, 221, 210, 20);
		contentPanel.add(tfMastHeight);
		tfMastHeight.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sail Area:");
		lblNewLabel_5.setBounds(49, 249, 88, 14);
		contentPanel.add(lblNewLabel_5);
		
		tfSailArea = new JTextField();
		tfSailArea.setBounds(183, 246, 210, 20);
		contentPanel.add(tfSailArea);
		tfSailArea.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Horsepower:");
		lblNewLabel_6.setBounds(49, 274, 124, 14);
		contentPanel.add(lblNewLabel_6);
		
		tfHorsePower = new JTextField();
		tfHorsePower.setBounds(183, 271, 210, 20);
		contentPanel.add(tfHorsePower);
		tfHorsePower.setColumns(10);
		
		//set radiobutton to buttongroup to allow user to enable one radiobutton only
		JPanel rbpanel = new JPanel();
		rbpanel.setBounds(183, 106, 210, 29);
		contentPanel.add(rbpanel);
		{
			rdbtnSailBoat = new JRadioButton("SailBoat");
			rdbtnSailBoat.setSelected(true);
			rdbtnSailBoat.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					init();
				}
			});
			buttonGroup.add(rdbtnSailBoat);
			rbpanel.add(rdbtnSailBoat);
				
			rdbtnMotorboat = new JRadioButton("MotorBoat");
			buttonGroup.add(rdbtnMotorboat);
			rbpanel.add(rdbtnMotorboat);
		}
		
		JLabel lblNewLabel_7 = new JLabel("Value:");
		lblNewLabel_7.setBounds(49, 299, 88, 14);
		contentPanel.add(lblNewLabel_7);
		
		tfValue = new JTextField();
		tfValue.setBounds(183, 296, 210, 20);
		contentPanel.add(tfValue);
		tfValue.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Charge Rate:");
		lblNewLabel_8.setBounds(49, 324, 124, 14);
		contentPanel.add(lblNewLabel_8);
		
		tfChargeRate = new JTextField();
		tfChargeRate.setBounds(183, 321, 210, 20);
		contentPanel.add(tfChargeRate);
		tfChargeRate.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Create Boat Details");
		lblNewLabel_9.setBounds(166, 32, 109, 14);
		contentPanel.add(lblNewLabel_9);
	}
	
	//set radiobutton enable or disabled depending which radio button user choose
	public void init()
	{
		if (rdbtnSailBoat.isSelected())
		{
			tfMastHeight.setEnabled(true);
			tfSailArea.setEnabled(true);
			tfHorsePower.setEnabled(false);
			tfHorsePower.setText("");
		}
		else
		{
			tfMastHeight.setEnabled(false);
			tfSailArea.setEnabled(false);
			tfMastHeight.setText("");
			tfSailArea.setText("");
			tfHorsePower.setEnabled(true);
		}
	}
	
	
	//clear all of the gui textfield
	public void clearText() {
		tfOwnerID.setText("");
		tfHeight.setText("");;
		tfLength.setText("");;
		tfWidth.setText("");;
		tfMastHeight.setText("");
		tfSailArea.setText("");
		tfHorsePower.setText("");
		tfValue.setText("");
		tfChargeRate.setText("");
	}
}
