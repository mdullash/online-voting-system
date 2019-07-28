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
import Voter.form;

public class Login extends JFrame{

	JLabel user,pass;
	JTextField txtuser;
	JPasswordField txtpass;
	JButton b,back;
	public Login() {
		this.setSize(500,560);
		this.setTitle("Admin Login Window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.addComponent();
	    this.getContentPane().setBackground(Color.yellow);
	}
	private void addComponent()
	{
	user= new  JLabel("UserName : ");
	user.setBounds(80,80, 180,20);
	add(user);
	
    txtuser=new JTextField(10);
    txtuser.setBounds(200,80 ,180,20);  
    add(txtuser);
    
    pass =new JLabel("Password : ");
    pass.setBounds(80,140,180,20);
    add(pass);
    
    txtpass =new JPasswordField(10);
    txtpass.setBounds(200,140,180 ,20);
    txtpass.addActionListener(new Loghndl());
    add(txtpass);
	
	
	
    b= new JButton("LOGIN");
    b.setBounds(200,280,90,25);
    b.addActionListener(new Loghndl());
    add(b);
    
    back= new JButton("BACK");
    back.setBounds(200,320,90,25);
    back.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) 
		{
			dispose();   
			StartFrame s = new StartFrame();
			s.setVisible(true);
		   }
		});
    add(back);
    
	}
	public class Loghndl implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) {
			//dispose();
			
			String str1 = txtuser.getText();
		    String str2 = txtpass.getText();
		    
		 
		       if (e.getSource() == b)
		       {
		           try
		           {
		 
		               Class.forName("com.mysql.jdbc.Driver");
		 
		               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
		 
		               Statement st = con.createStatement();
		               ResultSet rs = st.executeQuery("select * from admin");
		               boolean r=false;
		               while (rs.next())
		               {
		 
		 
		                   String val1 = rs.getString("user_name");
		                   String val2 = rs.getString("password");
		                   
		                   
		                   //System.out.println(str2);
		                  
		                   if (val2.equals(str2)  && val1.equals(str1) )
		                   {
		                	   System.out.println("succesful login");
		                	   dispose();   
		                	   OptFrame of = new OptFrame();
		           			   of.setVisible(true);
		           			   r=true;
		           			   System.out.println("succesful login");
		           			
		           			
		                  
		                   }
		                   
		                   
		                   
		               }
		               if(r==false) {
	                	   JOptionPane.showMessageDialog(null,"Wrong information");
	                   }
		           } catch (SQLException ex)
		           {
		               System.out.print("exception is" + ex);
		           } catch (ClassNotFoundException ex)
		           {
		               System.out.print("exception is" + ex);
		           }
			
			
		       }
		       //JOptionPane.showMessageDialog(null,"Wrong information");
		}
		
			
		}
		
	}



