import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class OwnerLogin extends JFrame implements ActionListener
{
	Font f1 = new Font("Times new Roman",Font.BOLD,16);
	Container c;
	JButton j1,j2;
	JLabel a1,a2,a3;
	JTextField t1;
	JPasswordField p1;
	File path;
	String path1;
	String content;
	String username,password;
	OwnerLogin()
	{
		
		c = getContentPane();
		c.setLayout(null);
		
		setTitle("OwnerLogin");
		a3 = new JLabel("Owner Login!!!!!!!!!!");
		a3.setFont(f1);
		a3.setBounds(100,20,200,100);
		c.add(a3);
		a1 = new JLabel("Username");
		a1.setFont(f1);
		a1.setBounds(50,100,80,30);
		c.add(a1);
		a2 = new JLabel("Password");
		a2.setFont(f1);
		a2.setBounds(50,150,80,30);
		c.add(a2);
		t1 = new JTextField(20);
		t1.setBounds(150,100,100,30);
		c.add(t1);
		p1 = new JPasswordField(20);
		p1.setBounds(150,150,100,30);
		c.add(p1);
		j2 = new JButton("Submit");
		j2.setBounds(80,220,80,30);
		j2.addActionListener(this);
		j2.setFont(f1);
		c.add(j2);
		j1 = new JButton("Reset");
		j1.setBounds(180,220,80,30);
		j1.addActionListener(this);
		j1.setFont(f1);
		c.add(j1);
		
		setSize(350,320);
		setVisible(true);
		c.setBackground(Color.WHITE);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		username = t1.getText();
		password= p1.getText();
		if(e.getSource()==j2)
		{
			
			String[] csserver = { "Select Cloud Server", "CS1", "CS2", "CS3" };
			
			String cloudname = (String) JOptionPane.showInputDialog(null,
					"Select Cloud Server", "CloudName",
					JOptionPane.QUESTION_MESSAGE, null, csserver, csserver[0]);
			
			if(cloudname.equalsIgnoreCase("CS1"))
			{
			
			String ip = JOptionPane.showInputDialog("Enter The Cloud Ip Address");
			try
			{
				System.out.println("Data Sent");
			Socket sc = new Socket(ip,500);
			DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
			dout.writeUTF(username);
			dout.writeUTF(password);
			
			DataInputStream din = new DataInputStream(sc.getInputStream());
			String msg = din.readUTF();
			if(msg.equalsIgnoreCase("success"))
			{
				System.out.println("success");
			//new DataOwner(username);
			try {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new Owner(username);
				}
			});
			
				
			}
			else if(msg.equalsIgnoreCase("failure"))
			{
				System.out.println("failure");
				JOptionPane.showMessageDialog(null,"UnAuthorised User");
			}
			
			
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			}
			else if(cloudname.equalsIgnoreCase("CS2"))
			{
				
				username = t1.getText();
				password= p1.getText();
				String ip = JOptionPane.showInputDialog("Enter The Cloud Ip Address");
				try
				{
					System.out.println("Data Sent");
				Socket sc = new Socket(ip,550);
				DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				dout.writeUTF(username);
				dout.writeUTF(password);
				
				DataInputStream din = new DataInputStream(sc.getInputStream());
				String msg = din.readUTF();
				if(msg.equalsIgnoreCase("success"))
				{
					System.out.println("success");
				//new DataOwner(username1);
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Owner(username);
					}
				});
					
				}
				else if(msg.equalsIgnoreCase("failure"))
				{
					System.out.println("failure");
					JOptionPane.showMessageDialog(null,"UnAuthorised User");
				}
				
				
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
			}
			
			else if(cloudname.equalsIgnoreCase("CS3"))
			{
				
				username = t1.getText();
				password= p1.getText();
				String ip = JOptionPane.showInputDialog("Enter The Cloud Ip Address");
				try
				{
					System.out.println("Data Sent");
				Socket sc = new Socket(ip,560);
				DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				dout.writeUTF(username);
				dout.writeUTF(password);
				
				DataInputStream din = new DataInputStream(sc.getInputStream());
				String msg = din.readUTF();
				if(msg.equalsIgnoreCase("success"))
				{
					System.out.println("success");
				//new DataOwner(username1);
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Owner(username);
					}
				});
					
				}
				else if(msg.equalsIgnoreCase("failure"))
				{
					System.out.println("failure");
					JOptionPane.showMessageDialog(null,"UnAuthorised User");
				}
				
				
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
			}
			
		}
		if(e.getSource()==j1)
		{
			
			t1.setText(null);
			p1.setText(null);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		//new OwnerLogin();
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new OwnerLogin();
			}
		});
	}

}
