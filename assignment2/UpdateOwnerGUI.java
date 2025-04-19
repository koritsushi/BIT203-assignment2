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
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Mah_LiYuan_B2000511
 * UpdateOwnerGUI Class
 */
public class UpdateOwnerGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextField tfID;
	private JTextField tfName;
	private JTextArea taAddress;
	private BoatStorage bs;
	private Owner owner;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			UpdateOwnerGUI dialog = new UpdateOwnerGUI();
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
	public UpdateOwnerGUI() {
		bs = BoatStorageGUI.getBS();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Update Owner Details");
			lblNewLabel.setBounds(165, 25, 119, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Owner ID:");
			lblNewLabel_1.setBounds(85, 50, 91, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			tfID = new JTextField();
			
			tfID.setBounds(204, 50, 139, 20);
			contentPanel.add(tfID);
			tfID.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Owner Name:");
			lblNewLabel_2.setBounds(85, 111, 91, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			tfName = new JTextField();
			tfName.setBounds(204, 108, 139, 20);
			contentPanel.add(tfName);
			tfName.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Owner Address:");
			lblNewLabel_3.setBounds(85, 136, 91, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			taAddress = new JTextArea();
			taAddress.setBounds(204, 139, 139, 65);
			contentPanel.add(taAddress);
		}
		{
			JButton btnGetOwner = new JButton("Get Owner Details");
			btnGetOwner.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ownerID = tfID.getText();
					
					if (ownerID.trim().isEmpty())
					{
						JOptionPane.showMessageDialog(UpdateOwnerGUI.this, "Please enter a value in Owner ID!");
						tfID.requestFocus();
						return ;
					}
					try
					{
						owner = bs.getspecifiedOwner(Integer.parseInt(ownerID));
						if (owner == null)
						{
							JOptionPane.showMessageDialog(UpdateOwnerGUI.this, "Please enter a valid Owner ID!");
							tfID.setText("");
							tfID.requestFocus();
							return ;
						}
					}
					catch (NumberFormatException goex)
					{
						JOptionPane.showMessageDialog(UpdateOwnerGUI.this, "Please enter a numeric value in Owner ID!");
						tfID.setText("");
						tfID.requestFocus();
						return ;
					}
					
					tfName.setEnabled(true);
					taAddress.setEnabled(true);
					tfName.setText(owner.getName());
					taAddress.setText(owner.getAddress());
						
				}
			});
			btnGetOwner.setBounds(204, 74, 139, 23);
			contentPanel.add(btnGetOwner);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 230, 434, 31);
			contentPanel.add(buttonPane);
			{
				JButton btnClear = new JButton("Clear");
				btnClear.setBounds(249, 5, 85, 23);
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				buttonPane.setLayout(null);
				btnClear.setActionCommand("Cancel");
				buttonPane.add(btnClear);
			}
			{
				JButton btnUpdate = new JButton("Update");
				btnUpdate.setBounds(344, 5, 85, 23);
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = tfName.getText();
						String Address = taAddress.getText();
						
						if (name.trim().isEmpty())
						{
							JOptionPane.showMessageDialog(UpdateOwnerGUI.this, "Please enter value in Owner Name!");
							tfName.setText("");
							tfName.requestFocus();
							return ;
						}
						else if (Address.trim().isEmpty())
						{
							JOptionPane.showMessageDialog(UpdateOwnerGUI.this, "Please enter value in Owner Address!");
							taAddress.setText("");
							taAddress.requestFocus();
						}
						
						owner.setName(name);
						owner.setAddress(Address);
						JOptionPane.showMessageDialog(UpdateOwnerGUI.this, 
								"Successfully updated owner id:" + owner.getIdNumber());
						clear();
						init();
					}
				});
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton btnBack = new JButton("Back to Main Menu");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UpdateOwnerGUI.this.dispose();
					}
				});
				btnBack.setBounds(10, 5, 145, 23);
				buttonPane.add(btnBack);
			}
		}
	}
	
	public void init()
	{
		tfName.setEnabled(false);
		taAddress.setEnabled(false);
	}
	
	public void clear()
	{
		tfID.setText("");
		tfName.setText("");
		taAddress.setText("");
	}

}
