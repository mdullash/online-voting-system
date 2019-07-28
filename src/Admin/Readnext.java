package Admin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Menu.StartFrame;



public class Readnext extends JFrame{
	JLabel lbl,lblid;
	JTextField txtid;
	JButton jb;
	String id, name, password;

	public Readnext(String s,String s2, String s3) {
		id=s;
		name=s2;
		password=s3;
		this.setSize(500,560);
		this.setTitle("Reading Voter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.addComponent();
	    this.getContentPane().setBackground(Color.yellow);
	}
	public void addComponent()
	{
		lbl =new JLabel("These are the informations you seek");
		lbl.setForeground(Color.RED);
		lbl.setBounds(100,80,500,40);
		lbl.setFont(new Font("Serif", Font.BOLD, 20));
		add(lbl);
		//label.setText(String.valueOf(variable));
		JLabel myText = new JLabel("NAME: "+name);
		myText.setForeground(Color.RED);
		myText.setBounds(100,120,500,40);
		myText.setFont(new Font("Serif", Font.BOLD, 20));
		add(myText);
		
		JLabel myText1 = new JLabel("PASSWORD: "+password);
		myText1.setForeground(Color.RED);
		myText1.setBounds(100,140,500,40);
		myText1.setFont(new Font("Serif", Font.BOLD, 20));
		add(myText1);
	    
	    //lblid =new JLabel("National ID : ");
	    //lblid.setBounds(80,140, 120,20);
	    //add(lblid);
	    
	    //txtid =new JTextField(10);
	    //txtid.setBounds(200,140,180 ,20);
	    //add(txtid);
		
	    
	    jb= new JButton("Main");
	   jb.setBounds(200,300,80,40);
	    jb.addActionListener(new Handler());
	    add(jb);
	}
	public class Handler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) {
			dispose();
			StartFrame s = new StartFrame();
				s.setVisible(true);
				
				
			}
		}


}