package assignment2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class RegisterOwnerGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField tfName;
	private JTextField tfAddress;
	/**
	 * Launch the application.
	 */
	/*
		public static void main(String[] args) {
			try {
				RegisterOwnerGUI dialog = new RegisterOwnerGUI();
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
	private void clearText()
	{
		tfName.setText("");
		tfAddress.setText("");
	}
	
	public RegisterOwnerGUI() {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 201);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(51, 54, 72, 14);
		panel.add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setBounds(174, 51, 155, 20);
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setBounds(51, 79, 72, 14);
		panel.add(lblNewLabel_1);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(174, 82, 155, 59);
		panel.add(tfAddress);
		tfAddress.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Register Owner Details");
		lblNewLabel_2.setBounds(127, 11, 127, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 219, 414, 42);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnBack = new JButton("Back to Main Menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterOwnerGUI.this.dispose();
			}
		});
		btnBack.setBounds(10, 11, 163, 23);
		panel_1.add(btnBack);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
		btnClear.setBounds(224, 11, 89, 23);
		panel_1.add(btnClear);
		
		JButton btnRegisterOwner = new JButton("Register");
		btnRegisterOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String address = tfAddress.getText();
				
				if (name.isEmpty() || address.isEmpty())
				{	
					JOptionPane.showMessageDialog(RegisterOwnerGUI.this, "Please fill up all fields!");
					tfName.requestFocus();
				}
				Owner o = new Owner(name, address);
				BoatStorageGUI.getBS().addOwner(o);
				JOptionPane.showMessageDialog(RegisterOwnerGUI.this,"Successfully Register Owner! Owner id: " + o.getIdNumber());
				clearText();
			}
		});
		System.out.println(BoatStorageGUI.getBS().nonSortedOwner());
		btnRegisterOwner.setBounds(323, 11, 89, 23);
		panel_1.add(btnRegisterOwner);
	}
}
