package Admin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Menu.StartFrame;



public class Result extends JFrame{
	JLabel lbl,lblid;
	JTextField txtid;
	JButton jb;
	int resgreen;
	int resred;
	

	public Result(int a, int b) {
		resgreen=a;
		resred=b;
		
		this.setSize(500,560);
		this.setTitle("Result Section");
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
		JLabel myText = new JLabel("Number of vote for Green: "+resgreen);
		myText.setForeground(Color.RED);
		myText.setBounds(100,120,500,40);
		myText.setFont(new Font("Serif", Font.BOLD, 20));
		add(myText);
		
		JLabel myText1 = new JLabel("Number of vote for Red: "+resred);
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
	    
	    JButton back= new JButton("BACK");
	    back.setBounds(200,400,80,40);
	    back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) 
			{
				dispose();   
				OptFrame f1=new OptFrame();
				f1.setVisible(true);
			   }
			});
	    add(back);
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