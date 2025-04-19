package assignment2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Mah_LiYuan_B2000511
 * DisplayOwnersGUI Class
 */
public class DisplayOwnersGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JTable ownerTable;
	private OwnerTableModel otm;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			DisplayOwnersGUI dialog = new DisplayOwnersGUI();
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
	public DisplayOwnersGUI() {
		otm = new OwnerTableModel(BoatStorageGUI.getBS());
		
		setBounds(100, 100, 955, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//table = new JTable(otm);
		//table.setBounds(0, 0, 434, 228);
		//contentPanel.add(table);
		
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("All Owner Details");
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				ownerTable = new JTable(otm);
				scrollPane.setViewportView(ownerTable);
			}
		}

		{
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnBack = new JButton("Back to Main Menu");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DisplayOwnersGUI.this.dispose();
					}
				});
				btnBack.setActionCommand("OK");
				buttonPane.add(btnBack);
				getRootPane().setDefaultButton(btnBack);
			}
		}
	}
}
