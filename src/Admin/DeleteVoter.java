package Admin;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import Admin.AddVoter.Handler;

public class DeleteVoter extends JFrame {
	JLabel lbl,lblid;
	JTextField txtid;
	JButton jb;
	ImageIcon icon = new ImageIcon("src/resources/Icons/question.png");
	Image image = icon.getImage();
	Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);  
	ImageIcon icon2= new ImageIcon(newimg);
	ImageIcon icon3 = new ImageIcon("src/resources/Icons/Delete.png");
	Image image2 = icon3.getImage();
	Image newimg2 = image2.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);  
	ImageIcon icon4= new ImageIcon(newimg2);

	public DeleteVoter() {
		this.setSize(500,560);
		this.setTitle("Deleting Voter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	    this.setLayout(null);
	    this.addComponent();
	    this.getContentPane().setBackground(Color.yellow);
	}
	public void addComponent()
	{
		lbl =new JLabel("Enter The Voter National ID Below");
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
		
	    
	    jb= new JButton("Delete");
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
		
		int ret=0;
		public void actionPerformed(ActionEvent e) {
			ret=JOptionPane.showConfirmDialog(null, "Are you sure you want to Continue?", "Are you sure",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon2);
			if(ret == JOptionPane.YES_OPTION)
			{
				JOptionPane.showMessageDialog(null,"Voter Has Been Deleted","Deletion Message",JOptionPane.INFORMATION_MESSAGE, icon4);
				dispose();
				DeleteVoter d1=new DeleteVoter();
				d1.setVisible(true);
				String str1 = txtid.getText();
			   
			    
			 
			       if (e.getSource() == jb)
			       {
			           try
			           {
			 
			               Class.forName("com.mysql.jdbc.Driver");
			 
			               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "");
			 
			               Statement st = con.createStatement();
			               st.execute("DELETE FROM voter WHERE national_id="+str1+"");
			               
			               
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
				DeleteVoter d1=new DeleteVoter();
				d1.setVisible(true);
				
			}
		}
		
	}

}
