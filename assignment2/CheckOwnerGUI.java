package assignment2;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOwnerGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfOwnerID;

	private BoatStorage bs;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			CheckOwnerGUI dialog = new CheckOwnerGUI();
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
	public CheckOwnerGUI() {
		bs = BoatStorageGUI.getBS();
		
		setBounds(100, 100, 260, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Owner ID:");
		lblNewLabel.setBounds(33, 84, 62, 14);
		contentPanel.add(lblNewLabel);
		
		tfOwnerID = new JTextField();
		tfOwnerID.setBounds(116, 81, 86, 20);
		contentPanel.add(tfOwnerID);
		tfOwnerID.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Check Owner ID");
		lblNewLabel_1.setBounds(77, 25, 96, 14);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCheck = new JButton("Check");
				btnCheck.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ownerID = tfOwnerID.getText();
						
						if (ownerID.isEmpty())
						{
							JOptionPane.showMessageDialog(CheckOwnerGUI.this, "Please fill in an ID!");
							tfOwnerID.requestFocus();
							return ;
						}
						try
						{
							int ID = Integer.parseInt(ownerID);
							if (ID < 1)
							{
								JOptionPane.showMessageDialog(CheckOwnerGUI.this, "Owner ID must be greater than 1!");
								tfOwnerID.setText("");
								tfOwnerID.requestFocus();
								return ;
							}
							Owner owner = bs.getspecifiedOwner(ID);
							if (owner == null)
							{
								JOptionPane.showMessageDialog(CheckOwnerGUI.this, "Owner ID not exist!");
								tfOwnerID.setText("");
								tfOwnerID.requestFocus();
								return ;
							}
							JOptionPane.showMessageDialog(CheckOwnerGUI.this, "Owner Total Monthly Charge:\nRM" + owner.totalOwnerCharge());
						}
						catch (NumberFormatException numex)
						{
							JOptionPane.showMessageDialog(null, "Please Enter a numeric value for ID!");
							tfOwnerID.setText("");
							tfOwnerID.requestFocus();
						}
					}
				});
				btnCheck.setActionCommand("OK");
				buttonPane.add(btnCheck);
				getRootPane().setDefaultButton(btnCheck);
			}
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CheckOwnerGUI.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
}
