package Registration;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Menu.*;

public class Confirm extends JFrame {
	JLabel jl;
	JButton b;
	public Confirm() {
		this.setSize(500,560);
		this.setTitle("Registration Complete");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.getContentPane().setBackground(Color.yellow);
	    this.addComponent();
	}
	private void addComponent()
	{
		jl = new JLabel("Your Registration is Complete..... ");
		jl.setBounds(100,80,400,40);
		jl.setFont(new Font("Serif", Font.BOLD, 20));
		jl.setForeground(Color.blue);
		add(jl);
		
		b= new JButton("Goto Menu");
		b.setBounds(180, 380, 150, 40);
		add(b);
		b.addActionListener(new Reghndl());
	}
	public class Reghndl implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) {
			dispose();
			StartFrame f = new StartFrame();
			f.setVisible(true);
			
		}
		
	}

}
