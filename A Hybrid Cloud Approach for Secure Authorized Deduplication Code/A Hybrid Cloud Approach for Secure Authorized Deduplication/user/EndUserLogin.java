import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
public class EndUserLogin extends JFrame implements ActionListener
{
	
	JPanel p1;
	
	JButton b1,b2;
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	
	public Font f3 = new Font("Times new roman", Font.BOLD, 18);
	public Font f1 = new Font("Times new roman", Font.BOLD + Font.ITALIC, 25);
	
	EndUserLogin()
	{
	
		setTitle("A Hybrid Cloud Approach for Secure Authorized Deduplication");
		p1=new JPanel();
		p1.setLayout(null);
		
		b1=new JButton("Submit");
		b1.setFont(f3);
		b2=new JButton("Reset");
		b2.setFont(f3);
		b1.setBounds(70,200,100,30);
		b2.setBounds(200,200,100,30);
		
		l1=new JLabel("UserName:");
		l1.setBounds(90,100,100,30);
		l1.setFont(f3);
		
		t1=new JTextField(18);
		t1.setBounds(180,100,100,20);
		
		l2=new JLabel("Password:");
		l2.setBounds(90,150,100,30);
		l2.setFont(f3);
		
		l3=new JLabel("Remote User Login");
		l3.setFont(f1);
		
		l3.setBounds(70,20,350,30);
		
		t2=new JPasswordField(20);
		
		
		
	t2.setBounds(180,150,100,20);
	
	
		p1.add(b1);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(l3);
		p1.add(b2);
		p1.add(t2);
	   	
		p1.setBackground(new Color(255,255,255));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		
		add(p1);
		
		setSize(380,300);
		setVisible(true);
		
	}
	public static void main(String[] args) 
	{
		//new RemoteUserLogin();
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EndUserLogin();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			String Username=t1.getText();
			String Password=t2.getText();
			
			
			
			
			String[] csserver = { "Select Cloud Server", "CS1", "CS2","CS3"};
			
			String cs = (String) JOptionPane.showInputDialog(null,
					"Select Cloud Server", "CloudName",
					JOptionPane.QUESTION_MESSAGE, null, csserver, csserver[0]);
			String ip=JOptionPane.showInputDialog("Enter CS Ip");
			
			if(cs.equalsIgnoreCase("CS1"))
			{
			
				try
				{
				Socket st=new Socket(ip,6699);
				
				DataOutputStream dos=new DataOutputStream(st.getOutputStream());
				dos.writeUTF(Username);
				dos.writeUTF(Password);
				
				
				DataInputStream din3 = new DataInputStream(st.getInputStream());
				String req = din3.readUTF();
				if(req.equalsIgnoreCase("SUCCESS"))
				{
					//new RemoteUser();
					try {
						UIManager
								.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							new EndUser();
						}
					});
				}
				if(req.equalsIgnoreCase("Failure"))
				{
					JOptionPane.showMessageDialog(null,"You R Not a Valid User");
				}
				
				
				}catch(Exception ec){System.out.println(ec);}
			}
			if(cs.equalsIgnoreCase("CS2"))
			{
			
				try
				{
				Socket st=new Socket(ip,7799);
				
				DataOutputStream dos=new DataOutputStream(st.getOutputStream());
				dos.writeUTF(Username);
				dos.writeUTF(Password);
				
				
				DataInputStream din3 = new DataInputStream(st.getInputStream());
				String req = din3.readUTF();
				if(req.equalsIgnoreCase("Success"))
				{
					//new RemoteUser();
					try {
						UIManager
								.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							new EndUser();
						}
					});
					
				}
				if(req.equalsIgnoreCase("failure"))
				{
					JOptionPane.showMessageDialog(null,"You R Not a Valid User");
				}
				
				
				}catch(Exception ec){System.out.println(ec);}
			}
			
			if(cs.equalsIgnoreCase("CS3"))
			{
			
				try
				{
				Socket st=new Socket(ip,8899);
				
				DataOutputStream dos=new DataOutputStream(st.getOutputStream());
				dos.writeUTF(Username);
				dos.writeUTF(Password);
				
				
				DataInputStream din3 = new DataInputStream(st.getInputStream());
				String req = din3.readUTF();
				if(req.equalsIgnoreCase("Success"))
				{
					//new RemoteUser();
					try {
						UIManager
								.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							new EndUser();
						}
					});
					
				}
				if(req.equalsIgnoreCase("failure"))
				{
					JOptionPane.showMessageDialog(null,"You R Not a Valid User");
				}
				
				
				}catch(Exception ec){System.out.println(ec);}
			}
		}
	}
		
}
	

