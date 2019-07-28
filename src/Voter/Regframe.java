package Voter;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Menu.StartFrame;




public class Regframe extends JFrame {
        
	JLabel lblid,lblname,lblcon;
	JTextField txtid,txtname,txtcon;
	JButton btnSave,back;
	
	public Regframe()
	{
		this.setSize(500,560);
		this.setTitle("Voter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.getContentPane().setBackground(Color.yellow);
	    this.addComponent();
	}
	
	private void addComponent()
	{
	lblid = new  JLabel("National ID : ");
	lblid.setBounds(80,80, 180,20);
	add(lblid);
    txtid=new JTextField(10);
    txtid.setBounds(200,80 ,180,20);  
    add(txtid);
    txtid.addActionListener(new Reghndl());
    
    lblname =new JLabel("NAME : ");
  lblname.setBounds(80,140, 60,20);
    add(lblname);
    txtname =new JTextField(10);
    txtname.setBounds(200,140,180 ,20);
    txtname.addActionListener(new Reghndl());
    add(txtname);
	
    lblcon =new JLabel("Password :");
    lblcon.setBounds(80, 200, 150,20);
    add(lblcon);
    txtcon =new JTextField(10);
    txtcon.setBounds(200, 200, 180, 20);
    txtcon.addActionListener(new Reghndl());
    add(txtcon);
	
	
    btnSave= new JButton("LOGIN");
    btnSave.setBounds(200,280,90,25);
    btnSave.addActionListener(new Reghndl());
    add(btnSave);
    
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
	public class Reghndl implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) {
			
			String str1 = txtid.getText();
		       String str2 = txtname.getText();
		       String str3=txtcon.getText();
		 
		       if (e.getSource() == btnSave)
		       {
		           try
		           {
		 
		               Class.forName("com.mysql.jdbc.Driver");
		 
		               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
		 
		               Statement st = con.createStatement();
		               ResultSet rs = st.executeQuery("select * from voter");
		               boolean r=false;
		               while (rs.next())
		               {
		 
		 
		                   String val1 = rs.getString("national_id");
		                   String val2 = rs.getString("name");
		                   String val3 = rs.getString("password");
		                   
		                   //System.out.println(str2);
		                  
		                   if (val2.equals(str2) && val3.equals(str3) && val1.equals(str1) )
		                   {
		                    
		                	   dispose();   
		                   System.out.println("login success");
		                   form f =new form(val1);
		           			f.setVisible(true);
		           			r=true;
		           			
		           			
		                  
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