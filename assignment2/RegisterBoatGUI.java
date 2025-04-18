package assignment2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	private BoatStorage bsg;
	private Boat boat;
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
		bsg = BoatStorageGUI.getBS();
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 316, 434, 34);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton btnRegister = new JButton("Register");
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
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
			label.setBounds(62, 55, 67, 14);
			contentPanel.add(label);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(154, 47, 210, 34);
			contentPanel.add(panel);
			
			JRadioButton rdbtnSailBoat = new JRadioButton("SailBoat");
			rdbtnSailBoat.setSelected(true);
			panel.add(rdbtnSailBoat);
			
			JRadioButton rdbtnMotorBoat = new JRadioButton("MotorBoat");
			panel.add(rdbtnMotorBoat);
		}
		
		JLabel lblNewLabel = new JLabel("Owner ID:");
		lblNewLabel.setBounds(62, 21, 67, 14);
		contentPanel.add(lblNewLabel);
		
		tfOwnerID = new JTextField();
		tfOwnerID.setBounds(154, 16, 210, 20);
		contentPanel.add(tfOwnerID);
		tfOwnerID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Height:");
		lblNewLabel_1.setBounds(62, 98, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		tfHeight = new JTextField();
		tfHeight.setBounds(154, 95, 210, 20);
		contentPanel.add(tfHeight);
		tfHeight.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Length:");
		lblNewLabel_2.setBounds(62, 123, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		tfLength = new JTextField();
		tfLength.setBounds(154, 120, 210, 20);
		contentPanel.add(tfLength);
		tfLength.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Width:");
		lblNewLabel_3.setBounds(62, 148, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		tfWidth = new JTextField();
		tfWidth.setBounds(154, 145, 210, 20);
		contentPanel.add(tfWidth);
		tfWidth.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mast Height:");
		lblNewLabel_4.setBounds(62, 173, 67, 14);
		contentPanel.add(lblNewLabel_4);
		
		tfMastHeight = new JTextField();
		tfMastHeight.setBounds(154, 170, 210, 20);
		contentPanel.add(tfMastHeight);
		tfMastHeight.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sail Area:");
		lblNewLabel_5.setBounds(62, 198, 46, 14);
		contentPanel.add(lblNewLabel_5);
		
		tfSailArea = new JTextField();
		tfSailArea.setBounds(154, 195, 210, 20);
		contentPanel.add(tfSailArea);
		tfSailArea.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Horse Power:");
		lblNewLabel_6.setBounds(62, 223, 67, 14);
		contentPanel.add(lblNewLabel_6);
		
		tfHorsePower = new JTextField();
		tfHorsePower.setBounds(154, 220, 210, 20);
		contentPanel.add(tfHorsePower);
		tfHorsePower.setColumns(10);
	}
}
