package coinpurse.gui;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import coinpurse.Purse;

/**
 * GUI Observer for Purse balance.
 * @author Nitith Chayakul
 *
 */
public class PurseBalanceObserver extends JFrame implements Observer {
	/** Component for display balance */
	private JTextField text;
	/** Constant for font size */
	private final int FONT_SIZE = 60;
	
	/**
	 * Initialize components in this GUI.
	 */
	private void initComponents() {
		text = new JTextField(9);
		text.setEditable(false);
		text.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		
		this.add(text);
		this.pack();
	}
	
	/**
	 * Run this GUI
	 */
	public void run() {
		initComponents();
		this.setTitle("Purse Balance Observer");
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Update display from Purse notification. 
	 */
	@Override
	public void update(Observable subject, Object info) {
		if( subject instanceof Purse) {
			Purse purse = (Purse) subject;
			text.setText(purse.getBalance()+" "+purse.getCurrency());
		}
	}

}
