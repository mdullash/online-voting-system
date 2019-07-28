package Admin;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;



public class Read extends JFrame{
	JLabel lbl,lblid;
	JTextField txtid;
	JButton jb;

	public Read() {
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
		lbl =new JLabel("Enter The Voter's National ID Below");
		lbl.setForeground(Color.RED);
		lbl.setBounds(100,80,500,40);
		lbl.setFont(new Font("Serif", Font.BOLD, 20));
		add(lbl);
		
	    
	    lblid =new JLabel("National ID : ");
	    lblid.setBounds(80,140, 120,20);
	    add(lblid);
	    
	    txtid =new JTextField(10);
	    txtid.setBounds(200,140,180 ,20);
	    add(txtid);
		
	    
	    jb= new JButton("Next");
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
			    
				String str1 = txtid.getText();
			    
			    
				 
			       if (e.getSource() == jb)
			       {
			           try
			           {
			 
			               Class.forName("com.mysql.jdbc.Driver");
			 
			               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
			 
			               Statement st = con.createStatement();
			               ResultSet rs = st.executeQuery("select * FROM voter WHERE national_id="+str1+"");
			               boolean r=false;
			               while (rs.next())
			               {
			 
			 
			                   String val1 = rs.getString("national_id");
			                   String val2 = rs.getString("name");
			                   String val3 = rs.getString("password");
			                  
			                   
			                   
			                   //System.out.println(str2);
			                  
			                   
			                	   System.out.println("succesful login");
			                	   dispose();
			       				Readnext uf=new Readnext(val1,val2,val3);
			       				uf.setVisible(true);
			           			   r=true;
			           			   
			           			
			           			
			                  
			                   
			                   
			                   
			                   
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
