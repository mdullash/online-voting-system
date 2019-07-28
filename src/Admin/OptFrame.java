package Admin;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import Menu.StartFrame;

public class OptFrame extends JFrame {
	JLabel jl,jl2;
	JButton jb1,jb2,jb3,jb4,jb5;
	public OptFrame()
	{
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
		jl = new JLabel("Please Choose a Option Below ");
		jl.setBounds(120,100,500,40);
		jl.setFont(new Font("Serif", Font.BOLD, 20));
		jl.setForeground(Color.red);
		add(jl);
		jb1 = new JButton("Add Voter");
		jb1.setBounds(200, 150, 120, 40);
		add(jb1);
		jb2 = new JButton("Delete Voter");
		jb2.setBounds(200, 200, 120, 40);
		add(jb2);
		
		jb3 = new JButton("Update Voter");
		jb3.setBounds(200, 250, 120, 40);
		add(jb3);
		
		jb4 = new JButton("Read Voter");
		jb4.setBounds(200, 300, 120, 40);
		add(jb4);
		
		jb5 = new JButton("Election Result");
		jb5.setBounds(200, 350, 120, 40);
		add(jb5);
		
		JButton back= new JButton("LOG OUT");
	    back.setBounds(200,400,120,40);
	    back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) 
			{
				dispose();   
				Login s = new Login();
				s.setVisible(true);
			   }
			});
	    add(back);
		
		jb1.addActionListener(new Handler());
		jb2.addActionListener(new Handler());
		jb3.addActionListener(new Handler());
		jb4.addActionListener(new Handler());
		jb5.addActionListener(new Handler());
		jl2 = new JLabel();
		jl2.setBounds(200, 350, 180, 40);
		add(jl2);
	}
	public class Handler implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(s.equals("Add Voter"))
			{
				dispose();
				AddVoter av= new AddVoter();
				av.setVisible(true);
			}
			else if(s.equals("Delete Voter"))
			{
				dispose();
				DeleteVoter dv= new DeleteVoter();
				dv.setVisible(true);
			}
			else if(s.equals("Update Voter"))
			{
				dispose();
				Update u=new Update();
				u.setVisible(true);
			}
			else if(s.equals("Read Voter"))
			{
				dispose();
				Read r=new Read();
				r.setVisible(true);
			}
			else if(s.equals("Election Result"))
			{
				jl2.setText("Result Selected");
				int resgreen=0;
				int resred=0;
				
				 try
		           {
		 
		               Class.forName("com.mysql.jdbc.Driver");
		 
		               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
		 
		               Statement st = con.createStatement();
		               ResultSet rs = st.executeQuery("select * from green");
		               //st.execute("insert into green (natioal_id) values ('"+sr1+"')");
		               
		               while(rs.next()) 
		               {   
		            	  
		            	  resgreen++;
		               }
		               rs = st.executeQuery("select * from red");
		               //st.execute("insert into green (natioal_id) values ('"+sr1+"')");
		               
		               while(rs.next()) 
		               {   
		            	  
		            	  resred++;
		               }
		               Result r1 = new Result(resgreen,resred);
            		   r1.setVisible(true);
            		   dispose();
		               
		               
		               
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