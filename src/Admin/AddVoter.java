package Admin;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.*;

import Registration.Confirm;


public class AddVoter extends JFrame {

	JLabel lblid,lblname,pass1,pass2,con;
	JTextField txtid,txtname;
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
	
	public AddVoter() {
		this.setSize(500,560);
		this.setTitle("Adding Voter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.addComponent();
	    this.getContentPane().setBackground(Color.yellow);
	}
	public void addComponent()
	{
		lblid = new  JLabel("National ID : ");
		lblid.setBounds(80,80, 180,20);
		add(lblid);
		
	    txtid=new JTextField(10);
	    txtid.setBounds(200,80 ,180,20);  
	    add(txtid);
	    
	    lblname =new JLabel("NAME : ");
	    lblname.setBounds(80,140, 60,20);
	    add(lblname);
	    
	    txtname =new JTextField(10);
	    txtname.setBounds(200,140,180 ,20);
	    add(txtname);
	    
	    pass1 =new JLabel("Password : ");
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
	    
	    JButton back= new JButton("BACK");
	    back.setBounds(200,450,80,40);
	    back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) 
			{
				dispose();   
				//Login s = new Login();
				//s.setVisible(true);
				OptFrame f1=new OptFrame();
				f1.setVisible(true);
			   }
			});
	    add(back);
	}
	public class Handler implements ActionListener
	{
		
		int ret=0;
		public void actionPerformed(ActionEvent e) 
		{
			
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
						
						String s1=txtname.getText();
						if(s1.length()>5 )
						{
							/*boolean bl;
							
							bl=isNumeric(s1);
							if(bl==true) { 
								con.setText("Name should be String");
							}
							else {
							
								
							}*/
								
							
							String s2=txtid.getText();
							if(s2.length()>5)
							{
								char[] d1=txtpass1.getPassword();  	//Password e getpassword char array return kore. 
								char[] d2=txtpass2.getPassword();
								if(d1.length>7)						//Eita 8 ta character er niche password nibe na
								{
									boolean d=Arrays.equals(d1, d2);
									if(d==true)
									{
										JOptionPane.showMessageDialog(null,"Voter Has Been Added","Successful",JOptionPane.INFORMATION_MESSAGE, icon4);
										dispose();
										
										String str1 = txtid.getText();
									       String str2 = txtname.getText();
									       String str3=txtpass1.getText();
									 
									           try
									           {
									 
									               Class.forName("com.mysql.jdbc.Driver");
									 
									               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
									 
									               Statement st = con.createStatement();
									               st.execute("INSERT INTO voter (national_id,name,password) VALUES ('"+str1+"', '"+str2+"', '"+str3+"')");
									              
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
									else
									{
										con.setText("Password Doesn't Match!!!");
										//Eita duita password jodi na mile den dekhabe..
									}
								}
									
									else 
									{ 
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
		
			else { 
				con.setText("Error !! Your Password Needs To be atleast 8 Characters");
			}
		}
		
	}
}

