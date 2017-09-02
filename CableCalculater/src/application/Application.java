package application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Application {
	
	

	private JFrame frame;
	private DrawerPanel drawer_panel;
	
	int cablelenght;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		frame.setBounds(100, 100, 727, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		
		drawer_panel = new DrawerPanel();
		drawer_panel.setBounds(0, 49, 724, 363);
		frame.getContentPane().add(drawer_panel);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 0, 724, 38);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRIM ALGORITHMS EXAMPLE");
		lblNewLabel.setBounds(272, 11, 173, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		
		
		
		drawer_panel.addMouseListener(drawer_panel);
		drawer_panel.addMouseMotionListener(drawer_panel);
		
		
	}

}
