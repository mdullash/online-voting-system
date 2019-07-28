package Registration;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import Menu.StartFrame;
import Voter.form;

public class RegForm extends JFrame {
	JLabel name,pass1,pass2,Nid,con;
	JTextField txtname,txtNid;
	JPasswordField txtpass1,txtpass2;
	JButton b, back1;

	public RegForm() {
		this.setSize(500,560);
		this.setTitle("Registration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.getContentPane().setBackground(Color.yellow);
	    this.addComponent();
	}
	private void addComponent()
	{
	name= new  JLabel("Name : ");
	name.setBounds(80,80, 180,20);
	add(name);
    txtname=new JTextField(10);
    txtname.setBounds(200,80 ,180,20);  
    add(txtname);
    Nid= new  JLabel("National ID : ");
	Nid.setBounds(80,110,180,20);
	add(Nid);
    txtNid=new JTextField(10);
    txtNid.setBounds(200,110 ,180,20);  
    add(txtNid);
    pass1 =new JLabel("Password : ");
    pass1.setBounds(80,140,180,20);
    add(pass1);
    txtpass1 =new JPasswordField(10);
    txtpass1.setBounds(200,140,180 ,20);
    add(txtpass1);
    pass2 =new JLabel("Confirm Password : ");
    pass2.setBounds(80,170,180,20);
    add(pass2);
    txtpass2 =new JPasswordField(10);
    txtpass2.setBounds(200,170,180 ,20);
    add(txtpass2);
    con =new JLabel();
    con.setBounds(80,230,300,20);
    add(con);
	
    b= new JButton("Confirm");
    b.setBounds(200,280,90,25);
    b.addActionListener(new Reghndl());
    add(b);
    
    
    back1= new JButton("BACK");
    back1.setBounds(200,350,90,25);
    add(back1);
    back1.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) 
		{
			dispose();   
			StartFrame s = new StartFrame();
			s.setVisible(true);
		   }
		});
   
    
	}
	public class Reghndl implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) {
			String s1=txtname.getText();
			if(s1.length()>5 ){
				/*boolean bl;
				
				bl=isNumeric(s1);
				if(bl==true) { 
					con.setText("Name should be String");
				}
				else {
				
					
				}*/
					
				
				String s2=txtNid.getText();
				if(s2.length()>5) {
					char[] c1=txtpass1.getPassword();  	//Password e getpassword char array return kore. 
					char[] c2=txtpass2.getPassword();
					if(c1.length>7)						//Eita 8 ta character er niche password nibe na
					{
						boolean b=Arrays.equals(c1, c2);
						if(b==true)
						{
							dispose();
							Confirm c=new Confirm();
							c.setVisible(true);
							
							String str1 = txtNid.getText();
						       String str2 = txtname.getText();
						       String str3=txtpass1.getText();
						 
						           try
						           {
						 
						               Class.forName("com.mysql.jdbc.Driver");
						 
						               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
						 
						               Statement st = con.createStatement();
						               st.execute("INSERT INTO voter (national_id,name,password) VALUES ('"+str1+"', '"+str2+"', '"+str3+"')");
						              
						           } catch (SQLException ex)
						           {
						               System.out.print("exception is" + ex);
						           } catch (ClassNotFoundException ex)
						           {
						               System.out.print("exception is" + ex);
						           }
							
						}
						else
						{
							con.setText("Password Doesn't Match!!!");
							//Eita duita password jodi na mile den dekhabe..
						}
					}
						
						else { 
							con.setText("Your Password Needs To be atleast 8 Characters...");
						}
						
						
					      
					
				}
				else
				{
					con.setText("NID Length is Too Small..!!");
					//JOptionPane.showMessageDialog(null,"NID Length is Too Small..!!");
					
				}
				
			}
			
			else
			{
				con.setText("Name Length is Too Small..!!");
				//JOptionPane.showMessageDialog(null,"Name Length is Too Small..!!");
				
			}
			
			
				
			}
			
		}
	/*public  static boolean isNumeric(String str)
	  {
	    try
	    {
	      double d = Double.parseDouble(str);
	    }
	    catch(NumberFormatException nfe)
	    {
	      return false;
	    }
	    return true;
	  }*/
		
	}

