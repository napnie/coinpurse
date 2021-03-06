package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import coinpurse.Purse;

/**
 * GUI Observer for Purse Status.
 * @author Nitith Chayakul
 *
 */
public class PurseStatusObserver extends JFrame implements Observer {
	/** component for display Purse status */
	private JTextField text;
	/** component for display Puarse current size */
	private JProgressBar bar;
	/** Constant for font size */
	private final int FONT_SIZE = 60;
	
	/**
	 * Run this GUI
	 */
	public void run() {
		initComponents();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setTitle("Purse Status Observer");
		this.setVisible(true);
	}

	/**
	 * Initialize components in this GUI.
	 */
	private void initComponents() {
		text = new JTextField(14);
		text.setEditable(false);
		text.setBackground(Color.BLACK);
		text.setFont(new Font(Font.DIALOG, Font.BOLD, FONT_SIZE));
		
		text.setForeground(Color.YELLOW);
		text.setText("Empty");

		text.setHorizontalAlignment(SwingConstants.CENTER);
		
		bar = new JProgressBar();
		bar.setMinimum(0);
		bar.setValue(0);
		bar.setStringPainted(true);
		
		this.setLayout(new BorderLayout() );
		this.add(text, BorderLayout.NORTH);
		this.add(bar, BorderLayout.SOUTH);
		this.pack();
	}

	/**
	 * Update display from Purse notification.
	 */
	@Override
	public void update(Observable subject, Object info) {
		if( subject instanceof Purse ) {
			Purse purse = (Purse) subject;
			bar.setMaximum(purse.getCapacity());
			if( purse.isFull() ) {
				text.setForeground(Color.RED);
				text.setText("Full");
				bar.setForeground(Color.RED);
			} else if ( purse.count() > 0 ) {
				text.setForeground(Color.GREEN);
				text.setText("Currently have : "+purse.count()+"/"+purse.getCapacity() );
				bar.setForeground(Color.GREEN);
			} else {
				text.setForeground(Color.YELLOW);
				text.setText("Empty");
			}
			bar.setValue( purse.count() );
		}
	}
}
