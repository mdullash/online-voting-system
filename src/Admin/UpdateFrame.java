package Admin;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.*;

import Admin.AddVoter.Handler;

public class UpdateFrame extends JFrame {
	
	String id;

	JLabel lbl,lblname,pass1,pass2,con;
	JTextField txtname;
	JButton jb;
	JPasswordField txtpass1,txtpass2;
	ImageIcon icon = new ImageIcon("src/resources/Icons/question.png");
	Image image = icon.getImage();
	Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);  
	ImageIcon icon2= new ImageIcon(newimg);
	ImageIcon icon3 = new ImageIcon("src/resources/Icons/successful.png");
	Image image2 = icon3.getImage();
	Image newimg2 = image2.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);  
	ImageIcon icon4= new ImageIcon(newimg2);
	public UpdateFrame(String s) {
		id=s;
		this.setSize(500,560);
		this.setTitle("Updating Voter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.addComponent();
	    this.getContentPane().setBackground(Color.yellow);
	}
	public void addComponent()
	{
		lbl = new  JLabel("Update Voter Below: ");
		lbl.setBounds(120,80, 300,20);
		add(lbl);
		lbl.setFont(new Font("Serif", Font.BOLD, 20));
		lbl.setForeground(Color.red);
	    
	    lblname =new JLabel("NAME : ");
	    lblname.setBounds(80,140, 60,20);
	    add(lblname);
	    
	    txtname =new JTextField(10);
	    txtname.setBounds(200,140,180 ,20);
	    add(txtname);
	    
	    pass1 =new JLabel("New Password : ");
	    pass1.setBounds(80,200,180,20);
	    add(pass1);
	    
	    txtpass1 =new JPasswordField(10);
	    txtpass1.setBounds(200,200,180 ,20);
	    add(txtpass1);
	    
	    pass2 =new JLabel("Confirm Password : ");
	    pass2.setBounds(80,280,180,20);
	    add(pass2);
	    
	    txtpass2 =new JPasswordField(10);
	    txtpass2.setBounds(200,280,180 ,20);
	    add(txtpass2);
	    
	    con =new JLabel();
	    con.setBounds(80,240,350,20);
	    con.setForeground(Color.red);
	    add(con);
	    
	    jb= new JButton("ADD");
	    jb.setBounds(200,380,80,40);
	    jb.addActionListener(new Handler());
	    add(jb);
	}
	public class Handler implements ActionListener
	{
		
		int ret=0;
		public void actionPerformed(ActionEvent e) {
			
			char[] c1=txtpass1.getPassword();  	//Password e getpassword char array return kore. 
			char[] c2=txtpass2.getPassword();
			if(c1.length>7)						//Eita 8 ta character er niche password nibe na
			{
				boolean b=Arrays.equals(c1, c2);
				if(b==true)
				{
					con.setText("");
					ret=JOptionPane.showConfirmDialog(null, "Are you sure you want to Continue?", "Are you sure",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon2);
					if(ret == JOptionPane.YES_OPTION)
					{
						
						String str1 = id;
						String str2 = txtname.getText();
						String str3 = txtpass1.getText();
					    
					    
						 
					       if (e.getSource() == jb)
					       {
					           try
					           {
					 
					               Class.forName("com.mysql.jdbc.Driver");
					 
					               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
					 
					               Statement st = con.createStatement();
					               //ResultSet rs = st.executeQuery("select FROM voter WHERE national_id=\"+str1+\"\"");
					               st.execute("UPDATE `voter` SET `name`='"+str2+"',`password`='"+str3+"' WHERE national_id='"+str1+"'");
					               boolean r=false;
					              
					 
					 
					                   //String val1 = rs.getString("national_id");
					                  
					                   
					                   
					                   //System.out.println(str2);
					                  
					                   
					                	   System.out.println("succesful login");
					                	   JOptionPane.showMessageDialog(null,"Voter Has Been Updated","Successful",JOptionPane.INFORMATION_MESSAGE, icon4);
											dispose();
					           			   r=true;
					           			   
					           			
					           			
					                  
					                   
					                   
					                   
					                   
					               
					               if(r==false) 
					               {
				                	   JOptionPane.showMessageDialog(null,"Wrong information");
				                   }
					           
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
					
						
				    }
						
					
					else if(ret == JOptionPane.NO_OPTION)
					{
						dispose();
						
					}	
				}
				else
				{
					con.setBounds(80,320,300,20);
					con.setText("Error !! Password Doesn't Match!!!");
					//Eita duita password jodi na mile den dekhabe..
				}
				
		}
	
		
	     else 
			{
				con.setText("Error !! Your Password Needs To be atleast 8 Characters");
				}
		
		}
		
	}

}
