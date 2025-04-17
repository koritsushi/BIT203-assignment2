package assignment2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BoatStorageGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoatStorageGUI frame = new BoatStorageGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BoatStorageGUI() {
		setTitle("BoatStorage Management B2000511");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JButton btnRegisterOwner = new JButton("Register Owner");
		panel.add(btnRegisterOwner);
		
		JButton btnRegisterBoat = new JButton("Register Boat");
		sl_panel.putConstraint(SpringLayout.NORTH, btnRegisterBoat, 79, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnRegisterOwner, 0, SpringLayout.WEST, btnRegisterBoat);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnRegisterOwner, -6, SpringLayout.NORTH, btnRegisterBoat);
		panel.add(btnRegisterBoat);
		
		JButton btnDisplayBoatCount = new JButton("Display Total Boat Count");
		sl_panel.putConstraint(SpringLayout.WEST, btnRegisterBoat, 0, SpringLayout.WEST, btnDisplayBoatCount);
		sl_panel.putConstraint(SpringLayout.EAST, btnDisplayBoatCount, -133, SpringLayout.EAST, panel);
		panel.add(btnDisplayBoatCount);
		
		JButton btnDisplayAllOwner = new JButton("Display All Owner");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnDisplayAllOwner, -69, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnDisplayBoatCount, -6, SpringLayout.NORTH, btnDisplayAllOwner);
		sl_panel.putConstraint(SpringLayout.WEST, btnDisplayAllOwner, 0, SpringLayout.WEST, btnRegisterOwner);
		panel.add(btnDisplayAllOwner);
		
		JButton btnExit = new JButton("Exit");
		sl_panel.putConstraint(SpringLayout.NORTH, btnExit, 16, SpringLayout.SOUTH, btnDisplayAllOwner);
		sl_panel.putConstraint(SpringLayout.EAST, btnExit, 0, SpringLayout.EAST, btnRegisterBoat);
		panel.add(btnExit);
		
		JLabel lblTitle = new JLabel("BoatStorage Management");
		sl_panel.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblTitle, -144, SpringLayout.EAST, panel);
		panel.add(lblTitle);
	}
}
