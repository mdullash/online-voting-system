package Voter;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Admin.Login;
import Menu.StartFrame;


public class form extends JFrame {
	private JRadioButton jr1,jr2;
	private JButton b;
	private String s;
	private JLabel jl;
	private ButtonGroup grp;
	String id;
	public form(String s) 
	{
		id=s;
		this.setSize(500,560);
		this.setTitle("Voting Window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.addComponent();
	    this.getContentPane().setBackground(Color.yellow);
	}
	private void addComponent()
	{
		jr1=new JRadioButton("Green",false);
		jr2=new JRadioButton("Red",false);
		jr1.setBackground(Color.green);
		jr2.setBackground(Color.red);
		b =new JButton("VOTE");
		jr1.setBounds(120, 120, 80,30);
		jr2.setBounds(300, 120, 80, 30);
		b.setBounds(200, 280, 80, 40);
		this.add(jr2);
		this.add(jr1);
		this.add(b);
		grp = new ButtonGroup();
		grp.add(jr1);
		grp.add(jr2);
		jr1.addActionListener(new Handler());
		jr2.addActionListener(new Handler());
		b.addActionListener(new Votehndl());
		jl=new JLabel();
		jl.setBounds(200, 350, 100, 40);
		this.add(jl);
		
	}
	public class Handler implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) {
			s=e.getActionCommand();
			
		}
		
	}
	public class Votehndl implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) {
			String sr1=id;
			if(s=="Green")
				
			{
				jl.setText("Green Selected");
				//Eikhane ekta Variable diya Green er Vote Count korbi
			           try
			           {
			 
			               Class.forName("com.mysql.jdbc.Driver");
			 
			               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
			 
			               Statement st = con.createStatement();
			               ResultSet rs = st.executeQuery("select * from green");
			               boolean an=false;
			               while(rs.next()) 
			               {   
			            	   String val1 = rs.getString("natioal_id");
			            	   if(val1.equals(sr1))
			            	   {
			            		   an=true;
			            		   JOptionPane.showMessageDialog(null,"You already voted");
			            		   StartFrame s = new StartFrame();
			            		   s.setVisible(true);
			            		   dispose();
			            	   }
			               }
			               if(an ==false) 
			               {
			            	   st.execute("insert into green (natioal_id) values ('"+sr1+"')");
			               }
			               
			               //st.execute("insert into green (natioal_id) values ('"+sr1+"')");
			               //st.execute("INSERT INTO voter (national_id,name,password) VALUES ('"+str1+"', '"+str2+"', '"+str3+"')");
			               
			           } 
			           catch (SQLException ex)
			           {
			               System.out.print("exception is" + ex);
			           } 
			           catch (ClassNotFoundException ex)
			           {
			               System.out.print("exception is" + ex);
			           }
				
				
			       }
			       //JOptionPane.showMessageDialog(null,"Wrong information");
			
			else if(s=="Red")
			{
				jl.setText("Red Selected");
				//Eikhane ekta Variable diya Red er Vote Count korbi
				 try
		           {
		 
		               Class.forName("com.mysql.jdbc.Driver");
		 
		               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
		 
		               Statement st = con.createStatement();
		               ResultSet rs = st.executeQuery("select * from red");
		               boolean an=false;
		               while(rs.next()) 
		               {   
		            	   String val1 = rs.getString("national_id");
		            	   if(val1.equals(sr1))
		            	   {
		            		   an=true;
		            		   JOptionPane.showMessageDialog(null,"You already voted");
		            		   
		            		   StartFrame s = new StartFrame();
		            		   s.setVisible(true);
		            		   dispose();
		            	   }
		               }
		               if(an ==false) 
		               {
		            	   st.execute("insert into red (national_id) values ('"+sr1+"')");
		            	   StartFrame s = new StartFrame();
	            		   s.setVisible(true);
	            		   dispose();
		               }
		               //st.execute("insert into red (national_id) values ('"+sr1+"')");
		               //st.execute("INSERT INTO voter (national_id,name,password) VALUES ('"+str1+"', '"+str2+"', '"+str3+"')");
		               
		           } 
		           catch (SQLException ex)
		           {
		               System.out.print("exception is" + ex);
		           } 
		           catch (ClassNotFoundException ex)
		           {
		               System.out.print("exception is" + ex);
		           }
			
			
			}
			
		}
		
	}
}
	