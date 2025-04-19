package assignment2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Mah_LiYuan_B2000511
 * DisplayBoatsGUI class
 */
public class DisplayBoatsGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JTable boatTable;
	private BoatTableModel btm;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			DisplayBoatsGUI dialog = new DisplayBoatsGUI();
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
	public DisplayBoatsGUI() {
		btm = new BoatTableModel(BoatStorageGUI.getBS());
		
		setBounds(100, 100, 950, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("All Owner Details");
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				boatTable = new JTable(btm);
				scrollPane.setViewportView(boatTable);
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
						DisplayBoatsGUI.this.dispose();
					}
				});
				btnBack.setActionCommand("Cancel");
				buttonPane.add(btnBack);
			}
		}
	}

}
