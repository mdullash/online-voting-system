package Menu;
import Voter.*;
import Admin.*;
import Registration.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartFrame extends JFrame 
{
	JLabel j1,j2,j3;
	JButton b1,b2;
	JComboBox cb;
	public StartFrame() {
		this.setSize(500,560);
		this.setTitle("Online Voting System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.addComponent();
	    this.getContentPane().setBackground(Color.yellow);
	}
	private void addComponent()
	{
		String[] s= {"Admin","Voter"}; 
		j1 = new JLabel("WelCome To Online Voting System ");
		j1.setForeground(Color.RED);
		j1.setBounds(100,80,500,40);
		j1.setFont(new Font("Serif", Font.BOLD, 20));
		add(j1);
		j2 = new JLabel("Please Identify YourSelf Below");
		j2.setBounds(150,150,500,40);
		j2.setForeground(Color.blue);
		add(j2);
		cb = new JComboBox(s);
		cb.setBounds(180, 200, 120, 40);
		add(cb);
		b1= new JButton("Next");
		b1.setBounds(200, 270, 80, 40);
		add(b1);
		b1.addActionListener(new Reghndl());
		j3 = new JLabel("OR ");
		j3.setBounds(230,320,500,40);
		j3.setFont(new Font("Serif", Font.BOLD,12));
		add(j3);
		b2= new JButton("Registration");
		b2.setBounds(180, 360, 130, 40);
		add(b2);
		b2.addActionListener(new Reghndl());
	}
	public class Reghndl implements ActionListener 
	{
		String s1,s2;
		public void actionPerformed(ActionEvent e) {
			s1=e.getActionCommand();			
			if(s1.equals("Next"))
			{
				s2=cb.getSelectedItem().toString();
				if(s2=="Voter")
				{
					dispose();
					Regframe r = new Regframe();
					r.setVisible(true);
				}
				else if(s2=="Admin")
				{
					dispose();
					Login l = new Login();
					l.setVisible(true);
				}
			}
			else if(s1.equals("Registration"))
			{
				dispose();
				RegForm r = new RegForm();
				r.setVisible(true);
			}
			
		}
		
	}
	
	



}
