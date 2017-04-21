package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import coinpurse.Purse;

public class PurseBalanceObserver extends JFrame implements Observer {
	private JTextField text;
	
	private final int FONT_SIZE = 60;
	
	public PurseBalanceObserver() {
		
	}

	private void initComponents() {
		text = new JTextField(9);
		text.setEditable(false);
		text.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		
		this.add(text);
		this.pack();
	}
	
	public void run() {
		initComponents();
		this.setTitle("Purse Balance Observer");
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void update(Observable subject, Object info) {
//		if(info != null) text.append(">>> "+info+"\n");
		if( subject instanceof Purse) {
			Purse purse = (Purse) subject;
			text.setText(purse.getBalance()+" "+purse.getCurrency());
		}
	}

}
